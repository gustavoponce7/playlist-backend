package com.gpch.playlistbackend.repository;

import com.gpch.playlistbackend.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
