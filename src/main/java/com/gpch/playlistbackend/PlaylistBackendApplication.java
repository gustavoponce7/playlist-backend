package com.gpch.playlistbackend;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.dto.SongDTO;
import com.gpch.playlistbackend.model.Playlist;
import com.gpch.playlistbackend.model.Song;
import com.gpch.playlistbackend.service.PlaylistService;
import com.gpch.playlistbackend.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@SpringBootApplication
public class PlaylistBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaylistBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(SongService songService,
                                  PlaylistService playlistService) {
        return (args) -> {
            //Playlist Let's get high
            Song song1 = songService.createSong(SongDTO.builder()
                    .name("One Love")
                    .artist("Bob Marley")
                    .url("https://www.youtube.com/watch?v=1PDdCmJ84LI")
                    .playlists(Collections.emptyList())
                    .build());

            Playlist playlist1 = playlistService.createPlaylist(PlaylistDTO.builder().name("Reggae").description("Let's get high").songs(Collections.emptyList()).build());
        };
    }
}
