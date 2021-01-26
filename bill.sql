-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 08:26 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `city` varchar(200) NOT NULL,
  `area` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `area`
--

INSERT INTO `area` (`id`, `city`, `area`) VALUES
(1, 'palanpur', 'haa'),
(2, 'asdk', 'kjbj'),
(4, 'asdk', 'jhbhj');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category` varchar(200) NOT NULL,
  `image` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category`, `image`, `description`) VALUES
(1, 'jhdhg', 'C:UsersmauliOneDriveDocumentsm.jpeg', 'gchh'),
(2, 'jhgch', 'C:UsersmauliOneDriveDocumentsm.jpeg', 'jhcf'),
(6, 'jsdhf', 'C:UsersmauliOneDriveDocumentsm.jpeg', 'sdf');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `city` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `city`) VALUES
(1, 'harsh'),
(2, 'kajsdhd'),
(3, 'asdk'),
(4, 'sdf');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `role` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `job` varchar(200) NOT NULL,
  `birthdate` date NOT NULL,
  `textarea` varchar(200) NOT NULL,
  `image` varchar(200) NOT NULL,
  `emp_number` bigint(20) NOT NULL,
  `dateandtime` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `role`, `email`, `job`, `birthdate`, `textarea`, `image`, `emp_number`, `dateandtime`) VALUES
(1, 'maulik', 'maulik', 'java devloper', '2000-05-12', 'hello', 'null', 7435864306, '2020-07-09 12:07:49'),
(2, 'fhtfh', 'maulik', 'asd', '2000-05-12', 'asd', 'C:UsersmauliOneDriveDocumentsm.jpeg', 165465, '2020-07-09 19:34:48'),
(3, 'maulik', 'maulik', 'asdasd', '2000-05-12', 'asd', 'C:UsersmauliOneDriveDocumentsm.jpeg', 165465, '2020-07-09 19:34:55');

-- --------------------------------------------------------

--
-- Table structure for table `gst`
--

