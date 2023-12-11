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

                // audioRepository.save(new Audio(
                //     4L,
                //     "Tại Vì Sao",
                //     new ArrayList<Long>(Arrays.asList(4L)),
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     "http://docs.google.com/uc?export=open&id=1h5zlBC-rSav9T1m2wuEIWrg_5-dDtp8Q",
                //     "http://localhost:8080/upload/files/taivisao.png"));

                // audioRepository.save(new Audio(
                //     5L,
                //     "Chìm Sâu",
                //     new ArrayList<Long>(Arrays.asList(4L)),
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     "http://docs.google.com/uc?export=open&id=14P0O9z7IjGIo9r5Pxlc66oWuw-eeb42j",
                //     "http://localhost:8080/upload/files/chimsau.png"));

                // audioRepository.save(new Audio(
                //     6L,
                //     "Hit Me Up",
                //     new ArrayList<Long>(Arrays.asList(5L)),
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     "http://docs.google.com/uc?export=open&id=1f_IPWqW6cuHomqpBkHfMTuvzontT346N",
                //     "http://localhost:8080/upload/files/hitmeup.png"));

                // audioRepository.save(new Audio(
                //     7L,
                //     "Anh Đánh Rơi Người Yêu Này",
                //     new ArrayList<Long>(Arrays.asList(6L)),
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     "http://docs.google.com/uc?export=open&id=1Diuv9-wQAxhZr5rpj_BdK9PBW-5oS85M",
                //     "http://localhost:8080/upload/files/anhdanhroinguoiyeunay.png"));
                    
            }
        };
    }
}
