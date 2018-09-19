package com.gpch.playlistbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @ManyToMany(mappedBy="songs")
    private List<Playlist> playlists;

    public Map<String, Object> toDto(){
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", this.id);
        dto.put("name", this.name);
        dto.put("artist", this.artist);
        dto.put("url", this.url);
        return dto;
    }
}
