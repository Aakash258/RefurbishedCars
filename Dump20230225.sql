-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: cars
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car_images`
--
-- CREATE DATABASE CARS;

use cars;
DROP TABLE IF EXISTS `car_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_images` (
  `car_image_id` int NOT NULL AUTO_INCREMENT,
  `car_id` int NOT NULL,
  `car_image` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`car_image_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `car_images_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_images`
--

LOCK TABLES `car_images` WRITE;
/*!40000 ALTER TABLE `car_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `car_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `seller_id` int NOT NULL,
  `car_category` varchar(60) NOT NULL,
  `car_model` varchar(600) NOT NULL,
  `car_desc` varchar(600) DEFAULT NULL,
  `car_mfg_year` varchar(60) NOT NULL,
  `car_fuel_type` varchar(60) NOT NULL,
  `car_reg_due_year` varchar(60) DEFAULT NULL,
  `car_insurance_due_date` varchar(60) DEFAULT NULL,
  `car_transmission_type` varchar(60) NOT NULL,
  `car_ad_published_date` varchar(60) NOT NULL,
  `car_price` int NOT NULL,
  `car_discounted_price` int DEFAULT NULL,
  `car_sold` varchar(60) NOT NULL,
  `car_owners_count` int NOT NULL,
  `car_km_run` int NOT NULL,
  `car_rto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller_details` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_interest`
--

DROP TABLE IF EXISTS `customer_interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_interest` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `city` varchar(60) NOT NULL,
  `state` varchar(60) NOT NULL,
  `phone` int NOT NULL,
  `budget` int DEFAULT NULL,
  `interested_car_category` varchar(60) DEFAULT NULL,
  `car_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `query_date` varchar(80) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `customer_interest_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller_details` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_interest`
--

LOCK TABLES `customer_interest` WRITE;
/*!40000 ALTER TABLE `customer_interest` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_interest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller_details`
--

DROP TABLE IF EXISTS `seller_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller_details` (
  `seller_id` int NOT NULL AUTO_INCREMENT,
  `company_logo` varchar(500) DEFAULT NULL,
  `company_name` varchar(300) NOT NULL,
  `email` varchar(60) NOT NULL,
  `city` varchar(60) NOT NULL,
  `state` varchar(60) NOT NULL,
  `pincode` int NOT NULL,
  `phone` int NOT NULL,
  `address` varchar(900) NOT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller_details`
--

LOCK TABLES `seller_details` WRITE;
/*!40000 ALTER TABLE `seller_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `seller_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-25 17:12:21
