package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/songs", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<SongDTO> getSongs(){
        return songService.getSongs()
                .stream().map(Song::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{songId}")
    public SongDTO getSong(@PathVariable Integer songId){
        return songService.getSongById(songId).toDto();
    }

    @DeleteMapping("/{songId}")
    public void deleteSong(@PathVariable Integer songId){
        songService.deleteSongById(songId);
    }

    @PostMapping
    public SongDTO createSong(@RequestBody SongDTO songDTO){
        return songService.createSong(songDTO).toDto();
    }

    @PutMapping
    public SongDTO updateSong(@RequestBody SongDTO songDTO){
        return songService.updateSong(songDTO).toDto();
    }
}
