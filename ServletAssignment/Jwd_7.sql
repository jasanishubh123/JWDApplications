-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 20, 2020 at 01:06 PM
-- Server version: 5.7.28-0ubuntu0.18.04.4
-- PHP Version: 7.2.24-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Jwd_7`
--

-- --------------------------------------------------------

--
-- Table structure for table `CompanyTB`
--

CREATE TABLE `CompanyTB` (
  `CompanyId` int(11) NOT NULL,
  `CompanyName` varchar(50) NOT NULL,
  `Location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CompanyTB`
--

INSERT INTO `CompanyTB` (`CompanyId`, `CompanyName`, `Location`) VALUES
(1, 'HydroTech', 'Surat');

-- --------------------------------------------------------

--
-- Table structure for table `CustomerTB`
--

CREATE TABLE `CustomerTB` (
  `CustomerId` int(11) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  `Location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CustomerTB`
--

INSERT INTO `CustomerTB` (`CustomerId`, `CustomerName`, `Location`) VALUES
(1, 'Shubham', 'surat');

-- --------------------------------------------------------

--
-- Table structure for table `EmpTB`
--

CREATE TABLE `EmpTB` (
  `EmpId` int(11) NOT NULL,
  `EmpName` varchar(50) NOT NULL,
  `StoreId` int(11) NOT NULL,
  `Photo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `EmpTB`
--

INSERT INTO `EmpTB` (`EmpId`, `EmpName`, `StoreId`, `Photo`) VALUES
(1, 'jay', 1, NULL),
(2, 'Ishan', 1, NULL),
(3, 'Raja', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ItemTB`
--

CREATE TABLE `ItemTB` (
  `ItemId` int(11) NOT NULL,
  `ItemName` varchar(50) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Photo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ItemTB`
--

INSERT INTO `ItemTB` (`ItemId`, `ItemName`, `Qty`, `Price`, `Photo`) VALUES
(1, 'Table', 2, 1000, NULL),
(2, 'Chair', 3, 2121, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `PurchaseTB`
--

CREATE TABLE `PurchaseTB` (
  `PurchaseId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `SupplierId` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PurchaseTB`
--

INSERT INTO `PurchaseTB` (`PurchaseId`, `ItemId`, `SupplierId`, `Qty`, `Date`) VALUES
(1, 1, 1, 1, '2020-02-17 17:09:42'),
(2, 2, 1, 2, '2020-02-17 17:15:29');

-- --------------------------------------------------------

--
-- Table structure for table `SalesTB`
--

CREATE TABLE `SalesTB` (
  `SalesId` int(11) NOT NULL,
  `EmpId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SalesTB`
--

INSERT INTO `SalesTB` (`SalesId`, `EmpId`, `ItemId`, `CustomerId`, `Date`, `Qty`) VALUES
(1, 1, 2, 1, '2020-02-17 17:53:32', 2);

-- --------------------------------------------------------

--
-- Table structure for table `StoreTB`
--

CREATE TABLE `StoreTB` (
  `StoreId` int(11) NOT NULL,
  `StoreName` varchar(50) NOT NULL,
  `Location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `StoreTB`
--

INSERT INTO `StoreTB` (`StoreId`, `StoreName`, `Location`) VALUES
(1, 'Galaxy', 'valsad');

-- --------------------------------------------------------

--
-- Table structure for table `SupplierTB`
--

CREATE TABLE `SupplierTB` (
  `SupplierId` int(11) NOT NULL,
  `SupplierName` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SupplierTB`
--

INSERT INTO `SupplierTB` (`SupplierId`, `SupplierName`, `Gender`) VALUES
(1, 'Meet', 'Male'),
(2, 'Jash', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CompanyTB`
--
ALTER TABLE `CompanyTB`
  ADD PRIMARY KEY (`CompanyId`);

--
-- Indexes for table `CustomerTB`
--
ALTER TABLE `CustomerTB`
  ADD PRIMARY KEY (`CustomerId`);

--
-- Indexes for table `EmpTB`
--
ALTER TABLE `EmpTB`
  ADD PRIMARY KEY (`EmpId`),
  ADD KEY `Fk_Emp_To_Store` (`StoreId`);

--
-- Indexes for table `ItemTB`
--
ALTER TABLE `ItemTB`
  ADD PRIMARY KEY (`ItemId`);

--
-- Indexes for table `PurchaseTB`
--
ALTER TABLE `PurchaseTB`
  ADD PRIMARY KEY (`PurchaseId`),
  ADD KEY `Fk_Purchase_To_Item` (`ItemId`),
  ADD KEY `Fk_Purchase_To_Supplier` (`SupplierId`);

--
-- Indexes for table `SalesTB`
--
ALTER TABLE `SalesTB`
  ADD PRIMARY KEY (`SalesId`),
  ADD KEY `Fk_Sale_to_EmpId` (`EmpId`),
  ADD KEY `Fk_Sale_To_ItemId` (`ItemId`),
  ADD KEY `Fk_Sale_To_CustomerId` (`CustomerId`);

--
-- Indexes for table `StoreTB`
--
ALTER TABLE `StoreTB`
  ADD PRIMARY KEY (`StoreId`);

--
-- Indexes for table `SupplierTB`
--
ALTER TABLE `SupplierTB`
  ADD PRIMARY KEY (`SupplierId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CompanyTB`
--
ALTER TABLE `CompanyTB`
  MODIFY `CompanyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CustomerTB`
--
ALTER TABLE `CustomerTB`
  MODIFY `CustomerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `EmpTB`
--
ALTER TABLE `EmpTB`
  MODIFY `EmpId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ItemTB`
--
ALTER TABLE `ItemTB`
  MODIFY `ItemId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `PurchaseTB`
--
ALTER TABLE `PurchaseTB`
  MODIFY `PurchaseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `SalesTB`
--
ALTER TABLE `SalesTB`
  MODIFY `SalesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `StoreTB`
--
ALTER TABLE `StoreTB`
  MODIFY `StoreId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `SupplierTB`
--
ALTER TABLE `SupplierTB`
  MODIFY `SupplierId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `EmpTB`
--
ALTER TABLE `EmpTB`
  ADD CONSTRAINT `Fk_Emp_To_Store` FOREIGN KEY (`StoreId`) REFERENCES `StoreTB` (`StoreId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `PurchaseTB`
--
ALTER TABLE `PurchaseTB`
  ADD CONSTRAINT `Fk_Purchase_To_Item` FOREIGN KEY (`ItemId`) REFERENCES `ItemTB` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Purchase_To_Supplier` FOREIGN KEY (`SupplierId`) REFERENCES `SupplierTB` (`SupplierId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `SalesTB`
--
ALTER TABLE `SalesTB`
  ADD CONSTRAINT `Fk_Sale_To_CustomerId` FOREIGN KEY (`CustomerId`) REFERENCES `CustomerTB` (`CustomerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Sale_To_ItemId` FOREIGN KEY (`ItemId`) REFERENCES `ItemTB` (`ItemId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_Sale_to_EmpId` FOREIGN KEY (`EmpId`) REFERENCES `EmpTB` (`EmpId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
