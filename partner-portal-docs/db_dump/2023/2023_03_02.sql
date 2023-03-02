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
-- Table structure for table `anag_status`
--

DROP TABLE IF EXISTS `anag_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anag_status` (
  `idStatus` int NOT NULL,
  `descState` varchar(45) NOT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anag_status`
--
-- ORDER BY:  `idStatus`

LOCK TABLES `anag_status` WRITE;
/*!40000 ALTER TABLE `anag_status` DISABLE KEYS */;
INSERT INTO `anag_status` VALUES (1,'Started'),(2,'Work in Progress'),(3,'Finished');
/*!40000 ALTER TABLE `anag_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--
-- ORDER BY:  `id`

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Leslie','Andrews','leslie@luv2code.com'),(2,'Emma','Baumgarten','emma@luv2code.com'),(3,'Avani','Gupta','avani@luv2code.com'),(4,'Yuri','Petrov','yuri@luv2code.com'),(5,'Juan','Vega','juan@luv2code.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `idProject` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descProject` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `codeProject` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `createdBy` int NOT NULL,
  PRIMARY KEY (`idProject`),
  UNIQUE KEY `uc_code_project` (`codeProject`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--
-- ORDER BY:  `idProject`

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'partner portal','Descrizione del progetto 1','PP0001',3),(2,'ciorc pleis','Descrizione del progetto 2','CP0001',3),(3,'Progetto 3','Descrizione del progetto 3','P30001',3);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_project_status`
--

DROP TABLE IF EXISTS `rel_project_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_project_status` (
  `idRelProjectStatus` int NOT NULL AUTO_INCREMENT,
  `idProject` int NOT NULL,
  `idStatus` int NOT NULL,
  `createdAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idRelProjectStatus`),
  KEY `FK_rel_project_status_project` (`idProject`),
  KEY `FK_rel_project_status_anag_state` (`idStatus`),
  CONSTRAINT `FK_rel_project_status_anag_state` FOREIGN KEY (`idStatus`) REFERENCES `anag_status` (`idStatus`),
  CONSTRAINT `FK_rel_project_status_project` FOREIGN KEY (`idProject`) REFERENCES `project` (`idProject`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_project_status`
--
-- ORDER BY:  `idRelProjectStatus`

LOCK TABLES `rel_project_status` WRITE;
/*!40000 ALTER TABLE `rel_project_status` DISABLE KEYS */;
INSERT INTO `rel_project_status` VALUES (1,2,1,'2023-02-20 17:16:51'),(2,2,2,'2023-02-20 17:17:03'),(3,3,1,'2023-02-20 17:17:07'),(4,3,2,'2023-02-20 17:17:12'),(5,3,3,'2023-02-20 17:17:17'),(6,1,1,'2023-02-20 17:45:04');
/*!40000 ALTER TABLE `rel_project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--
-- ORDER BY:  `id`

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_PARTNER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--
-- ORDER BY:  `id`

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mario.rossi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Mario','Rossi','mario@mail.com'),(2,'luigi.verdi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Luigi','Verdi','luigi@mail.com'),(3,'ruben.garruto','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Ruben','Garruto','ruben@mail.com'),(4,'mimmo','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','mimmo','memmo','mimmo@mail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--
-- ORDER BY:  `user_id`,`role_id`

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(2,2),(3,1),(3,2),(3,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_project`
--

DROP TABLE IF EXISTS `view_project`;
/*!50001 DROP VIEW IF EXISTS `view_project`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_project` AS SELECT 
 1 AS `idProject`,
 1 AS `title`,
 1 AS `descProject`,
 1 AS `idStatus`,
 1 AS `dateLastState`,
 1 AS `nameCreatedBy`,
 1 AS `createdBy`,
 1 AS `codeProject`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'partner_portal'
--

--
-- Dumping routines for database 'partner_portal'
--

--
-- Final view structure for view `view_project`
--

/*!50001 DROP VIEW IF EXISTS `view_project`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`PARTNER_PORTAL`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_project` AS select `p`.`idProject` AS `idProject`,`p`.`title` AS `title`,`p`.`descProject` AS `descProject`,`s`.`idStatus` AS `idStatus`,`s`.`dateLastState` AS `dateLastState`,concat(`u`.`first_name`,' ',`u`.`last_name`) AS `nameCreatedBy`,`p`.`createdBy` AS `createdBy`,`p`.`codeProject` AS `codeProject` from ((`project` `p` join (select `rps`.`idProject` AS `idProject`,`rps`.`idStatus` AS `idStatus`,`rps`.`createdAt` AS `dateLastState` from `rel_project_status` `rps` where (`rps`.`createdAt` = (select max(`rel_project_status`.`createdAt`) from `rel_project_status` where (`rel_project_status`.`idProject` = `rps`.`idProject`)))) `s` on((`p`.`idProject` = `s`.`idProject`))) join `user` `u` on((`p`.`createdBy` = `u`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-02 15:38:47
