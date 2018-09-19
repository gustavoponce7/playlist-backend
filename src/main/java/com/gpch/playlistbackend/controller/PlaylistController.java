package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/playlists")
    public List<Playlist> getPlaylists(){
        return playlistService.getPlaylists();
    }
}
