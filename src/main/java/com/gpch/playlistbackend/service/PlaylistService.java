package com.gpch.playlistbackend.service;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlayList(Playlist playlist){
        return playlistRepository.save(playlist);
    }

    public List<PlaylistDTO> getPlaylists(){
        return  playlistRepository.findAll().stream()
                .map(Playlist::toDto).collect(Collectors.toList());
    }
}
