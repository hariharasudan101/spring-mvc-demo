/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 8.0.12 : Database - bms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/'bms' /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE 'bms';

/*Table structure for table 'customer' */

DROP TABLE IF EXISTS 'customer';

CREATE TABLE 'customer' (
  'id' bigint(20) NOT NULL AUTO_INCREMENT,
  'first_name' varchar(50) DEFAULT NULL,
  'last_name' varchar(50) DEFAULT NULL,
  'dob' date DEFAULT NULL,
  'salary' bigint(20) DEFAULT NULL,
  'accountNumber' int(11) DEFAULT NULL,
  'password' varchar(40) DEFAULT NULL,
  'profile_id' bigint(20) DEFAULT NULL,
  PRIMARY KEY ('id'),
  KEY 'FK_PROFILE_ID' ('profile_id'),
  CONSTRAINT 'FK_PROFILE_ID' FOREIGN KEY ('profile_id') REFERENCES 'customer_profile' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table 'customer_profile' */

DROP TABLE IF EXISTS 'customer_profile';

CREATE TABLE 'customer_profile' (
  'id' bigint(20) NOT NULL AUTO_INCREMENT,
  'email' varchar(50) DEFAULT NULL,
  'phone' varchar(15) DEFAULT NULL,
  'addressLine1' varchar(50) DEFAULT NULL,
  'addressLine2' varchar(50) DEFAULT NULL,
  'city' varchar(30) DEFAULT NULL,
  'state' varchar(30) DEFAULT NULL,
  'zip' varchar(10) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table 'loan' */

DROP TABLE IF EXISTS 'loan';

CREATE TABLE 'loan' (
  'id' bigint(20) NOT NULL AUTO_INCREMENT,
  'type' varchar(20) DEFAULT NULL,
  'amount' bigint(20) DEFAULT NULL,
  'booked_date' date DEFAULT NULL,
  'dispatched_date' date DEFAULT NULL,
  'emi_start_date' date DEFAULT NULL,
  'emi_amount' bigint(20) DEFAULT NULL,
  'number_of_emi' int(11) DEFAULT NULL,
  'customer' bigint(20) DEFAULT NULL,
  PRIMARY KEY ('id'),
  KEY 'customer_fk' ('customer'),
  CONSTRAINT 'customer_fk' FOREIGN KEY ('customer') REFERENCES 'customer' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
