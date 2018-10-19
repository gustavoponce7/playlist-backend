package com.gpch.playlistbackend.model;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.dto.SongDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String artist;
    private String url;
    @ManyToMany(mappedBy="songs", fetch = FetchType.EAGER)
    private List<Playlist> playlists;

    public SongDTO toDto(){
        return SongDTO.builder()
                .id(this.id)
                .name(this.name)
                .artist(this.artist)
                .url(this.url)
                .playlists(playlists.stream()
                        .map(playlist -> PlaylistDTO.builder()
                                            .id(playlist.getId())
                                            .name(playlist.getName())
                                            .description(playlist.getDescription())
                                            .build())
                                            .collect(Collectors.toList()))
                .build();
    }

    /*public SongDTO toDto(){
        ModelMapper modelMapper = new ModelMapper();
        SongDTO dto = modelMapper.map(this, SongDTO.class);
        return dto;
    }*/
}
