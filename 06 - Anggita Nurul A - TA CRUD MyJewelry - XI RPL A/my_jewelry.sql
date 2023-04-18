-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2023 at 08:22 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `my_jewelry`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_beli`
--

CREATE TABLE `data_beli` (
  `productId` int(5) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `jenisBeli` varchar(250) NOT NULL,
  `bentukBeli` varchar(250) NOT NULL,
  `berat` int(5) NOT NULL,
  `qty` int(4) NOT NULL,
  `harga` double(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_beli`
--

INSERT INTO `data_beli` (`productId`, `fullName`, `jenisBeli`, `bentukBeli`, `berat`, `qty`, `harga`) VALUES
(1, 'Tio', 'Silver Plated', 'Kalung', 9, 1, 250000.00),
(2, 'Han', 'Nickel Silver', 'Cincin', 8, 2, 200000.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_beli`
--
ALTER TABLE `data_beli`
  ADD PRIMARY KEY (`productId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_beli`
--
ALTER TABLE `data_beli`
  MODIFY `productId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
