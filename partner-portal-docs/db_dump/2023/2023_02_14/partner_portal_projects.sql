-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: partner_portal
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
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(32766) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'project 1','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(2,'project 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(3,'project 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(4,'project 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque condimentum tortor et vehicula hendrerit. Vestibulum vehicula eu libero in convallis. Nunc blandit vestibulum urna, in tempus dolor. Maecenas posuere id dui et efficitur. Mauris volutpat ultricies nulla, eu blandit ligula finibus a. Sed tincidunt vulputate mi, in posuere magna laoreet et. Aliquam rutrum urna et dolor pulvinar scelerisque. Vivamus justo nisi, placerat nec sollicitudin at, semper quis nisl. Curabitur et orci nec nunc egestas mattis a et velit. Maecenas blandit felis et augue consectetur faucibus. Integer sollicitudin ligula et sollicitudin rutrum. Praesent placerat lectus at tellus elementum, et tincidunt tellus mattis. Mauris eget felis et orci fermentum cursus id sed nibh. Ut porta sapien ut felis ultricies, nec facilisis lectus dapibus. Etiam at elit tristique, interdum odio interdum, laoreet tortor.'),(5,'project 5','coming soon..');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-01 14:46:12
