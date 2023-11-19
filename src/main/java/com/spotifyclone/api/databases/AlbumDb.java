package com.spotifyclone.api.databases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spotifyclone.api.models.Album;
import com.spotifyclone.api.repositories.AlbumRepository;

@Configuration
public class AlbumDb {
    @Bean
    CommandLineRunner initAlbumDatabase(AlbumRepository albumRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                
                // albumRepository.save(new Album("Top Việt Nam", new ArrayList<Long>(Arrays.asList(1L, 2L)), new Date(), "http://localhost:8080/upload/files/vn.png"));
                // albumRepository.save(new Album("Top Âu Mỹ", new ArrayList<Long>(Arrays.asList(3L)), new Date(), "http://localhost:8080/upload/files/usuk.png"));
            }
        };
    }
}
