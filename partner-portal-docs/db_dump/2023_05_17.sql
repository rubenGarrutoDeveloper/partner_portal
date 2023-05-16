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
INSERT INTO `anag_status` (`idStatus`, `descState`) VALUES (1,'Started'),(2,'Work in Progress'),(3,'Finished');
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
INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`) VALUES (1,'Leslie','Andrews','leslie@luv2code.com'),(2,'Emma','Baumgarten','emma@luv2code.com'),(3,'Avani','Gupta','avani@luv2code.com'),(4,'Yuri','Petrov','yuri@luv2code.com'),(5,'Juan','Vega','juan@luv2code.com');
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
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descProject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
INSERT INTO `project` (`idProject`, `title`, `descProject`, `codeProject`, `createdBy`) VALUES (1,'partner portal','Descrizione del progetto 1','PP0001',3),(2,'ciorc pleis','Descrizione del progetto 2','CP0001',3),(3,'Progetto 3','Descrizione del progetto 3','P30001',3);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_phase`
--

DROP TABLE IF EXISTS `project_phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_phase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `fund_raised` decimal(10,2) DEFAULT NULL,
  `total_fund` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `check_start_end_time` CHECK ((`start_time` < `end_time`))
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_phase`
--
-- ORDER BY:  `id`

LOCK TABLES `project_phase` WRITE;
/*!40000 ALTER TABLE `project_phase` DISABLE KEYS */;
INSERT INTO `project_phase` (`id`, `title`, `description`, `start_time`, `end_time`, `fund_raised`, `total_fund`) VALUES (1,'Phase 1: Found Raising','Raising initial funds for the project','2023-01-01 10:00:00','2023-01-31 23:59:59',5000.00,10000.00),(2,'Phase 2: Payments system','Devoloping payments system','2023-02-01 00:00:00','2023-03-15 23:59:59',12000.00,20000.00),(3,'Phase 3: Beta Testing of Payments System','Testing the project with a limited audience','2023-03-16 00:00:00','2023-04-15 23:59:59',18000.00,25000.00),(4,'Phase 1: Design','Designing the project','2023-02-15 10:00:00','2023-02-28 23:59:59',5000.00,10000.00),(5,'Phase 2: Development','Developing the project','2023-03-01 00:00:00','2023-04-15 23:59:59',12000.00,20000.00),(6,'Phase 1: Prototype','Building a prototype of the project','2023-04-01 10:00:00','2023-04-30 23:59:59',5000.00,10000.00),(7,'Phase 2: Testing','Testing the project prototype','2023-05-01 00:00:00','2023-05-31 23:59:59',12000.00,20000.00),(12,'test 6 ','des','2023-04-25 22:02:00','2023-04-29 22:02:00',0.00,7000.00);
/*!40000 ALTER TABLE `project_phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_project_phase`
--

DROP TABLE IF EXISTS `rel_project_phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_project_phase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_project` int NOT NULL,
  `id_phase` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_project_phase` (`id_project`,`id_phase`),
  KEY `id_phase` (`id_phase`),
  CONSTRAINT `rel_project_phase_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`idProject`),
  CONSTRAINT `rel_project_phase_ibfk_2` FOREIGN KEY (`id_phase`) REFERENCES `project_phase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_project_phase`
--
-- ORDER BY:  `id`

LOCK TABLES `rel_project_phase` WRITE;
/*!40000 ALTER TABLE `rel_project_phase` DISABLE KEYS */;
INSERT INTO `rel_project_phase` (`id`, `id_project`, `id_phase`) VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,4),(5,2,5),(6,2,6),(7,3,7);
/*!40000 ALTER TABLE `rel_project_phase` ENABLE KEYS */;
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
INSERT INTO `rel_project_status` (`idRelProjectStatus`, `idProject`, `idStatus`, `createdAt`) VALUES (1,2,1,'2023-02-20 17:16:51'),(2,2,2,'2023-02-20 17:17:03'),(3,3,1,'2023-02-20 17:17:07'),(4,3,2,'2023-02-20 17:17:12'),(5,3,3,'2023-02-20 17:17:17'),(6,1,1,'2023-02-20 17:45:04');
/*!40000 ALTER TABLE `rel_project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_project_user`
--

DROP TABLE IF EXISTS `rel_project_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_project_user` (
  `id` int NOT NULL,
  `idProject` int NOT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idProject` (`idProject`),
  KEY `idUser` (`idUser`),
  CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`),
  CONSTRAINT `rel_project_user_ibfk_1` FOREIGN KEY (`idProject`) REFERENCES `project` (`idProject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_project_user`
--
-- ORDER BY:  `id`

LOCK TABLES `rel_project_user` WRITE;
/*!40000 ALTER TABLE `rel_project_user` DISABLE KEYS */;
INSERT INTO `rel_project_user` (`id`, `idProject`, `idUser`) VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(7,2,2),(8,2,3),(9,2,4),(11,3,3),(12,3,2);
/*!40000 ALTER TABLE `rel_project_user` ENABLE KEYS */;
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
INSERT INTO `role` (`id`, `name`) VALUES (1,'ROLE_USER'),(2,'ROLE_PARTNER'),(3,'ROLE_ADMIN');
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
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`) VALUES (1,'matteo.bonarriva','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','matteo','bonarriva','matteo@mail.com'),(2,'luigi.verdi','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Luigi','Verdi','luigi@mail.com'),(3,'ruben.garruto','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','Ruben','Garruto','ruben@mail.com'),(4,'mimmo','$2a$10$vfKc4NYxiitYGXjXUySj1uEorw2OK/B/nC/crMqau2ljVYzZiju22','mimmo','memmo','mimmo@mail.com');
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
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(3,1),(3,2),(3,3);
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
-- Temporary view structure for view `view_rel_project_phase`
--

DROP TABLE IF EXISTS `view_rel_project_phase`;
/*!50001 DROP VIEW IF EXISTS `view_rel_project_phase`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_rel_project_phase` AS SELECT 
 1 AS `id_project`,
 1 AS `id_phase`,
 1 AS `title`,
 1 AS `description`,
 1 AS `start_time`,
 1 AS `end_time`,
 1 AS `fund_raised`,
 1 AS `total_fund`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_rel_project_user`
--

DROP TABLE IF EXISTS `view_rel_project_user`;
/*!50001 DROP VIEW IF EXISTS `view_rel_project_user`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_rel_project_user` AS SELECT 
 1 AS `uuid`,
 1 AS `id_project`,
 1 AS `id_user`,
 1 AS `first_name`,
 1 AS `last_name`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

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

