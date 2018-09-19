package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/playlists")
    public List<Map<String, Object>> getPlaylists(){
        return playlistService.getPlaylists().stream().map(Playlist::toDto).collect(Collectors.toList());
    }
}
