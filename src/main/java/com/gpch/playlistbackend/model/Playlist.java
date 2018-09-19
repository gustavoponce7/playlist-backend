package com.gpch.playlistbackend.model;

import com.gpch.playlistbackend.dto.PlaylistDTO;
import com.gpch.playlistbackend.dto.SongDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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
            joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id")
    )
    private List<Song> songs;

    public PlaylistDTO toDto() {
        return PlaylistDTO.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .songs(songs.stream()
                        .map(song -> SongDTO.builder()
                                .id(song.getId())
                                .name(song.getName())
                                .artist(song.getArtist())
                                .url(song.getUrl())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}