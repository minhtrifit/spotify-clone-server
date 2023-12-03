package com.spotifyclone.api.databases;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spotifyclone.api.models.Audio;
import com.spotifyclone.api.repositories.AudioRepository;

@Configuration
public class AudioDb {
    @Bean
    CommandLineRunner initAudioDatabase(AudioRepository audioRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                // audioRepository.save(new Audio(
                //     1L,
                //     "Ghé Vào Tai",
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     "http://docs.google.com/uc?export=open&id=1K_XLMhRmX7roaVqvRl7poO0tq5fwJGbr",
                //     "http://localhost:8080/upload/files/ghevaotai.png"));

                // audioRepository.save(new Audio(
                //     2L,
                //     "11 Giờ 11 Phút",
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     "http://docs.google.com/uc?export=open&id=1m-TySST7urjDjuqC6gal3-kqB5Vj9Sg2",
                //     "http://localhost:8080/upload/files/11gio11phut.png"));

                // audioRepository.save(new Audio(
                //     3L,
                //     "Love Story",
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1A68PdQUGxGgbVDmAsOoTJN8ASpbPgeIF",
                //     "http://localhost:8080/upload/files/lovestory.png"));
                    
            }
        };
    }
}
