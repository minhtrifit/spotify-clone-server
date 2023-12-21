package com.spotifyclone.api.databases;

// import java.util.ArrayList;
// import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import com.spotifyclone.api.models.Audio;
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

                // audioRepository.save(new Audio(
                //     8L,
                //     "Look What You Make Me Do",
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1aGgr85rdYRiXacP8M7UzrIVhvcHRo_M_",
                //     "http://localhost:8080/upload/files/lookwhatyoumakemedo.png"));

                // audioRepository.save(new Audio(
                //     9L,
                //     "I Love You 3000",
                //     new ArrayList<Long>(Arrays.asList(7L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1JLCPeNW0dQpoHpaiyCpGP3BFUuaUOCX3",
                //     "http://localhost:8080/upload/files/iloveyou3000.png"));

                // audioRepository.save(new Audio(
                //     10L,
                //     "Attention",
                //     new ArrayList<Long>(Arrays.asList(8L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1_m6Hc_aN2MlnIyao-UwFni4GpnWUzC5x",
                //     "http://localhost:8080/upload/files/attention.png"));

                // audioRepository.save(new Audio(
                //     11L,
                //     "How Long",
                //     new ArrayList<Long>(Arrays.asList(8L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1lBB0EZbEOHAdwd58zWuD87nO-jRm3Los",
                //     "http://localhost:8080/upload/files/howlong.png"));

                // audioRepository.save(new Audio(
                //     12L,
                //     "What Do You Mean",
                //     new ArrayList<Long>(Arrays.asList(9L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1z4sKLkMu0E-_37bT2SwybPE-nhFyI2Oa",
                //     "http://localhost:8080/upload/files/whatdoyoumean.png"));

                // audioRepository.save(new Audio(
                //     13L,
                //     "Love Yourself",
                //     new ArrayList<Long>(Arrays.asList(9L)),
                //     new ArrayList<Long>(Arrays.asList(2L)),
                //     "http://docs.google.com/uc?export=open&id=1JUJYtD3kCSjrvXFkLEiK_fuTRx7fQHPj",
                //     "http://localhost:8080/upload/files/loveyourself.png"));
                    
                // audioRepository.save(new Audio(
                //     14L,
                //     "Ngày Em Đẹp Nhất",
                //     new ArrayList<Long>(Arrays.asList(10L)),
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     "http://docs.google.com/uc?export=open&id=1bD8VhCOknZ4bYvm7ux_f2aOuXc5dvaxY",
                //     "http://localhost:8080/upload/files/ngayemdepnhat.png"));

                // audioRepository.save(new Audio(
                //     15L,
                //     "Anh Đã Từng Cố Gắng",
                //     new ArrayList<Long>(Arrays.asList(11L)),
                //     new ArrayList<Long>(Arrays.asList(1L)),
                //     "http://docs.google.com/uc?export=open&id=1bn-kg2SkzHg-txAc3fPafpaSc95tETc2",
                //     "http://localhost:8080/upload/files/anhdatungcogang.png"));

                // audioRepository.save(new Audio(
                //     16L,
                //     "Deep Sea",
                //     new ArrayList<Long>(Arrays.asList(5L)),
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     "http://docs.google.com/uc?export=open&id=1oRNEcvmlJ8X3pp4likDONVAj2aOEXhTv",
                //     "http://localhost:8080/upload/files/deepsea.png"));

                // audioRepository.save(new Audio(
                //     17L,
                //     "Cơn Mưa Cuối",
                //     new ArrayList<Long>(Arrays.asList(5L)),
                //     new ArrayList<Long>(Arrays.asList(3L)),
                //     "http://docs.google.com/uc?export=open&id=1ypMJ6U4trQi6AaTkUFOfFAj3aoJ-sRvY",
                //     "http://localhost:8080/upload/files/conmuacuoi.png"));
            }
        };
    }
}