CREATE TABLE `gst` (
  `id` int(11) NOT NULL,
  `gst` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gst`
--

INSERT INTO `gst` (`id`, `gst`) VALUES
(1, 45),
(2, 75),
(4, 45),
(5, 50),
(6, 45);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'use', 'pas'),
(2, 'use', 'pas'),
(3, 'use', 'pas'),
(4, 'mua', 'a'),
(5, 'maulik', 'maulik'),
(6, 'm', 'm'),
(7, 'ffsdfsd', 'sdf'),
(8, 'maulik', 'maulik'),
(9, 'hjg', 'j'),
(10, 'a', 'a'),
(11, 'harsh', 'harsh');

-- --------------------------------------------------------

--
-- Table structure for table `party`
--

CREATE TABLE `party` (
  `id` int(11) NOT NULL,
  `partyname` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(200) NOT NULL,
  `pincode` int(11) NOT NULL,
  `number` bigint(20) NOT NULL,
  `number1` bigint(20) NOT NULL,
  `email` varchar(200) NOT NULL,
  `gstno` int(11) NOT NULL,
  `bank` varchar(200) NOT NULL,
  `companyname` varchar(200) NOT NULL,
  `url` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `party`
--

INSERT INTO `party` (`id`, `partyname`, `address`, `city`, `pincode`, `number`, `number1`, `email`, `gstno`, `bank`, `companyname`, `url`) VALUES
(1, 'mauliksdf', 'kjshdf', 'jvgj', 54, 5445, 5454, 'hjgchjg', 545, 'jkhvkj', 'hasd', 'kvh');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category` varchar(200) NOT NULL,
  `productcode` varchar(200) NOT NULL,
  `productname` varchar(200) NOT NULL,
  `hsncode` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `unit` varchar(200) NOT NULL,
  `qulity` int(11) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category`, `productcode`, `productname`, `hsncode`, `price`, `unit`, `qulity`, `description`) VALUES
(1, 'tshirt', '456', 'ddd', 745, 85, '78', 30, 'nice'),
(2, 'jhgch', 'hello', 'haaaa', 4545, 4545, '7812', 50, 'nice'),
(4, 'jsdhf', 'asdjh', 'kjhvjasdbsajhdbjsh', 6465, 654, '54', 564, 'kgfu');

-- --------------------------------------------------------

--
-- Table structure for table `purchasedata`
--

CREATE TABLE `purchasedata` (
  `purchaseno` int(11) NOT NULL,
  `category` varchar(200) NOT NULL,
  `product` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `qulity` int(11) NOT NULL,
  `unit` int(11) NOT NULL,
  `gst` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `gsttotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchasedata`
--

INSERT INTO `purchasedata` (`purchaseno`, `category`, `product`, `price`, `qulity`, `unit`, `gst`, `subtotal`, `gsttotal`) VALUES
(45, 'jhgch', 'jsdhf', 2, 2, 2, 75, 4, 79),
(45, 'jhgch', 'jsdhf', 2, 2, 2, 75, 4, 79),
(45, 'jsdhf', 'jsdhf', 32, 23, 23, 55, 55, 110),
(45, 'jsdhf', 'jhgch', 23, 23, 23, 75, 46, 121),
(45, 'jsdhf', 'jhgch', 34, 34, 34, 55, 68, 123),
(5, 'jhgch', 'jsdhf', 23, 23, 23, 75, 46, 121),
(5, 'jsdhf', 'jsdhf', 23, 23, 23, 55, 46, 101),
(5, 'jsdhf', 'jsdhf', 23, 23, 23, 55, 46, 101),
(1, 'jsdhf', 'jhgch', 23, 23, 23, 55, 46, 101),
(1, 'jsdhf', 'jhgch', 23, 23, 23, 55, 46, 101),
(12, 'jhgch', 'jhgch', 12, 12, 12, 75, 24, 99),
(12, 'jsdhf', 'jsdhf', 23, 23, 23, 55, 46, 101),
(12, 'jsdhf', 'jsdhf', 23, 23, 23, 55, 46, 101),
(12, 'jsdhf', 'jhgch', 34, 34, 34, 55, 68, 123),
(777, 'jhdhg', 'jhgch', 234, 234, 234, 55, 468, 523),
(777, 'jhdhg', 'tshirt', 234, 234, 234, 75, 468, 543),
(777, 'jhdhg', 'tshirt', 234, 234, 234, 55, 468, 523),
(1, 'jsdhf', 'jhgch', 23, 23, 23, 55, 46, 101),
(1, 'jsdhf', 'jhgch', 23, 23, 23, 55, 46, 101),
(122, 'jsdhf', 'jhgch', 12, 12, 12, 55, 24, 79),
(555, 'jhgch', 'jhgch', 12, 12, 12, 75, 24, 99),
(555, 'jhgch', 'jhgch', 12, 12, 12, 75, 24, 99);

-- --------------------------------------------------------

--
-- Table structure for table `purchaseparty`
--

CREATE TABLE `purchaseparty` (
  `id` int(11) NOT NULL,
  `purchaseno` int(11) NOT NULL,
  `date` date NOT NULL,
  `billno` int(11) NOT NULL,
  `purchaseparty` varchar(200) NOT NULL,
  `billdate` date NOT NULL,
  `remarks` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchaseparty`
--

INSERT INTO `purchaseparty` (`id`, `purchaseno`, `date`, `billno`, `purchaseparty`, `billdate`, `remarks`) VALUES
(4, 1, '2000-05-12', 12, 'mauliksdf', '2000-05-12', 'sdfas'),
(5, 777, '2000-05-12', 234, 'mauliksdf', '2000-05-12', 'sdg'),
(6, 1, '2000-05-12', 1, 'mauliksdf', '2000-05-12', 'sdfasdsf'),
(7, 555, '2000-05-12', 124, 'mauliksdf', '2000-05-12', 'asf');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'maulik'),
(2, 'maulik'),
(3, 'maulikasd'),
(40, 'sdsdf'),
(43, 'asd'),
(45, 'fhtfhasd'),
(46, 'sadfasf'),
(47, 'drgdrg'),
(48, 'vgnvg'),
(49, 'sdfsdf'),
(50, 'asd'),
(51, 'harshsdfjksdhf'),
(52, 'sdf'),
(53, 'sdf'),
(54, 'vgnvgasdf'),
(55, 'sdf'),
(57, 'asd'),
(60, 'asd'),
(61, 'asd'),
(62, 'harsh');

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `id` int(11) NOT NULL,
  `unit` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`id`, `unit`) VALUES
(1, 12),
(2, 78),
(3, 7812),
(4, 54),
(5, 45),
(7, 54),
(8, 54);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gst`
--
ALTER TABLE `gst`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `party`
--
ALTER TABLE `party`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchaseparty`
--
ALTER TABLE `purchaseparty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `gst`
--
ALTER TABLE `gst`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `party`
--
ALTER TABLE `party`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `purchaseparty`
--
ALTER TABLE `purchaseparty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
