package com.spotifyclone.api.databases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import com.spotifyclone.api.models.Artist;
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

                // artistRepository.save(new Artist(
                //     7,
                //     "Stephanie Poetri",
                //     889,
                //     "http://localhost:8080/upload/files/7.png"));

                // artistRepository.save(new Artist(
                //     8,
                //     "Charlie Puth",
                //     157184,
                //     "http://localhost:8080/upload/files/8.png"));

                // artistRepository.save(new Artist(
                //     9,
                //     "Justin Bieber",
                //     157909,
                //     "http://localhost:8080/upload/files/9.png"));

                // artistRepository.save(new Artist(
                //     10,
                //     "Tama",
                //     653,
                //     "http://localhost:8080/upload/files/10.png"));

                // artistRepository.save(new Artist(
                //     11,
                //     "Nhật Phong",
                //     225541,
                //     "http://localhost:8080/upload/files/11.png"));
            }
        };
    }
}
