package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return playlistService.getPlaylists().stream()
                .map(Playlist::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{playlistId}")
    public PlaylistDTO getPlaylist(@PathVariable Integer playlistId){
        return playlistService.getPlaylist(playlistId).toDto();
    }

    @DeleteMapping("/{playlistId}")
    public void deletePlaylist(@PathVariable Integer playlistId){
        playlistService.deletePlaylistById(playlistId);
    }

    @PostMapping
    public PlaylistDTO createPlaylist(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.createPlaylist(playlistDTO).toDto();
    }

    @PutMapping
    public PlaylistDTO updatePlaylist(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.updatePlaylist(playlistDTO).toDto();
    }

    @PostMapping(("/{playlistId}/song"))
    public PlaylistDTO addSongToPlaylist(@PathVariable Integer playlistId, @RequestBody SongDTO songDTO){
        return playlistService.addSongToPlaylist(playlistId, songDTO).toDto();
    }

    @DeleteMapping(("/{playlistId}/song"))
    public PlaylistDTO removeSongToPlaylist(@PathVariable Integer playlistId, @RequestBody SongDTO songDTO){
        return playlistService.removeSongFromPlaylist(playlistId, songDTO).toDto();
    }

}
