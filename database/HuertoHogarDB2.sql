CREATE DATABASE  IF NOT EXISTS `huerto_hogar_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `huerto_hogar_db`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: huerto_hogar_db
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `detalles_orden`
--

DROP TABLE IF EXISTS `detalles_orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_orden` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `precio_unitario` int DEFAULT NULL,
  `orden_id` bigint NOT NULL,
  `producto_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKinrb8eucxquhr3h2u4tnv27x3` (`orden_id`),
  KEY `FKcy6o2x5ohcglmi8ogldms60je` (`producto_id`),
  CONSTRAINT `FKcy6o2x5ohcglmi8ogldms60je` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`),
  CONSTRAINT `FKinrb8eucxquhr3h2u4tnv27x3` FOREIGN KEY (`orden_id`) REFERENCES `ordenes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_orden`
--

LOCK TABLES `detalles_orden` WRITE;
/*!40000 ALTER TABLE `detalles_orden` DISABLE KEYS */;
INSERT INTO `detalles_orden` VALUES (1,1,1000,1,'FR002'),(2,1,1200,2,'FR001'),(3,1,1200,3,'FR001'),(4,1,800,4,'FR003'),(5,1,1000,5,'FR002'),(6,1,800,5,'FR003'),(7,1,1500,6,'PL003'),(8,1,1000,7,'PL001');
/*!40000 ALTER TABLE `detalles_orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_boleta` varchar(255) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `total` int DEFAULT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4k1lbla7wehl15atrqtqpni1c` (`codigo_boleta`),
  KEY `FKsqu43gsd6mtx7b1siww96324` (`usuario_id`),
  CONSTRAINT `FKsqu43gsd6mtx7b1siww96324` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (1,'BOL-46881753','2025-11-29 04:16:38.932917',1000,1),(2,'BOL-80672D65','2025-11-29 04:18:30.509419',1200,1),(3,'BOL-CD4333B6','2025-11-29 04:20:01.968867',1200,1),(4,'BOL-2AC82D0C','2025-11-29 04:37:04.760256',800,1),(5,'BOL-A5DD1DFE','2025-11-29 04:51:08.398773',1800,1),(6,'BOL-20AC089D','2025-11-29 05:26:35.131326',1500,4),(7,'BOL-628CDD70','2025-11-29 05:29:31.808629',1000,4);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `precio` int NOT NULL,
  `stock` int NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('FR001','Manzana Fuji','Manzanas Fuji crujientes y dulces.',1200,148,'/images/manzana.png','Frutas Frescas'),('FR002','Naranjas Valencia','Jugosas y ricas en vitamina C.',1000,198,'/images/naranja.png','Frutas Frescas'),('FR003','Plátanos Cavendish','Plátanos maduros y dulces.',800,248,'/images/banana.png','Frutas Frescas'),('FR004','Tomates Cherry','Tomates cherry frescos y jugosos.',2500,50,'/images/tomate_cherry.png','Frutas Frescas'),('FR005','Peras','Peras frescas y jugosas.',1300,220,'/images/peras.png','Frutas Frescas'),('PL001','Leche Entera','Leche entera fresca y cremosa.',1000,99,'/images/cajadeleche.jpg','Productos Lácteos'),('PL002','Mantequilla','Mantequilla cremosa y de sabor suave.',800,150,'/images/mantequilla.png','Productos Lácteos'),('PL003','Queso Suizo','Queso sabroso y cremoso.',1500,199,'/images/queso_suizo.png','Productos Lácteos'),('PL004','Yogurt Natural','Yogurt natural cremoso.',1000,100,'/images/yogurt.png','Productos Lácteos'),('PL005','Quesillo','Quesillo fresco y firme.',1000,100,'/images/quesillo.png','Productos Lácteos'),('PO001','Miel Orgánica','Miel pura y orgánica.',5000,50,'/images/miel.png','Productos Orgánicos'),('PO002','Aceite de Oliva','Aceite de oliva de alta calidad.',3000,200,'/images/AceiteOliva.png','Productos Orgánicos'),('PO003','Pan Integral','Pan integral artesanal.',2800,30,'/images/pan.png','Productos Orgánicos'),('PO004','Quinoa','Quinoa orgánica libre de gluten.',2000,60,'/images/quinoa.png','Productos Orgánicos'),('PO005','Té Matcha Orgánico','Té matcha premium 100% orgánico.',6500,75,'/images/te_matcha.png','Productos Orgánicos'),('VR001','Zanahorias Orgánicas','Zanahorias crujientes sin pesticidas.',900,100,'/images/zanahoria.png','Verduras Orgánicas'),('VR002','Espinacas Frescas','Espinacas frescas y nutritivas.',700,80,'/images/espinaca.png','Verduras Orgánicas'),('VR003','Pimientos','Pimientos rojos, amarillos y verdes.',1500,120,'/images/pimenton.png','Verduras Orgánicas'),('VR004','Pepinos','Pepinos frescos y crujientes.',1400,320,'/images/pepinos.png','Verduras Orgánicas'),('VR005','Lechuga','Lechugas frescas y crocantes.',700,220,'/images/lechugas.png','Verduras Orgánicas');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'juan@example.com','Juan Pérez','123456','CLIENTE'),(4,'mateo.lol@gmail.com','Mateo Lara','123456','CLIENTE');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-29  2:38:40
