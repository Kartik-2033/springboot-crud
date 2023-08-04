/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.33 : Database - customers
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`customers` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `customers`;

/*Table structure for table `customer_details` */

DROP TABLE IF EXISTS `customer_details`;

CREATE TABLE `customer_details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date_of_birth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `present_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `permanent_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int unsigned NOT NULL,
  `gender` int DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer_details` */

insert  into `customer_details`(`id`,`first_name`,`last_name`,`date_of_birth`,`mobile_number`,`present_address`,`permanent_address`,`age`,`gender`,`email`) values 
(4,'Rekha','Parrmar','2023-04-20','7894567894','Los Angeles','India',0,2,'rekhaa@gmail.com'),
(20,'Rashmi','Shinde','2017-06-08','8866827835','Lonawala','India',6,2,'rss@gmail.com'),
(40,'Vikash','Sharma','2019-05-08','4218531121','dasd','asdbfh',4,1,'raju@gmail.in'),
(42,'Kartik','Panchal','2001-03-24','8864687641','sadgh','asfd',22,1,'kp@gmail.com'),
(44,'janu','prajapati','1998-05-07','9904042365','Nikol','ahemdadba',25,2,'jp@gmail.com'),
(47,'Devin','Patel','2002-10-31','8867748522','Ranip','Nikol',20,1,'devin@gmail.com'),
(49,'Sadab','nawaz','2002-01-04','7894574856','pakistan','india',21,1,'sd@gm.im'),
(52,'Jigar','patel','2017-06-08','9874521012','ahmedabad','Naroda',6,1,'jigar@gm.in');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;