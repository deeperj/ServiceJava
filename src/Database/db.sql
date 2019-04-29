-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 03:40 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_tasks`
--

CREATE TABLE `admin_tasks` (
  `task_number` int(11) NOT NULL,
  `task_name` varchar(45) NOT NULL,
  `task_description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

--
-- Dumping data for table `admin_tasks`
--

INSERT INTO `admin_tasks` (`task_number`, `task_name`, `task_description`) VALUES
(1, 'dsgsdg', 'oneee');

-- --------------------------------------------------------

--
-- Table structure for table `evidencetable`
--

CREATE TABLE `evidencetable` (
  `evidence_id` int(11) NOT NULL,
  `evidence_type` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `evidencetable`
--

INSERT INTO `evidencetable` (`evidence_id`, `evidence_type`) VALUES
(1, 'Picture'),
(2, 'Document'),
(3, 'Video');

-- --------------------------------------------------------

--
-- Table structure for table `executortable`
--

CREATE TABLE `executortable` (
  `Executor_Name` varchar(45) DEFAULT NULL,
  `Executor_Email` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `executortable`
--

INSERT INTO `executortable` (`Executor_Name`, `Executor_Email`) VALUES
('Miebaka', 'mtoby2018@fau.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Usertype` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Username`, `Password`, `Usertype`) VALUES
('Admin', 'Admin', 'Administrator'),
('PO', 'PO', 'Process Owner'),
('EX', 'EX', 'Executor'),
('AP', 'AP', 'Approver');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_tasks`
--
ALTER TABLE `admin_tasks`
  ADD PRIMARY KEY (`task_number`);

--
-- Indexes for table `evidencetable`
--
ALTER TABLE `evidencetable`
  ADD PRIMARY KEY (`evidence_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `evidencetable`
--
ALTER TABLE `evidencetable`
  MODIFY `evidence_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
