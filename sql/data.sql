-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: quick_ap
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `food_id` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `food_type` varchar(255) NOT NULL DEFAULT '',
  `price` decimal(10,1) NOT NULL,
  `image_url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'PR01','Grilled Chicken Casear Slalad','Appetizer',53.0,'https://s2.loli.net/2022/12/06/NejHqSxvJhlcTM2.jpg'),(2,'PR02','Parma Ham and Red Quiona Salad','Appetizer',73.0,'https://s2.loli.net/2022/12/06/sTCLXFKmgdbntAx.jpg'),(3,'PR03','Creamy Pumpkin Soup','Soup',35.0,'https://s2.loli.net/2022/12/06/MbTzv2OlCVL4Xho.jpg'),(4,'PR04','Creamy Mushroom Soup','Soup',35.0,'https://s2.loli.net/2022/12/06/ZqsC8pj5Au6cPgF.jpg'),(5,'PR05','Malaysian Durian Pizza','Pizza',70.0,'https://s2.loli.net/2022/12/06/vhUg6dACP2t5Lu1.jpg'),(6,'PR06','I love meat! Pepperoni and Meatball Pizza','Pizza',95.0,'https://s2.loli.net/2022/12/06/TuZBc1kW7CogSqx.jpg'),(7,'PR07','New Zealand Rib-eye Steak','Main Dish',188.0,'https://s2.loli.net/2022/12/06/xuaEQtySZcdhILp.jpg'),(8,'PR08','Pan-fried Red Tuna with Asparagus Cream','Main Dish',98.0,'https://s2.loli.net/2022/12/06/GuZKsI5CweliYfE.jpg'),(9,'PR09','Spaghetti Bolognese','Pasta & Risotto',48.0,'https://s2.loli.net/2022/12/06/AMJbUYO8t6HoFfS.jpg'),(10,'PR10','Cuttle Fish Risotto','Pasta & Risotto',90.0,'https://s2.loli.net/2022/12/06/6RF1n3KigeI8GbZ.jpg'),(11,'PR11','A&P Deluxe Platter','Side Dish',128.0,'https://s2.loli.net/2022/12/06/6n42ibqW9TJa1Mv.jpg'),(12,'PR12','Nachos','Side Dish',48.0,'https://s2.loli.net/2022/12/06/3IQvw47TPe6Ni2O.jpg');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_food`
--

DROP TABLE IF EXISTS `order_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_food` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `table_id` int NOT NULL,
  `food_id` varchar(255) NOT NULL DEFAULT '',
  `price` decimal(10,1) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_food_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='All food in order under corresponding table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_food`
--

LOCK TABLES `order_food` WRITE;
/*!40000 ALTER TABLE `order_food` DISABLE KEYS */;
INSERT INTO `order_food` VALUES (1,1,'PR1',23.0,1),(2,1,'PR2',24.5,1),(3,2,'PR2',24.5,0),(4,11,'PR02',42.0,0),(5,11,'PR02',42.0,0),(6,11,'PR01',36.0,0),(7,11,'PR01',36.0,0),(8,11,'PR01',36.0,0),(9,13,'PR02',42.0,0),(10,13,'PR02',42.0,0),(11,13,'PR01',36.0,0),(12,13,'PR02',42.0,0),(13,13,'PR02',42.0,0),(14,13,'PR01',36.0,0),(15,13,'PR01',36.0,0),(16,13,'PR01',36.0,0),(17,13,'PR06',95.0,0);
/*!40000 ALTER TABLE `order_food` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-08 20:26:13
