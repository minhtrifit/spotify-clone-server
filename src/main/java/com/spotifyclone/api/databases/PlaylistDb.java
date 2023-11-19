package com.spotifyclone.api.databases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spotifyclone.api.repositories.PlaylistRepository;

@Configuration
public class PlaylistDb {
    @Bean
    CommandLineRunner initPlaylistDatabase(PlaylistRepository playlistRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                
            }
        };
    }
}
