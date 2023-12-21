package com.spotifyclone.api.databases;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import com.spotifyclone.api.models.Album;
import com.spotifyclone.api.repositories.AlbumRepository;

@Configuration
public class AlbumDb {
    @Bean
    CommandLineRunner initAlbumDatabase(AlbumRepository albumRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                
                // albumRepository.save(new Album(
                //     "Top Việt Nam",
                //     new ArrayList<Long>(Arrays.asList(1L, 2L, 7L, 14L, 15L)),
                //     new Date(),
                //     "http://localhost:8080/upload/files/vn.png"));

                // albumRepository.save(new Album(
                //     "Top Âu Mỹ",
                //     new ArrayList<Long>(Arrays.asList(3L, 8L, 9L, 10L, 11L, 12L, 13L)),
                //     new Date(),
                //     "http://localhost:8080/upload/files/usuk.png"));

                // albumRepository.save(new Album(
                //     "Top Rap Việt",
                //     new ArrayList<Long>(Arrays.asList(4L, 5L, 6L, 16L, 17L)),
                //     new Date(),
                //     "http://localhost:8080/upload/files/rapviet.png"));
            }
        };
    }
}
