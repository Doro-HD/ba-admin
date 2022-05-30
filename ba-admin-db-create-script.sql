-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: ilzyz0heng1bygi8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com    Database: u58dr0062pcv1ajo
-- ------------------------------------------------------
-- Server version	8.0.23

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `car_number` int NOT NULL AUTO_INCREMENT,
  `chassis_number` varchar(45) NOT NULL,
  `car_state` varchar(45) NOT NULL,
  PRIMARY KEY (`car_number`),
  UNIQUE KEY `chasisnumber_UNIQUE` (`chassis_number`),
  UNIQUE KEY `id_UNIQUE` (`car_number`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'56AB56','available'),(11,'98BN56','available'),(21,'3876ET678','available'),(31,'789GT45','available'),(41,'3456GF45','available'),(51,'8356HJ56','available'),(61,'377455BE56','available'),(71,'76FGTR56','available'),(81,'HGJFH6574','available'),(91,'HGJF93','available'),(101,'KFJHS09384','available');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damage_reports`
--

DROP TABLE IF EXISTS `damage_reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `damage_reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_cost` int NOT NULL,
  `car_number` int NOT NULL,
  `warning_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `car_id_idx` (`car_number`),
  CONSTRAINT `car_id` FOREIGN KEY (`car_number`) REFERENCES `cars` (`car_number`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damage_reports`
--

LOCK TABLES `damage_reports` WRITE;
/*!40000 ALTER TABLE `damage_reports` DISABLE KEYS */;
INSERT INTO `damage_reports` VALUES (1,0,81,'2017-06-13'),(11,100,1,'2018-02-01'),(12,1200,11,'2022-06-30'),(13,500,21,'2021-10-15'),(14,30000,31,'2022-06-22'),(15,1500,101,'2022-06-17'),(16,0,81,'2022-05-30'),(17,0,81,'2022-05-30'),(18,0,81,'2022-05-30'),(19,0,81,'2022-05-30');
/*!40000 ALTER TABLE `damage_reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damages`
--

DROP TABLE IF EXISTS `damages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `damages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `damage_type` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `damage_report_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `damagereport_id_idx` (`damage_report_id`),
  CONSTRAINT `damagereport_id` FOREIGN KEY (`damage_report_id`) REFERENCES `damage_reports` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damages`
--

LOCK TABLES `damages` WRITE;
/*!40000 ALTER TABLE `damages` DISABLE KEYS */;
INSERT INTO `damages` VALUES (1,'Ridse',12,1),(11,'smadret forrude',1000,16);
/*!40000 ALTER TABLE `damages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leases`
--

DROP TABLE IF EXISTS `leases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lease_name` varchar(45) NOT NULL,
  `monthly_payment` double NOT NULL,
  `car_number` int NOT NULL,
  `expiration_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `carid_idx` (`car_number`),
  CONSTRAINT `carid` FOREIGN KEY (`car_number`) REFERENCES `cars` (`car_number`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leases`
--

LOCK TABLES `leases` WRITE;
/*!40000 ALTER TABLE `leases` DISABLE KEYS */;
INSERT INTO `leases` VALUES (31,'Lennart Mogensen',1500,41,'2022-10-20'),(32,'Karen Sækkesen',2900,61,'2023-03-20'),(33,'Postmand Per',4500,1,'2021-07-20'),(34,'Troels Karn',6969,11,'2019-11-20'),(35,'Victor',4200,81,'2022-10-20'),(36,'David',6900,91,'2022-10-20');
/*!40000 ALTER TABLE `leases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `user_password` varchar(80) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (31,'admin1','$2a$12$ryyQwX3sq6AE.T7uRxamyOzGc9aVtlTtRFzja1Y96FcTsJevDc6Ri','dataRegistration'),(41,'admin2','$2a$12$zjbvzrdYB8uKutUIsOJLfOxQp61ZZA2kK1pVDHjJX/NEG/uoh8sCK','damageReport'),(51,'admin3','$2a$12$o04UZ5nA9/UvycPQsspPBecpMlV4U6fGJeBqrVm/36P6qRlUgR4L6','businessEnginering');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30 11:31:10
