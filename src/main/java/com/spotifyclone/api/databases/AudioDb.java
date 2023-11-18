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
                audioRepository.save(new Audio(
                    "Ghé Vào Tai",
                    new ArrayList<Long>(Arrays.asList(1L)),
                    new ArrayList<Long>(Arrays.asList(1L)),
                    "http://docs.google.com/uc?export=open&id=1K_XLMhRmX7roaVqvRl7poO0tq5fwJGbr"));

                audioRepository.save(new Audio(
                    "11 Giờ 11 Phút",
                    new ArrayList<Long>(Arrays.asList(2L)),
                    new ArrayList<Long>(Arrays.asList(1L)),
                    "http://docs.google.com/uc?export=open&id=1m-TySST7urjDjuqC6gal3-kqB5Vj9Sg2"));
                    
                audioRepository.save(new Audio(
                    "Love Story",
                    new ArrayList<Long>(Arrays.asList(3L)),
                    new ArrayList<Long>(Arrays.asList(2L)),
                    "http://docs.google.com/uc?export=open&id=1A68PdQUGxGgbVDmAsOoTJN8ASpbPgeIF"));
            }
        };
    }
}
