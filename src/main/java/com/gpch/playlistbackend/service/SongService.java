package com.gpch.playlistbackend.service;

import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song createSong(Song song){
        return songRepository.save(song);
    }

    public List<Song> getSongslists(){
        return songRepository.findAll();
    }

}
