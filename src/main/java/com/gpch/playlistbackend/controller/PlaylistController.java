package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/playlists", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaylistController {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<PlaylistDTO> getPlaylists(){
        return playlistService.getPlaylists();
    }
}
