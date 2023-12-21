-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Dec 21, 2023 at 04:21 AM
-- Server version: 5.7.44
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spotify_clone`
--

-- --------------------------------------------------------

--
-- Table structure for table `album_audios`
--

CREATE TABLE `album_audios` (
  `album_id` bigint(20) NOT NULL,
  `audios` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `album_audios`
--

INSERT INTO `album_audios` (`album_id`, `audios`) VALUES
(1, 1),
(1, 2),
(1, 7),
(1, 14),
(1, 15),
(2, 3),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 13),
(3, 4),
(3, 5),
(3, 6),
(3, 16),
(3, 17);

-- --------------------------------------------------------

--
-- Table structure for table `audio_albums`
--

CREATE TABLE `audio_albums` (
  `audio_id` bigint(20) NOT NULL,
  `albums` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audio_albums`
--

INSERT INTO `audio_albums` (`audio_id`, `albums`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 3),
(6, 3),
(7, 1),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 1),
(15, 1),
(16, 3),
(17, 3);

-- --------------------------------------------------------

--
-- Table structure for table `audio_artists`
--

CREATE TABLE `audio_artists` (
  `audio_id` bigint(20) NOT NULL,
  `artists` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audio_artists`
--

INSERT INTO `audio_artists` (`audio_id`, `artists`) VALUES
(1, 2),
(2, 1),
(3, 3),
(4, 4),
(5, 4),
(6, 5),
(7, 6),
(8, 3),
(9, 7),
(10, 8),
(11, 8),
(12, 9),
(13, 9),
(14, 10),
(15, 11),
(16, 5),
(17, 5);

-- --------------------------------------------------------

--
-- Table structure for table `playlist_audios`
--

CREATE TABLE `playlist_audios` (
  `playlist_id` bigint(20) NOT NULL,
  `audios` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_album`
--

CREATE TABLE `tbl_album` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_album`
--

INSERT INTO `tbl_album` (`id`, `avatar`, `created_at`, `name`) VALUES
(1, 'http://localhost:8080/upload/files/vn.png', '2023-12-21 11:19:40.938000', 'Top Việt Nam'),
(2, 'http://localhost:8080/upload/files/usuk.png', '2023-12-21 11:19:41.398000', 'Top Âu Mỹ'),
(3, 'http://localhost:8080/upload/files/rapviet.png', '2023-12-21 11:19:41.630000', 'Top Rap Việt');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_album_seq`
--

CREATE TABLE `tbl_album_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_album_seq`
--

INSERT INTO `tbl_album_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_artist`
--

CREATE TABLE `tbl_artist` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `followers` bigint(20) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_artist`
--

INSERT INTO `tbl_artist` (`id`, `avatar`, `followers`, `name`) VALUES
(1, 'http://localhost:8080/upload/files/1.png', 3213, 'Miina'),
(2, 'http://localhost:8080/upload/files/2.png', 4691, 'Umie'),
(3, 'http://localhost:8080/upload/files/3.png', 210497, 'Taylor Swift'),
(4, 'http://localhost:8080/upload/files/4.png', 97160, 'RPT MCK'),
(5, 'http://localhost:8080/upload/files/5.png', 389233, 'Binz'),
(6, 'http://localhost:8080/upload/files/6.png', 407802, 'Amee'),
(7, 'http://localhost:8080/upload/files/7.png', 889, 'Stephanie Poetri'),
(8, 'http://localhost:8080/upload/files/8.png', 157184, 'Charlie Puth'),
(9, 'http://localhost:8080/upload/files/9.png', 157909, 'Justin Bieber'),
(10, 'http://localhost:8080/upload/files/10.png', 653, 'Tama'),
(11, 'http://localhost:8080/upload/files/11.png', 225541, 'Nhật Phong');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_artist_seq`
--

CREATE TABLE `tbl_artist_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_artist_seq`
--

INSERT INTO `tbl_artist_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_audio`
--

CREATE TABLE `tbl_audio` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_audio`
--

INSERT INTO `tbl_audio` (`id`, `avatar`, `name`, `url`) VALUES
(1, 'http://localhost:8080/upload/files/ghevaotai.png', 'Ghé Vào Tai', 'http://docs.google.com/uc?export=open&id=1K_XLMhRmX7roaVqvRl7poO0tq5fwJGbr'),
(2, 'http://localhost:8080/upload/files/11gio11phut.png', '11 Giờ 11 Phút', 'http://docs.google.com/uc?export=open&id=1m-TySST7urjDjuqC6gal3-kqB5Vj9Sg2'),
(3, 'http://localhost:8080/upload/files/lovestory.png', 'Love Story', 'http://docs.google.com/uc?export=open&id=1A68PdQUGxGgbVDmAsOoTJN8ASpbPgeIF'),
(4, 'http://localhost:8080/upload/files/taivisao.png', 'Tại Vì Sao', 'http://docs.google.com/uc?export=open&id=1h5zlBC-rSav9T1m2wuEIWrg_5-dDtp8Q'),
(5, 'http://localhost:8080/upload/files/chimsau.png', 'Chìm Sâu', 'http://docs.google.com/uc?export=open&id=14P0O9z7IjGIo9r5Pxlc66oWuw-eeb42j'),
(6, 'http://localhost:8080/upload/files/hitmeup.png', 'Hit Me Up', 'http://docs.google.com/uc?export=open&id=1f_IPWqW6cuHomqpBkHfMTuvzontT346N'),
(7, 'http://localhost:8080/upload/files/anhdanhroinguoiyeunay.png', 'Anh Đánh Rơi Người Yêu Này', 'http://docs.google.com/uc?export=open&id=1Diuv9-wQAxhZr5rpj_BdK9PBW-5oS85M'),
(8, 'http://localhost:8080/upload/files/lookwhatyoumakemedo.png', 'Look What You Make Me Do', 'http://docs.google.com/uc?export=open&id=1aGgr85rdYRiXacP8M7UzrIVhvcHRo_M_'),
(9, 'http://localhost:8080/upload/files/iloveyou3000.png', 'I Love You 3000', 'http://docs.google.com/uc?export=open&id=1JLCPeNW0dQpoHpaiyCpGP3BFUuaUOCX3'),
(10, 'http://localhost:8080/upload/files/attention.png', 'Attention', 'http://docs.google.com/uc?export=open&id=1_m6Hc_aN2MlnIyao-UwFni4GpnWUzC5x'),
(11, 'http://localhost:8080/upload/files/howlong.png', 'How Long', 'http://docs.google.com/uc?export=open&id=1lBB0EZbEOHAdwd58zWuD87nO-jRm3Los'),
(12, 'http://localhost:8080/upload/files/whatdoyoumean.png', 'What Do You Mean', 'http://docs.google.com/uc?export=open&id=1z4sKLkMu0E-_37bT2SwybPE-nhFyI2Oa'),
(13, 'http://localhost:8080/upload/files/loveyourself.png', 'Love Yourself', 'http://docs.google.com/uc?export=open&id=1JUJYtD3kCSjrvXFkLEiK_fuTRx7fQHPj'),
(14, 'http://localhost:8080/upload/files/ngayemdepnhat.png', 'Ngày Em Đẹp Nhất', 'http://docs.google.com/uc?export=open&id=1bD8VhCOknZ4bYvm7ux_f2aOuXc5dvaxY'),
(15, 'http://localhost:8080/upload/files/anhdatungcogang.png', 'Anh Đã Từng Cố Gắng', 'http://docs.google.com/uc?export=open&id=1bn-kg2SkzHg-txAc3fPafpaSc95tETc2'),
(16, 'http://localhost:8080/upload/files/deepsea.png', 'Deep Sea', 'http://docs.google.com/uc?export=open&id=1oRNEcvmlJ8X3pp4likDONVAj2aOEXhTv'),
(17, 'http://localhost:8080/upload/files/conmuacuoi.png', 'Cơn Mưa Cuối', 'http://docs.google.com/uc?export=open&id=1ypMJ6U4trQi6AaTkUFOfFAj3aoJ-sRvY');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_audio_seq`
--

CREATE TABLE `tbl_audio_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_audio_seq`
--

INSERT INTO `tbl_audio_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_playlist`
--

CREATE TABLE `tbl_playlist` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_playlist_seq`
--

CREATE TABLE `tbl_playlist_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_playlist_seq`
--

INSERT INTO `tbl_playlist_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `album_audios`
--
ALTER TABLE `album_audios`
  ADD KEY `FKqtwyyy6avkw8astwwbvu60ayh` (`album_id`);

--
-- Indexes for table `audio_albums`
--
ALTER TABLE `audio_albums`
  ADD KEY `FKlg01tlc7ab02lo0kvrjxht51y` (`audio_id`);

--
-- Indexes for table `audio_artists`
--
ALTER TABLE `audio_artists`
  ADD KEY `FKhmaigkn43vmhmcs6llfcb6q1b` (`audio_id`);

--
-- Indexes for table `playlist_audios`
--
ALTER TABLE `playlist_audios`
  ADD KEY `FKeodoou70ecnnkqk0uxeox8cvq` (`playlist_id`);

--
-- Indexes for table `tbl_album`
--
ALTER TABLE `tbl_album`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_artist`
--
ALTER TABLE `tbl_artist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_audio`
--
ALTER TABLE `tbl_audio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_playlist`
--
ALTER TABLE `tbl_playlist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `album_audios`
--
ALTER TABLE `album_audios`
  ADD CONSTRAINT `FKqtwyyy6avkw8astwwbvu60ayh` FOREIGN KEY (`album_id`) REFERENCES `tbl_album` (`id`);

--
-- Constraints for table `audio_albums`
--
ALTER TABLE `audio_albums`
  ADD CONSTRAINT `FKlg01tlc7ab02lo0kvrjxht51y` FOREIGN KEY (`audio_id`) REFERENCES `tbl_audio` (`id`);

--
-- Constraints for table `audio_artists`
--
ALTER TABLE `audio_artists`
  ADD CONSTRAINT `FKhmaigkn43vmhmcs6llfcb6q1b` FOREIGN KEY (`audio_id`) REFERENCES `tbl_audio` (`id`);

--
-- Constraints for table `playlist_audios`
--
ALTER TABLE `playlist_audios`
  ADD CONSTRAINT `FKeodoou70ecnnkqk0uxeox8cvq` FOREIGN KEY (`playlist_id`) REFERENCES `tbl_playlist` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