--
-- Final view structure for view `view_rel_project_phase`
--

/*!50001 DROP VIEW IF EXISTS `view_rel_project_phase`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`PARTNER_PORTAL`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_rel_project_phase` AS select `p`.`idProject` AS `id_project`,`pp`.`id` AS `id_phase`,`pp`.`title` AS `title`,`pp`.`description` AS `description`,`pp`.`start_time` AS `start_time`,`pp`.`end_time` AS `end_time`,`pp`.`fund_raised` AS `fund_raised`,`pp`.`total_fund` AS `total_fund` from ((`project` `p` join `rel_project_phase` `rpp` on((`p`.`idProject` = `rpp`.`id_project`))) join `project_phase` `pp` on((`rpp`.`id_phase` = `pp`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_rel_project_user`
--

/*!50001 DROP VIEW IF EXISTS `view_rel_project_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`PARTNER_PORTAL`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_rel_project_user` AS select uuid() AS `uuid`,`rp`.`idProject` AS `id_project`,`u`.`id` AS `id_user`,`u`.`first_name` AS `first_name`,`u`.`last_name` AS `last_name`,`u`.`email` AS `email` from (`rel_project_user` `rp` join `user` `u` on((`rp`.`idUser` = `u`.`id`))) */;
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

-- Dump completed on 2023-05-16 23:51:33
