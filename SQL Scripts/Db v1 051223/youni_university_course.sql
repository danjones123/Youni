-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: youni
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
-- Table structure for table `university_course`
--

DROP TABLE IF EXISTS `university_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `university_course` (
  `university_course_id` int NOT NULL AUTO_INCREMENT,
  `university_subject_id` int NOT NULL,
  `university_course_name` varchar(150) DEFAULT NULL,
  `university_course_length` int DEFAULT NULL,
  `degree_type` varchar(30) DEFAULT NULL,
  `UCAS_code` varchar(45) DEFAULT NULL,
  `required_grades_letters_upper` varchar(45) DEFAULT NULL,
  `required_grades_letters_lower` varchar(45) DEFAULT NULL,
  `required_grades_IB` varchar(45) DEFAULT NULL,
  `has_year_industry` tinyint DEFAULT NULL,
  `has_foundation_year` tinyint DEFAULT NULL,
  PRIMARY KEY (`university_course_id`),
  KEY `subject_id_idx` (`university_subject_id`),
  CONSTRAINT `subj` FOREIGN KEY (`university_subject_id`) REFERENCES `university_subject` (`university_subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university_course`
--

LOCK TABLES `university_course` WRITE;
/*!40000 ALTER TABLE `university_course` DISABLE KEYS */;
INSERT INTO `university_course` VALUES (1,1,'Computer Science',3,'BSc','G400','AAB','ABB','6,5,5',0,0);
/*!40000 ALTER TABLE `university_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 23:15:11
