-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 20, 2020 at 01:05 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.2.24-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `EmpDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `DeptTB`
--

CREATE TABLE `DeptTB` (
  `DepartmentID` int(11) NOT NULL,
  `DepartmentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DeptTB`
--

INSERT INTO `DeptTB` (`DepartmentID`, `DepartmentName`) VALUES
(1, 'HR'),
(2, 'Manager'),
(3, 'Employee'),
(5, 'purchase'),
(6, 'Sales');

-- --------------------------------------------------------

--
-- Table structure for table `EmployeeCustomTag`
--

CREATE TABLE `EmployeeCustomTag` (
  `Eid` int(11) NOT NULL,
  `Ename` varchar(50) NOT NULL,
  `Esal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EmployeeCustomTag`
--

INSERT INTO `EmployeeCustomTag` (`Eid`, `Ename`, `Esal`) VALUES
(1, 'Shubham', 20000),
(2, 'snehal', 40000);

-- --------------------------------------------------------

--
-- Table structure for table `EmpTB`
--

CREATE TABLE `EmpTB` (
  `EmpID` int(11) NOT NULL,
  `EmployeeName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EmpTB`
--

INSERT INTO `EmpTB` (`EmpID`, `EmployeeName`, `Password`, `DepartmentID`) VALUES
(3, 'shubh', 'bhaibhai', 1),
(5, 'jiteshbhai', 'jitesh', 3),
(8, 'niravbhai', 'nirav', 1),
(17, 'krishna', 'krishna', 1),
(18, 'Jay', 'Jay', 1),
(32, 'umesh', 'sfddf', 1),
(33, 'umesh', 'sfddf', 1),
(34, 'umesh', 'sfddf', 1),
(35, 'umesh', 'sfddf', 1),
(36, 'umesh', 'sfddf', 1),
(37, 'umesh', 'sfddf', 1),
(38, 'abhi', 'dsfdsf', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `DeptTB`
--
ALTER TABLE `DeptTB`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `EmployeeCustomTag`
--
ALTER TABLE `EmployeeCustomTag`
  ADD PRIMARY KEY (`Eid`);

--
-- Indexes for table `EmpTB`
--
ALTER TABLE `EmpTB`
  ADD PRIMARY KEY (`EmpID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `DeptTB`
--
ALTER TABLE `DeptTB`
  MODIFY `DepartmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `EmployeeCustomTag`
--
ALTER TABLE `EmployeeCustomTag`
  MODIFY `Eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `EmpTB`
--
ALTER TABLE `EmpTB`
  MODIFY `EmpID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
