-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2025 at 08:13 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int NOT NULL,
  `nim` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `jenis_kelamin` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `status`) VALUES
(2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 'Non-Aktif'),
(3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 'Non-Aktif'),
(4, '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 'Non-Aktif'),
(5, '2202046', 'Nurainun', 'Perempuan', 'Aktif'),
(6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 'Aktif'),
(7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 'Aktif'),
(8, '2202869', 'Revana Faliha Salma', 'Perempuan', 'Aktif'),
(9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 'Aktif'),
(10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 'Aktif'),
(11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 'Aktif'),
(12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 'Aktif'),
(13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 'Aktif'),
(14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 'Aktif'),
(26, '2306896', 'Jihan Aqilah', 'Perempuan', 'Aktif');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
