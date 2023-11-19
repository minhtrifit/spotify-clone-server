package com.spotifyclone.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotifyclone.api.models.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByName(String name);
}
