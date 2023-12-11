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
                
                // artistRepository.save(new Artist(
                //     1,
                //     "Miina",
                //     3213,
                //     "http://localhost:8080/upload/files/1.png"));

                // artistRepository.save(new Artist(
                //     2,
                //     "Umie",
                //     4691,
                //     "http://localhost:8080/upload/files/2.png"));

                // artistRepository.save(new Artist(
                //     3,
                //     "Taylor Swift",
                //     210497,
                //     "http://localhost:8080/upload/files/3.png"));

                // artistRepository.save(new Artist(
                //     4,
                //     "RPT MCK",
                //     97160,
                //     "http://localhost:8080/upload/files/4.png"));

                // artistRepository.save(new Artist(
                //     5,
                //     "Binz",
                //     389233 ,
                //     "http://localhost:8080/upload/files/5.png"));
                
                // artistRepository.save(new Artist(
                //     6,
                //     "Amee",
                //     407802,
                //     "http://localhost:8080/upload/files/6.png"));

            }
        };
    }
}
