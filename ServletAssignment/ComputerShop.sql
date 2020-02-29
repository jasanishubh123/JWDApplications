-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 27, 2020 at 06:36 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.2.24-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ComputerShoppingAppDB`
--
CREATE DATABASE IF NOT EXISTS `ComputerShoppingAppDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ComputerShoppingAppDB`;

-- --------------------------------------------------------

--
-- Table structure for table `AddressTB`
--

CREATE TABLE `AddressTB` (
  `AddressId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `SessionId` varchar(50) NOT NULL,
  `VisitTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `BrandTB`
--

CREATE TABLE `BrandTB` (
  `BrandId` int(11) NOT NULL,
  `BrandName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BrandTB`
--

INSERT INTO `BrandTB` (`BrandId`, `BrandName`) VALUES
(2, 'HP'),
(3, 'Dell');

-- --------------------------------------------------------

--
-- Table structure for table `CartDetailTB`
--

CREATE TABLE `CartDetailTB` (
  `CartDetailId` int(11) NOT NULL,
  `CartId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` varchar(40) NOT NULL,
  `AddedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifiedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CartDetailTB`
--

INSERT INTO `CartDetailTB` (`CartDetailId`, `CartId`, `ProductId`, `Qty`, `Price`, `AddedOn`, `ModifiedOn`) VALUES
(1, 1, 1, 3, '3000', '2020-02-25 17:42:07', NULL),
(2, 1, 2, 1, '3434', '2020-02-25 17:41:54', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `CartTB`
--

CREATE TABLE `CartTB` (
  `CartId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Total` varchar(30) DEFAULT NULL,
  `AddedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifiedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CartTB`
--

INSERT INTO `CartTB` (`CartId`, `UserId`, `Total`, `AddedOn`, `ModifiedOn`) VALUES
(1, 2, NULL, '2020-02-25 03:23:25', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `CityTB`
--

CREATE TABLE `CityTB` (
  `CityId` int(11) NOT NULL,
  `CityName` varchar(30) NOT NULL,
  `StateId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CityTB`
--

INSERT INTO `CityTB` (`CityId`, `CityName`, `StateId`) VALUES
(1, 'surat1', 2);

-- --------------------------------------------------------

--
-- Table structure for table `CountryTB`
--

CREATE TABLE `CountryTB` (
  `CountryId` int(11) NOT NULL,
  `CountryName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CountryTB`
--

INSERT INTO `CountryTB` (`CountryId`, `CountryName`) VALUES
(1, 'India');

-- --------------------------------------------------------

--
-- Table structure for table `OrderDetailTB`
--

CREATE TABLE `OrderDetailTB` (
  `OrderDetailId` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `OrderDetailTB`
--

INSERT INTO `OrderDetailTB` (`OrderDetailId`, `OrderId`, `ProductId`, `Qty`, `Price`) VALUES
(1, 7, 1, 3, '3000'),
(2, 7, 2, 1, '3434');

-- --------------------------------------------------------

--
-- Table structure for table `OrderTB`
--

CREATE TABLE `OrderTB` (
  `OrderId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Total` varchar(50) NOT NULL,
  `IsPayment` tinyint(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `OrderTB`
--

INSERT INTO `OrderTB` (`OrderId`, `UserId`, `Total`, `IsPayment`) VALUES
(1, 2, '12434', 0),
(2, 2, '12434', 0),
(3, 2, '12434', 0),
(4, 2, '12434', 0),
(5, 2, '12434', 0),
(6, 2, '12434', 0),
(7, 2, '12434', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ProductCategoryTB`
--

