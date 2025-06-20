/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.5.29-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: appdb
-- ------------------------------------------------------
-- Server version	5.6.51

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `appdb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `appdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `appdb`;

--
-- Table structure for table `contact_request`
--

DROP TABLE IF EXISTS `contact_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enquiry` varchar(3000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_request`
--

LOCK TABLES `contact_request` WRITE;
/*!40000 ALTER TABLE `contact_request` DISABLE KEYS */;
INSERT INTO `contact_request` VALUES (1,'jane@example.com','Looking to collaborate','Jane'),(2,'jane@example.com','Looking to collaborate','Jane'),(3,'jane@example.com','Looking to collaborate','Jane'),(4,'jane@example.com','Looking to collaborate','Jane'),(6,'jane@example.com','Looking to collaborate','Jane'),(8,'alice@mail.com','Interested in collaboration','Alice'),(9,'bob@mail.com','Just saying hi','Bob'),(10,'jane@example.com','Looking to collaborate','Jane'),(12,'alice@mail.com','Interested in collaboration','Alice'),(13,'bob@mail.com','Just saying hi','Bob'),(14,'jane@example.com','Looking to collaborate','Jane'),(16,'alice@mail.com','Interested in collaboration','Alice'),(17,'bob@mail.com','Just saying hi','Bob'),(18,'jane@example.com','Looking to collaborate','Jane');
/*!40000 ALTER TABLE `contact_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cover_letter`
--

DROP TABLE IF EXISTS `cover_letter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `cover_letter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cover_letter`
--

LOCK TABLES `cover_letter` WRITE;
/*!40000 ALTER TABLE `cover_letter` DISABLE KEYS */;
INSERT INTO `cover_letter` VALUES (1,'Updated cover letter content'),(2,'Updated cover letter content'),(3,'Updated cover letter content'),(4,'Updated cover letter content'),(5,'Updated cover letter content'),(6,'Updated cover letter content'),(7,'Updated cover letter content');
/*!40000 ALTER TABLE `cover_letter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `experience` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (19,'A','Old job','2019-2020','Engineer'),(20,'B','Recent job','2022-2023','Lead'),(22,'ABC Corp','Worked on backend','2020-2022','Developer'),(23,'Test Ltd','Updated desc','2021-2022','Dev');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(3000) DEFAULT NULL,
  `snapshot_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(2,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(3,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(4,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(5,'Desc','img.jpg','Updated Title'),(6,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(8,'Desc','img.jpg','Updated Title'),(9,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(11,'Desc','img.jpg','Updated Title'),(12,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site'),(14,'Desc','img.jpg','Updated Title'),(15,'React + Spring Boot','http://image.com/snap.jpg','Portfolio Site');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `proficiency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Java','Expert'),(2,'Java','Expert'),(3,'Java','Expert'),(4,'Java','Expert'),(5,'React','Intermediate'),(7,'Spring Boot','Advanced'),(8,'Java','Expert'),(9,'React','Intermediate'),(11,'Spring Boot','Advanced'),(12,'Java','Expert'),(13,'React','Intermediate'),(15,'Spring Boot','Advanced'),(16,'Java','Expert'),(17,'React','Intermediate'),(19,'Spring Boot','Advanced'),(20,'Java','Expert'),(21,'React','Intermediate');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-20 11:47:07
