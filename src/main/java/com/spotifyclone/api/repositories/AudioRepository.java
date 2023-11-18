package com.spotifyclone.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotifyclone.api.models.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long> {
    List<Audio> findByName(String name);
}
