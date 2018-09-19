package com.gpch.playlistbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName="id")
    )
    private List<Song> songs;
}
