package com.gpch.playlistbackend.controller;

import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public List<SongDTO> getSongslist(){
        return songService.getSongslists().stream().map(Song::toDto).collect(Collectors.toList());
    }
}
