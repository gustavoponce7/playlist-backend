package com.gpch.playlistbackend.service;

import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Transactional
    public Song createSong(SongDTO songDTO){
        return songRepository.save(Song.builder()
                                .name(songDTO.getName())
                                .artist(songDTO.getArtist())
                                .url(songDTO.getUrl())
                                .playlists(Collections.emptyList())
                                .build());
    }

    public List<Song> getSongs(){
        return songRepository.findAll();
    }

    public Song getSongById(Integer songId){
        return songRepository.findById(songId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void deleteSongById(Integer songId){
       songRepository.deleteById(songId);
    }

    //NOTE: if @Transactional annotation exists at method level no need to call save method to persist the information
    @Transactional
    public Song updateSong(Integer songId, SongDTO songDTO){
        Song song = songRepository.findById(songId)
                .orElseThrow(IllegalArgumentException::new);
        song.setArtist(songDTO.getArtist());
        song.setName(songDTO.getName());
        song.setUrl(songDTO.getUrl());
        return song;
    }

}
