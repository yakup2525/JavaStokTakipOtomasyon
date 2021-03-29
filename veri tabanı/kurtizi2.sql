-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 20 Ara 2020, 08:50:35
-- Sunucu sürümü: 10.4.17-MariaDB
-- PHP Sürümü: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kurtizi`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `malzemeler`
--

CREATE TABLE `malzemeler` (
  `id` int(11) NOT NULL,
  `isim` text COLLATE utf8_turkish_ci NOT NULL,
  `barkod` text COLLATE utf8_turkish_ci NOT NULL,
  `tur` text COLLATE utf8_turkish_ci NOT NULL,
  `miktar` text COLLATE utf8_turkish_ci NOT NULL,
  `fiyat` text COLLATE utf8_turkish_ci NOT NULL,
  `kayittarihi` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `malzemeler`
--

INSERT INTO `malzemeler` (`id`, `isim`, `barkod`, `tur`, `miktar`, `fiyat`, `kayittarihi`) VALUES
(1, 'Laptop', '25875632145698', 'Elektronik', '5', '6000', '2020/12/20'),
(2, 'SSD', '12345678909876', 'Elektronik', '66', '900', '2020/12/20 10:45:51');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `myadmin`
--

CREATE TABLE `myadmin` (
  `username` text COLLATE utf8_turkish_ci NOT NULL,
  `password` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `myadmin`
--

INSERT INTO `myadmin` (`username`, `password`) VALUES
('admin', 'admin'),
('yakup', '12345'),
('yagmur', '12345\r\n');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personeller`
--

CREATE TABLE `personeller` (
  `id` int(11) NOT NULL,
  `ad` text COLLATE utf8_turkish_ci NOT NULL,
  `soyad` text COLLATE utf8_turkish_ci NOT NULL,
  `departman` text COLLATE utf8_turkish_ci NOT NULL,
  `maas` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `personeller`
--

INSERT INTO `personeller` (`id`, `ad`, `soyad`, `departman`, `maas`) VALUES
(1, 'Yakup', 'OKUMUŞ', 'Yönetici', '7000'),
(2, 'Yağmur', 'AKAY', 'IT', '7000'),
(3, 'Mustafa', 'Kayhan', 'Yazılım', '5000'),
(4, 'Ali', 'Üçpınar', 'Yazılım', '5000'),
(5, 'Lale', 'ERSOY', 'İnsan Kaynakları', '6000'),
(6, 'Lale', 'Karabağ', 'Yazılım', '5000');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `malzemeler`
--
ALTER TABLE `malzemeler`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `personeller`
--
ALTER TABLE `personeller`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `malzemeler`
--
ALTER TABLE `malzemeler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `personeller`
--
ALTER TABLE `personeller`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
