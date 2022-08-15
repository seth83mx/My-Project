-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para metaphorcebd
CREATE DATABASE IF NOT EXISTS `metaphorcebd` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `metaphorcebd`;

-- Volcando estructura para tabla metaphorcebd.contract
CREATE TABLE IF NOT EXISTS `contract` (
  `ContractId` bigint(20) NOT NULL AUTO_INCREMENT,
  `EmployeeId` int(11) NOT NULL,
  `ContractTypeId` tinyint(4) NOT NULL,
  `DateFrom` datetime NOT NULL,
  `DateTo` datetime NOT NULL,
  `SalaryPerDay` decimal(10,0) NOT NULL,
  `IsActive` tinyint(1) NOT NULL,
  `DateCreated` datetime NOT NULL,
  PRIMARY KEY (`ContractId`),
  UNIQUE KEY `ContractTypeId` (`ContractTypeId`),
  UNIQUE KEY `EmployeeId` (`EmployeeId`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`ContractTypeId`) REFERENCES `contractType` (`ContractTypeId`),
  CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla metaphorcebd.contract: ~1 rows (aproximadamente)
INSERT INTO `contract` (`ContractId`, `EmployeeId`, `ContractTypeId`, `DateFrom`, `DateTo`, `SalaryPerDay`, `IsActive`, `DateCreated`) VALUES
	(1, 1, 2, '2022-08-13 22:43:26', '2022-08-13 22:43:27', 1, 1, '2022-08-13 22:43:31');

-- Volcando estructura para tabla metaphorcebd.contracttype
CREATE TABLE IF NOT EXISTS `contractType` (
  `ContractTypeId` tinyint(4) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `Description` text DEFAULT NULL,
  `IsActive` tinyint(1) NOT NULL,
  `DataCreated` datetime NOT NULL,
  PRIMARY KEY (`ContractTypeId`),
  UNIQUE KEY `ContractTypeId` (`ContractTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla metaphorcebd.contracttype: ~2 rows (aproximadamente)
INSERT INTO `contractType` (`ContractTypeId`, `Name`, `Description`, `IsActive`, `DataCreated`) VALUES
	(1, 'Permanent', NULL, 1, '2022-08-12 00:00:00'),
	(2, 'Fixed-Term', NULL, 1, '2022-08-12 00:00:00'),
	(3, 'External', NULL, 1, '2022-08-12 00:00:00');

-- Volcando estructura para tabla metaphorcebd.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `EmployeeId` int(11) NOT NULL AUTO_INCREMENT,
  `TaxNumber` text NOT NULL,
  `Name` text NOT NULL,
  `LastName` text NOT NULL,
  `BirthDate` date NOT NULL,
  `Email` text NOT NULL,
  `CellPhone` text NOT NULL,
  `IsActive` tinyint(1) NOT NULL,
  `DateCreated` datetime NOT NULL,
  PRIMARY KEY (`EmployeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla metaphorcebd.employee: ~2 rows (aproximadamente)
INSERT INTO `employee` (`EmployeeId`, `TaxNumber`, `Name`, `LastName`, `BirthDate`, `Email`, `CellPhone`, `IsActive`, `DateCreated`) VALUES
	(1, 'RFC', 'Angel', 'Gomez', '1983-01-02', 'myemail@gmail.com', '33333333', 1, '2022-12-31 15:15:15'),
	(2, 'DEMO', 'Ange1', 'Gomez1', '1983-01-02', 'demo@demo.com', '1234567890', 1, '2011-07-14 13:43:37');

-- Volcando estructura para tabla metaphorcebd.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla metaphorcebd.users: ~2 rows (aproximadamente)
INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
	(1, 'angel', 'master', '1'),
	(2, 'angel1', 'master', '0'),
	(3, 'angel2', 'master', '1'),
	(4, 'metaphorce', 'm3t4Ph0rc3', '1');

-- Volcando estructura para tabla metaphorcebd.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla metaphorcebd.user_roles: ~3 rows (aproximadamente)
INSERT INTO `user_roles` (`idRole`, `role`, `username`) VALUES
	(1, 'ROLE_ADMIN', 'angel'),
	(2, 'ROLE_USER', 'angel2'),
	(3, 'ROLE_USER', 'angel1'),
	(4, 'ROLE_ADMIN', 'metaphorce');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
