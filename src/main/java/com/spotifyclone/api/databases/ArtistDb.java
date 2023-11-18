package com.spotifyclone.api.databases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spotifyclone.api.models.Artist;
import com.spotifyclone.api.repositories.ArtistRepository;

@Configuration
public class ArtistDb {
    @Bean
    CommandLineRunner initArtistDatabase(ArtistRepository artistRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                artistRepository.save(new Artist(1, "Miina", 3213));
                artistRepository.save(new Artist(2, "Umie", 4691));
                artistRepository.save(new Artist(2, "Taylor Swift", 210497));

            }
        };
    }
}