CREATE TABLE `ProductCategoryTB` (
  `ProductCategoryId` int(11) NOT NULL,
  `ProductCategory` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ProductCategoryTB`
--

INSERT INTO `ProductCategoryTB` (`ProductCategoryId`, `ProductCategory`) VALUES
(2, 'laptop');

-- --------------------------------------------------------

--
-- Table structure for table `ProductSpecificationTB`
--

CREATE TABLE `ProductSpecificationTB` (
  `ProductSpecificationId` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `SpecificationId` int(11) NOT NULL,
  `SpecificationText` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ProductTB`
--

CREATE TABLE `ProductTB` (
  `ProductId` int(11) NOT NULL,
  `ProductName` varchar(70) NOT NULL,
  `BrandId` int(11) NOT NULL,
  `ProductCategoryId` int(11) NOT NULL,
  `Price` varchar(20) NOT NULL,
  `Description` text NOT NULL,
  `IsActive` tinyint(4) NOT NULL DEFAULT '1',
  `IsDelete` tinyint(4) NOT NULL DEFAULT '0',
  `AddedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifiedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ProductTB`
--

INSERT INTO `ProductTB` (`ProductId`, `ProductName`, `BrandId`, `ProductCategoryId`, `Price`, `Description`, `IsActive`, `IsDelete`, `AddedOn`, `ModifiedOn`) VALUES
(1, 'second', 2, 2, '3000', 'sddsds', 1, 0, '2020-02-24 16:02:04', NULL),
(2, 'sdsd', 2, 2, '3434', 'vcvcv', 1, 0, '2020-02-24 16:03:05', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `SpecificationTB`
--

CREATE TABLE `SpecificationTB` (
  `SpecificationId` int(11) NOT NULL,
  `SpecificationName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SpecificationTB`
--

INSERT INTO `SpecificationTB` (`SpecificationId`, `SpecificationName`) VALUES
(1, 'Speed'),
(2, 'height'),
(3, 'warrenty'),
(4, 'Processor');

-- --------------------------------------------------------

--
-- Table structure for table `StateTB`
--

CREATE TABLE `StateTB` (
  `StateId` int(11) NOT NULL,
  `StateName` varchar(40) NOT NULL,
  `CountryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StateTB`
--

INSERT INTO `StateTB` (`StateId`, `StateName`, `CountryId`) VALUES
(2, 'gujarat', 1);

-- --------------------------------------------------------

--
-- Table structure for table `UserSessionTB`
--

CREATE TABLE `UserSessionTB` (
  `UserSessionId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `SessionId` varchar(100) NOT NULL,
  `VisitTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserSessionTB`
--

INSERT INTO `UserSessionTB` (`UserSessionId`, `UserId`, `SessionId`, `VisitTime`) VALUES
(1, 1, '3abf7264d3e13240be77c5f83f24', '2020-02-23 20:12:48'),
(2, 1, '3bd492025a7f024d403657b9ba29', '2020-02-23 20:29:09'),
(3, 1, '3db5438e30eb6856ad5563a44e6f', '2020-02-23 21:01:58'),
(4, 1, '3db5438e30eb6856ad5563a44e6f', '2020-02-23 21:12:37'),
(5, 1, '3db5438e30eb6856ad5563a44e6f', '2020-02-23 21:27:47'),
(6, 1, '3f7feb8a52760152ad44cd2e9110', '2020-02-23 21:33:17'),
(7, 1, '3f7feb8a52760152ad44cd2e9110', '2020-02-23 21:55:29'),
(8, 1, '7efe1b42ed02fbc7947d0988913a', '2020-02-24 16:02:54'),
(9, 1, '81c2828ce9bd1dc3be9151d4039c', '2020-02-24 16:51:16'),
(10, 1, '81c2828ce9bd1dc3be9151d4039c', '2020-02-24 17:03:53'),
(11, 2, '88f84e73b71b7d24097330452383', '2020-02-24 18:57:16'),
(12, 2, 'a5b186bda436171b5445be7f28f7', '2020-02-25 03:19:15'),
(13, 2, 'a5b186bda436171b5445be7f28f7', '2020-02-25 03:23:23'),
(14, 2, 'a5b186bda436171b5445be7f28f7', '2020-02-25 03:50:35'),
(15, 2, 'a5b186bda436171b5445be7f28f7', '2020-02-25 03:52:35'),
(16, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 17:41:37'),
(17, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 17:51:41'),
(18, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 17:56:31'),
(19, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:04:21'),
(20, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:05:22'),
(21, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:06:43'),
(22, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:09:18'),
(23, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:11:29'),
(24, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:12:44'),
(25, 2, 'd709e4226e68935b165940b44e89', '2020-02-25 18:13:54');

-- --------------------------------------------------------

--
-- Table structure for table `UserTB`
--

CREATE TABLE `UserTB` (
  `UserId` int(11) NOT NULL,
  `FullName` varchar(50) NOT NULL,
  `EmailId` varchar(50) NOT NULL,
  `BirthDate` date NOT NULL,
  `MobileNo` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `IsAdmin` tinyint(4) NOT NULL DEFAULT '0',
  `AddedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifiedOn` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserTB`
--

INSERT INTO `UserTB` (`UserId`, `FullName`, `EmailId`, `BirthDate`, `MobileNo`, `Password`, `IsAdmin`, `AddedOn`, `ModifiedOn`) VALUES
(1, 'snehal lodaliya', 'snehallodaliya7621@gmail.com', '2020-02-03', '7621055154', 'Snehal123', 1, '2020-02-16 22:54:38', '2020-02-17 04:24:38'),
(2, 'shubham', 'shubhjasani@gmail.com', '2020-02-06', '2345678909', 'shubham123', 0, '2020-02-24 18:40:02', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AddressTB`
--
ALTER TABLE `AddressTB`
  ADD PRIMARY KEY (`AddressId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `BrandTB`
--
ALTER TABLE `BrandTB`
  ADD PRIMARY KEY (`BrandId`);

--
-- Indexes for table `CartDetailTB`
--
ALTER TABLE `CartDetailTB`
  ADD PRIMARY KEY (`CartDetailId`),
  ADD KEY `CartId` (`CartId`),
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `CartTB`
--
ALTER TABLE `CartTB`
  ADD PRIMARY KEY (`CartId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `CityTB`
--
ALTER TABLE `CityTB`
  ADD PRIMARY KEY (`CityId`),
  ADD KEY `StateId` (`StateId`);

--
-- Indexes for table `CountryTB`
--
ALTER TABLE `CountryTB`
  ADD PRIMARY KEY (`CountryId`);

--
-- Indexes for table `OrderDetailTB`
--
ALTER TABLE `OrderDetailTB`
  ADD PRIMARY KEY (`OrderDetailId`),
  ADD KEY `OrderId` (`OrderId`),
  ADD KEY `ProductId` (`ProductId`);

--
-- Indexes for table `OrderTB`
--
ALTER TABLE `OrderTB`
  ADD PRIMARY KEY (`OrderId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `ProductCategoryTB`
--
ALTER TABLE `ProductCategoryTB`
  ADD PRIMARY KEY (`ProductCategoryId`);

--
-- Indexes for table `ProductSpecificationTB`
--
ALTER TABLE `ProductSpecificationTB`
  ADD PRIMARY KEY (`ProductSpecificationId`),
  ADD KEY `ProductId` (`ProductId`),
  ADD KEY `SpecificationId` (`SpecificationId`);

--
-- Indexes for table `ProductTB`
--
ALTER TABLE `ProductTB`
  ADD PRIMARY KEY (`ProductId`),
  ADD KEY `BrandId` (`BrandId`),
  ADD KEY `ProductCategoryId` (`ProductCategoryId`);

--
-- Indexes for table `SpecificationTB`
--
ALTER TABLE `SpecificationTB`
  ADD PRIMARY KEY (`SpecificationId`);

--
-- Indexes for table `StateTB`
--
ALTER TABLE `StateTB`
  ADD PRIMARY KEY (`StateId`),
  ADD KEY `CountryId` (`CountryId`);

--
-- Indexes for table `UserSessionTB`
--
ALTER TABLE `UserSessionTB`
  ADD PRIMARY KEY (`UserSessionId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `UserTB`
--
ALTER TABLE `UserTB`
  ADD PRIMARY KEY (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `AddressTB`
--
ALTER TABLE `AddressTB`
  MODIFY `AddressId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `BrandTB`
--
ALTER TABLE `BrandTB`
  MODIFY `BrandId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `CartDetailTB`
--
ALTER TABLE `CartDetailTB`
  MODIFY `CartDetailId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `CartTB`
--
ALTER TABLE `CartTB`
  MODIFY `CartId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CityTB`
--
ALTER TABLE `CityTB`
  MODIFY `CityId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CountryTB`
--
ALTER TABLE `CountryTB`
  MODIFY `CountryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `OrderDetailTB`
--
ALTER TABLE `OrderDetailTB`
  MODIFY `OrderDetailId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `OrderTB`
--
ALTER TABLE `OrderTB`
  MODIFY `OrderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `ProductCategoryTB`
--
ALTER TABLE `ProductCategoryTB`
  MODIFY `ProductCategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ProductSpecificationTB`
--
ALTER TABLE `ProductSpecificationTB`
  MODIFY `ProductSpecificationId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ProductTB`
--
ALTER TABLE `ProductTB`
  MODIFY `ProductId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `SpecificationTB`
--
ALTER TABLE `SpecificationTB`
  MODIFY `SpecificationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `StateTB`
--
ALTER TABLE `StateTB`
  MODIFY `StateId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `UserSessionTB`
--
ALTER TABLE `UserSessionTB`
  MODIFY `UserSessionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `UserTB`
--
ALTER TABLE `UserTB`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `AddressTB`
--
ALTER TABLE `AddressTB`
  ADD CONSTRAINT `FK_UserTB_UserId_To_USTB_UserId` FOREIGN KEY (`UserId`) REFERENCES `UserTB` (`UserId`);

--
-- Constraints for table `CartDetailTB`
--
ALTER TABLE `CartDetailTB`
  ADD CONSTRAINT `FK_CartTB_CartId_To_CDTB_CartId` FOREIGN KEY (`CartId`) REFERENCES `CartTB` (`CartId`),
  ADD CONSTRAINT `FK_ProductTB_ProductId_To_CDTB_ProductId` FOREIGN KEY (`ProductId`) REFERENCES `ProductTB` (`ProductId`);

--
-- Constraints for table `CartTB`
--
ALTER TABLE `CartTB`
  ADD CONSTRAINT `FK_UserTB_UserId_To_CartTB_UserId` FOREIGN KEY (`UserId`) REFERENCES `UserTB` (`UserId`);

--
-- Constraints for table `CityTB`
--
ALTER TABLE `CityTB`
  ADD CONSTRAINT `FK_StateTB_StateId_To_CityTB_StateId` FOREIGN KEY (`StateId`) REFERENCES `StateTB` (`StateId`);

--
-- Constraints for table `OrderTB`
--
ALTER TABLE `OrderTB`
  ADD CONSTRAINT `FK_UserTB_UserId_To_OrderTB_UserId` FOREIGN KEY (`UserId`) REFERENCES `UserTB` (`UserId`);

--
-- Constraints for table `ProductSpecificationTB`
--
ALTER TABLE `ProductSpecificationTB`
  ADD CONSTRAINT `FK_ProductTB_ProductId_To_PSTB_ProductId` FOREIGN KEY (`ProductId`) REFERENCES `ProductTB` (`ProductId`),
  ADD CONSTRAINT `FK_SpecificationTB_SpecificationId_To_PSTB_SpecificationId` FOREIGN KEY (`SpecificationId`) REFERENCES `SpecificationTB` (`SpecificationId`);

--
-- Constraints for table `ProductTB`
--
ALTER TABLE `ProductTB`
  ADD CONSTRAINT `FK_BrandTB_BrandId_To_ProductTB_BrandId` FOREIGN KEY (`BrandId`) REFERENCES `BrandTB` (`BrandId`),
  ADD CONSTRAINT `FK_ProductCategoryTB_ProductCategoryId_To_ProductTB_ProductCId` FOREIGN KEY (`ProductCategoryId`) REFERENCES `ProductCategoryTB` (`ProductCategoryId`);

--
-- Constraints for table `StateTB`
--
ALTER TABLE `StateTB`
  ADD CONSTRAINT `FK_ContryTB_CountryId_To_StateTB_CountryId` FOREIGN KEY (`CountryId`) REFERENCES `CountryTB` (`CountryId`);

--
-- Constraints for table `UserSessionTB`
--
ALTER TABLE `UserSessionTB`
  ADD CONSTRAINT `FK_UserTB_UserId_To_USTB_UserId1` FOREIGN KEY (`UserId`) REFERENCES `UserTB` (`UserId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
