-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: agencia_viagens
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `pacotes`
--

DROP TABLE IF EXISTS `pacotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacotes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_ida` date DEFAULT NULL,
  `data_volta` date DEFAULT NULL,
  `destino` varchar(255) DEFAULT NULL,
  `dias_pacote` int DEFAULT NULL,
  `origem` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `hotel_id` bigint DEFAULT NULL,
  `voo_ida_id` bigint DEFAULT NULL,
  `voo_volta_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnd0y06ec6d4a1vt9dxgt27v6f` (`hotel_id`),
  KEY `FKs5b9rnxd3rsvn6irs8xr2sjxr` (`voo_ida_id`),
  KEY `FK2fh67bia55l0aaaoollspqh5d` (`voo_volta_id`),
  CONSTRAINT `FK2fh67bia55l0aaaoollspqh5d` FOREIGN KEY (`voo_volta_id`) REFERENCES `voos` (`id`),
  CONSTRAINT `FKnd0y06ec6d4a1vt9dxgt27v6f` FOREIGN KEY (`hotel_id`) REFERENCES `hoteis` (`id`),
  CONSTRAINT `FKs5b9rnxd3rsvn6irs8xr2sjxr` FOREIGN KEY (`voo_ida_id`) REFERENCES `voos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacotes`
--

LOCK TABLES `pacotes` WRITE;
/*!40000 ALTER TABLE `pacotes` DISABLE KEYS */;
INSERT INTO `pacotes` VALUES (3,'2024-01-20','2024-01-30','Porto seguro',0,'Belo Horizonte',2250,1,1,3);
/*!40000 ALTER TABLE `pacotes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcular_preco_pacote` BEFORE INSERT ON `pacotes` FOR EACH ROW BEGIN
    DECLARE preco_voo_ida REAL;
    DECLARE preco_voo_volta REAL;
    DECLARE preco_diaria_hotel REAL;

    SELECT preco INTO preco_voo_ida FROM voos WHERE id = NEW.voo_ida_id;

    SELECT preco INTO preco_voo_volta FROM voos WHERE id = NEW.voo_volta_id;

    SELECT preco_diaria INTO preco_diaria_hotel FROM hoteis WHERE id = NEW.hotel_id;

    SET NEW.preco = preco_voo_ida + preco_voo_volta + ((DATEDIFF(NEW.data_volta, NEW.data_ida) + 1) * preco_diaria_hotel);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcular_dias_pacote` BEFORE INSERT ON `pacotes` FOR EACH ROW BEGIN
    SET NEW.dias_pacote = DATEDIFF(NEW.data_volta, NEW.data_ida) + 1;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `atualizar_preco_pacote_voos` BEFORE UPDATE ON `pacotes` FOR EACH ROW BEGIN
    DECLARE preco_voo_ida REAL;
    DECLARE preco_voo_volta REAL;
    DECLARE preco_diaria_hotel REAL;
    
    SELECT preco INTO preco_voo_ida FROM voos WHERE id = NEW.voo_ida_id;
    
    SELECT preco INTO preco_voo_volta FROM voos WHERE id = NEW.voo_volta_id;
    
    SELECT preco_diaria INTO preco_diaria_hotel FROM hoteis WHERE id = NEW.hotel_id;
    
    -- Calcular o novo preço do pacote
    SET NEW.preco = preco_voo_ida + preco_voo_volta + preco_diaria_hotel * ((DATEDIFF(NEW.data_volta, NEW.data_ida) + 1));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `atualizar_dias_pacote` BEFORE UPDATE ON `pacotes` FOR EACH ROW BEGIN
    -- Calcular dias do pacote
    SET NEW.dias_pacote = DATEDIFF(NEW.data_volta, NEW.data_ida) + 1;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-18 23:19:59
