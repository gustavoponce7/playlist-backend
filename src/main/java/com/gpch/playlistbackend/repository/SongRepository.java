package com.gpch.playlistbackend.repository;

import com.gpch.playlistbackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
}
