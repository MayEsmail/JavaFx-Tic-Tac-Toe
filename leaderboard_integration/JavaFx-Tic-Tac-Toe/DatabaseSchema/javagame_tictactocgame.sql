-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: javagame
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

--
-- Table structure for table `tictactocgame`
--

DROP TABLE IF EXISTS `tictactocgame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tictactocgame` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Score` int DEFAULT '0',
  `Win` int DEFAULT '0',
  `Lose` int DEFAULT '0',
  `SavedFile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tictactocgame`
--

LOCK TABLES `tictactocgame` WRITE;
/*!40000 ALTER TABLE `tictactocgame` DISABLE KEYS */;
INSERT INTO `tictactocgame` VALUES (1,'Dakhly','1212',1500,15,3,'addd'),(2,'Ahmed','1212',1500,15,3,'addd'),(3,'mohamed','0',0,0,0,NULL),(4,'mohamed','0',0,0,0,NULL),(5,'mohamed','0',240,24,0,NULL),(6,'mohamed','0',0,0,24,NULL),(7,'mohamed','0',120,0,0,NULL),(8,'mohamed','0',0,0,0,NULL),(9,'mohamed','0',0,0,0,NULL),(10,'mohamed','0',0,0,0,NULL),(11,'mohamed','0',0,0,0,NULL),(12,'mohamed','0',0,0,0,NULL),(13,'mohamed','0',0,0,0,NULL),(14,'mohamed','0',0,0,0,NULL),(15,'mohamed','0',0,0,0,NULL),(16,'mohamed','0',0,0,0,NULL),(17,'mohamed','0',0,0,0,NULL),(18,'mohamed','0',0,0,0,NULL),(19,'mohamed','0',0,0,0,NULL),(20,'mohamed','0',0,0,0,NULL),(31,'Ali','0',0,0,0,NULL),(32,'Ali','0',0,0,0,NULL),(33,'Ali','0',0,0,0,NULL),(34,'Ali','0',0,0,0,NULL),(35,'Ali','0',0,0,0,NULL),(36,'Ali','0',0,0,0,NULL),(37,'Ali','0',0,0,0,NULL),(38,'Ahmed Eldakhly','123456',0,0,0,NULL),(39,'AhmedEldakhly',NULL,0,0,0,NULL),(40,'Hossam',NULL,0,0,0,NULL),(41,'Ali',NULL,0,0,0,NULL),(42,'ssssssss',NULL,0,0,0,NULL),(43,'Ahmed',NULL,0,0,0,NULL),(44,'Fgggggggg',NULL,0,0,0,NULL),(45,'dddddddddd',NULL,0,0,0,NULL),(46,'Ahmed',NULL,0,0,0,NULL),(47,'kkkkkkkkk',NULL,0,0,0,NULL),(48,'lll',NULL,0,0,0,NULL),(49,'5555',NULL,0,0,0,NULL),(50,'ffff',NULL,0,0,0,NULL),(51,'kkkkkk',NULL,0,0,0,NULL),(52,'AhmedEldakhly',NULL,0,0,0,NULL),(53,'Ahmed',NULL,0,0,0,NULL),(54,'Eldakhly',NULL,0,0,0,NULL),(55,'Dakhlyyyy',NULL,0,0,0,NULL),(56,'DaDa',NULL,0,0,0,NULL),(57,'Dakhly',NULL,0,0,0,NULL),(58,'Dakhly',NULL,0,0,0,NULL),(59,'Dakhly',NULL,0,0,0,NULL),(60,'Ahmed',NULL,0,0,0,NULL),(61,'Daaaaa',NULL,0,0,0,NULL),(62,'Mahmood',NULL,0,0,0,NULL),(63,'DaA',NULL,0,0,0,NULL),(64,'DaA',NULL,0,0,0,NULL),(65,'DaA',NULL,0,0,0,NULL),(66,'dddddd',NULL,0,0,0,NULL),(67,'aaaaaaa',NULL,0,0,0,NULL),(68,'ggggggg',NULL,0,0,0,NULL),(69,'fffff',NULL,0,0,0,NULL),(70,'Dakhly',NULL,0,0,0,NULL),(71,'Ali','0',0,0,0,NULL),(72,'Ali','0',0,0,0,NULL),(73,'Ali','0',0,0,0,NULL),(74,'Ali','0',0,0,0,NULL),(75,'Ali','0',0,0,0,NULL),(76,'Ali','0',0,0,0,NULL),(77,'Ali','0',0,0,0,NULL),(78,'Ali','0',0,0,0,NULL),(79,'Ali','0',0,0,0,NULL),(80,'Ali','0',0,0,0,NULL),(81,'Ali','0',0,0,0,NULL),(82,'Ali','0',0,0,0,NULL),(83,'ddddd',NULL,0,0,0,NULL),(84,'oooooo',NULL,0,0,0,NULL),(85,'lllll',NULL,0,0,0,NULL),(86,'Ahhh',NULL,0,0,0,NULL),(87,'hhhhhh',NULL,0,0,0,NULL),(88,'hhhhhh',NULL,0,0,0,NULL),(89,'lllllll',NULL,0,0,0,NULL),(90,'',NULL,0,0,0,NULL),(91,'ooooo',NULL,0,0,0,NULL),(92,'aaaa',NULL,0,0,0,NULL),(93,'hhhh',NULL,0,0,0,NULL),(94,'hhhhh',NULL,0,0,0,NULL),(95,'yyyyyyy',NULL,0,0,0,NULL),(96,'oooooooo',NULL,0,0,0,NULL),(97,'dddddddd',NULL,0,0,0,NULL),(98,'ggggggggg',NULL,0,0,0,NULL),(99,'ddddd',NULL,0,0,0,NULL),(100,'ffff',NULL,0,0,0,NULL),(101,'ffffff',NULL,0,0,0,NULL),(102,'ggggggg',NULL,0,0,0,NULL),(103,'xxxxxx',NULL,0,0,0,NULL),(104,'dddddd',NULL,0,0,0,NULL),(105,'AhmedEldakhly',NULL,0,0,0,NULL),(106,'Ahmed',NULL,0,0,0,NULL),(107,'ggggg',NULL,0,0,0,NULL),(108,'NewDakhly',NULL,0,0,0,NULL),(109,'ddfdfd',NULL,0,0,0,NULL);
/*!40000 ALTER TABLE `tictactocgame` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-22 19:08:19
