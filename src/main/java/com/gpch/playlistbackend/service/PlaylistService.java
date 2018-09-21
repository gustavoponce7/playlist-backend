package com.gpch.playlistbackend.service;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.repository.PlaylistRepository;
import com.gpch.playlistbackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Transactional
    public Playlist createPlaylist(PlaylistDTO playlistDTO){
        return playlistRepository.save(Playlist.builder()
                .name(playlistDTO.getName())
                .description(playlistDTO.getDescription())
                .songs(Collections.emptyList())
                .build());
    }

    public List<Playlist> getPlaylists(){
        return  playlistRepository.findAll();
    }

    public Playlist getPlaylist(Integer playlistId){
        return playlistRepository.findById(playlistId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void deletePlaylistById(Integer playlistId){
        playlistRepository.deleteById(playlistId);
    }

    @Transactional
    public Playlist updatePlaylist(Integer playlistId, PlaylistDTO playlistDTO){
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(IllegalArgumentException::new);
        playlist.setName(playlistDTO.getName());
        playlist.setDescription(playlistDTO.getDescription());
        return playlistRepository.save(playlist);
    }

    @Transactional
    public Playlist addSongToPlaylist(Integer playlistId, SongDTO songDTO){
        Song song = songRepository.findById(songDTO.getId())
                .orElseThrow(IllegalArgumentException::new);
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(IllegalArgumentException::new);
        if (!songExistsInPlaylist(playlist, song)) {
            playlist.getSongs().add(song);
            return playlistRepository.save(playlist);
        }
        return playlist;
    }

    @Transactional
    public Playlist removeSongFromPlaylist(Integer playlistId, SongDTO songDTO){
        Song song = songRepository.findById(songDTO.getId())
                .orElseThrow(IllegalArgumentException::new);
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(IllegalArgumentException::new);
        if (songExistsInPlaylist(playlist, song)){
            playlist.getSongs().remove(song);
            return playlistRepository.save(playlist);
        }
        return playlist;
    }

    //Validate if the song exists in theplaylist
    public boolean songExistsInPlaylist(Playlist playlist, Song song){
        return playlist.getSongs().contains(song);
    }
}
