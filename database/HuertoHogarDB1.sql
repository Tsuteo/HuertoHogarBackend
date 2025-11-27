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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(500) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` int NOT NULL,
  `stock` int NOT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Manzanas Fuji crujientes y dulces, cultivadas en el Valle del Maule. Perfectas para meriendas saludables.','/images/manzana.png','Manzana Fuji',1400,150,'Frutas Frescas'),(2,'Jugosas y ricas en vitamina C, estas naranjas Valencia son ideales para zumos frescos.','/images/naranja.png','Naranjas Valencia',1000,200,'Frutas Frescas'),(3,'Plátanos maduros y dulces, perfectos para el desayuno o como snack energético.','/images/banana.png','Plátanos Cavendish',800,250,'Frutas Frescas'),(4,'Tomates cherry frescos y jugosos, perfectos para ensaladas y aperitivos.','/images/tomate_cherry.png','Tomates Cherry',2500,50,'Frutas Frescas'),(5,'Peras frescas y jugosas, con un sabor dulce y una textura suave.','/images/peras.png','Peras',1300,220,'Frutas Frescas'),(6,'Zanahorias crujientes cultivadas sin pesticidas en la Región de O Higgins.','/images/zanahoria.png','Zanahorias Orgánicas',900,100,'Verduras Orgánicas'),(7,'Espinacas frescas y nutritivas, perfectas para ensaladas y batidos verdes.','/images/espinaca.png','Espinacas Frescas',700,80,'Verduras Orgánicas'),(8,'Pimientos rojos, amarillos y verdes, ideales para salteados y platos coloridos.','/images/pimenton.png','Pimientos',1500,120,'Verduras Orgánicas'),(9,'Pepinos frescos y crujientes, ideales para ensaladas o como snack ligero.','/images/pepinos.png','Pepinos',1400,320,'Verduras Orgánicas'),(10,'Lechugas frescas y crocantes, perfectas para ensaladas y sándwiches.','/images/lechugas.png','Lechuga',700,220,'Verduras Orgánicas'),(11,'Miel pura y orgánica producida por apicultores locales. Rica en antioxidantes.','/images/miel.png','Miel Orgánica',5000,50,'Productos Orgánicos'),(12,'Aceite de oliva de alta calidad, con un sabor suave y aroma natural.','/images/AceiteOliva.png','Aceite de Oliva',3000,200,'Productos Orgánicos'),(13,'Pan integral artesanal elaborado con harina 100% orgánica.','/images/pan.png','Pan Integral',2800,30,'Productos Orgánicos'),(14,'Quinoa orgánica, naturalmente libre de gluten y rica en proteínas.','/images/quinoa.png','Quinoa',2000,60,'Productos Orgánicos'),(15,'Té matcha premium 100% orgánico, molido a piedra.','/images/te_matcha.png','Té Matcha Orgánico',6500,75,'Productos Orgánicos'),(16,'Leche entera fresca y cremosa, con un sabor natural y delicioso.','/images/cajadeleche.jpg','Leche Entera',1000,100,'Productos Lácteos'),(17,'Mantequilla cremosa y de sabor suave, elaborada con leche de alta calidad.','/images/mantequilla.png','Mantequilla',800,150,'Productos Lácteos'),(18,'Queso sabroso y cremoso, rico en calcio y proteínas.','/images/queso_suizo.png','Queso Suizo',1500,200,'Productos Lácteos'),(19,'Yogurt natural cremoso y suave, con un sabor fresco y equilibrado.','/images/yogurt.png','Yogurt Natural',1000,100,'Productos Lácteos'),(20,'Quesillo fresco y firme, con textura porosa y sabor suave.','/images/quesillo.png','Quesillo',1000,100,'Productos Lácteos');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-27 18:19:11
