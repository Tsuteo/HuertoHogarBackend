CREATE DATABASE  IF NOT EXISTS `huerto_hogar_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `huerto_hogar_db`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 3.16.215.211    Database: huerto_hogar_db
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
-- Table structure for table `blogs`
--

DROP TABLE IF EXISTS `blogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blogs` (
  `id` varchar(20) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `contenido` varchar(5000) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blogs`
--

LOCK TABLES `blogs` WRITE;
/*!40000 ALTER TABLE `blogs` DISABLE KEYS */;
INSERT INTO `blogs` VALUES ('BLG001','Ana Martínez','<p class=\\\"lead\\\">Comenzar un huerto en casa puede parecer complicado, pero con las verduras correctas, el éxito está garantizado. Prioriza aquellas que tienen ciclos de crecimiento rápidos y no requieren mucho espacio.</p><h3 class=\\\"mt-4\\\">1. Rábanos</h3><p>Son ideales para principiantes. Crecen rápidamente, tardando solo unas 3-4 semanas desde la siembra hasta la cosecha. Necesitan poca profundidad de tierra.</p><h3 class=\\\"mt-4\\\">2. Espinacas</h3><p>Se adaptan bien a la sombra parcial, perfectas para balcones. Puedes cosechar las hojas externas constantemente sin matar la planta.</p><h3 class=\\\"mt-4\\\">3. Lechugas (Variedades de hoja)</h3><p>Similar a las espinacas, las variedades de hojas sueltas te permiten cortar lo que necesitas sin esperar a que la cabeza madure completamente.</p><h3 class=\\\"mt-4\\\">4. Zanahorias Baby</h3><p>Si bien las zanahorias grandes necesitan profundidad, las variedades \\\'baby\\\' son felices en macetas más pequeñas.</p><h3 class=\\\"mt-4\\\">5. Hierbas Aromáticas</h3><p>Albahaca, menta, y orégano no solo son fáciles, sino que mejoran el sabor de cualquier comida. Son resistentes y crecen bien en alféizares.','2025-10-01','/images/huerto_casero.jpg','Las 5 Mejores Verduras para tu Huerto Casero'),('BLG002','Javier Soto','<p class=\"lead\">La miel orgánica no es solo un endulzante, es un superalimento cuyo proceso de recolección respeta la salud de las abejas y el entorno. Su certificación garantiza que no se usaron pesticidas en un radio de acción de las colmenas.</p><h3 class=\"mt-4\">¿Por qué es mejor?</h3><p>Contiene más antioxidantes y nutrientes esenciales que la miel común, ya que no pasa por procesos de pasteurización extrema que eliminan sus propiedades.</p><h3 class=\"mt-4\">Cómo Usarla</h3><p>Ideal para endulzar infusiones (esperando a que se enfríen ligeramente para no dañar sus enzimas), aderezos y mascarillas naturales.</p>','2025-09-15','/images/miel_organica.jpg','Guía Rápida: Los Secretos de la Miel Orgánica'),('BLG003','Sofía Reyes','<p class=\"lead\">El invierno requiere un refuerzo de vitamina C. Afortunadamente, muchas variedades de naranjas, limones y pomelos alcanzan su punto máximo de madurez y dulzura justo en esta época.</p><h3 class=\"mt-4\">El Poder del Limón</h3><p>Unas pocas gotas de limón en agua tibia por la mañana pueden ayudar a alcalinizar tu cuerpo y mejorar la digestión.</p><h3 class=\"mt-4\">Naranjas y Mandarinas</h3><p>Son el snack perfecto. Sus aceites esenciales también ayudan a levantar el ánimo y combatir la fatiga estacional.</p>','2025-08-20','/images/citricos.jpg','Cítricos en Invierno: La Dosis de Vitamina C que Necesitas');
/*!40000 ALTER TABLE `blogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES ('FR','Frutas Frescas','Nuestra selección de frutas frescas ofrece una experiencia directa del campo a tu hogar.',NULL),('PL','Productos Lácteos','Los productos lácteos de HuertoHogar provienen de granjas locales.',NULL),('PO','Productos Orgánicos','Nuestros productos orgánicos están elaborados con ingredientes naturales.',NULL),('VR','Verduras Orgánicas','Descubre nuestra gama de verduras orgánicas, cultivadas sin el uso de pesticidas.',NULL);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `asunto` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `mensaje` varchar(1000) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Prueba1','mateo.lol@gmail.com','REVISADO','2025-11-30 15:42:25.126233','Hola gente','Mateo','+56 9 9999999'),(2,'Testeo','Test@AWS.cl','REVISADO','2025-12-01 02:13:00.913938','Hola chicos','TesteoAWS','+56 9 9999999'),(3,'Testeo2','Test@AWS.cl','REVISADO','2025-12-01 03:37:50.152681','Probando probando','TesteoAWS','+56 9 9999999'),(4,'Testeo','mateo.lol@gmail.com','REVISADO','2025-12-01 12:31:49.694100','test','TesteoAWS','+56 9 9999999'),(5,'prueba4','mateo.lol@gmail.com','REVISADO','2025-12-01 13:12:48.453811','hola','Mateo Lara','+56 9 9999999'),(6,'Ayuda','manuel.e@gmail.com','REVISADO','2025-12-15 19:14:47.519034','ooo','Manuel','+56 9 9999999');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_orden`
--

LOCK TABLES `detalles_orden` WRITE;
/*!40000 ALTER TABLE `detalles_orden` DISABLE KEYS */;
INSERT INTO `detalles_orden` VALUES (27,1,1400,17,'FR001');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES (17,'BOL-63954410','2025-12-15 19:12:15.817516',1400,15);
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
INSERT INTO `productos` VALUES ('FR001','Manzana Fuji','Manzanas Fuji crujientes y dulces.',1400,98,'/images/manzana.png','Frutas Frescas'),('FR002','Naranjas Valencia','Jugosas y ricas en vitamina C.',1000,194,'/images/naranja.png','Frutas Frescas'),('FR003','Plátanos Cavendish','Plátanos maduros y dulces.',800,225,'/images/banana.png','Frutas Frescas'),('FR004','Tomates Cherry','Tomates cherry frescos y jugosos.',2500,45,'/images/tomate_cherry.png','Frutas Frescas'),('FR005','Peras','Peras frescas y jugosas.',1300,219,'/images/peras.png','Frutas Frescas'),('PL001','Leche Entera','Leche entera fresca y cremosa.',1000,98,'/images/cajadeleche.jpg','Productos Lácteos'),('PL002','Mantequilla','Mantequilla cremosa y de sabor suave.',800,0,'/images/mantequilla.png','Productos Lácteos'),('PL003','Queso Suizo','Queso sabroso y cremoso.',1500,198,'/images/queso_suizo.png','Productos Lácteos'),('PL004','Yogurt Natural','Yogurt natural cremoso.',1000,99,'/images/yogurt.png','Productos Lácteos'),('PL005','Quesillo','Quesillo fresco y firme.',1000,100,'/images/quesillo.png','Productos Lácteos'),('PO001','Miel Orgánica','Miel pura y orgánica.',5000,50,'/images/miel.png','Productos Orgánicos'),('PO002','Aceite de Oliva','Aceite de oliva de alta calidad.',3000,200,'/images/AceiteOliva.png','Productos Orgánicos'),('PO003','Pan Integral','Pan integral artesanal.',2800,30,'/images/pan.png','Productos Orgánicos'),('PO004','Quinoa','Quinoa orgánica libre de gluten.',2000,60,'/images/quinoa.png','Productos Orgánicos'),('PO005','Té Matcha Orgánico','Té matcha premium 100% orgánico.',6500,75,'/images/te_matcha.png','Productos Orgánicos'),('VR001','Zanahorias Orgánicas','Zanahorias crujientes sin pesticidas.',900,100,'/images/zanahoria.png','Verduras Orgánicas'),('VR002','Espinacas Frescas','Espinacas frescas y nutritivas.',700,80,'/images/espinaca.png','Verduras Orgánicas'),('VR003','Pimientos','Pimientos rojos, amarillos y verdes.',1500,120,'/images/pimenton.png','Verduras Orgánicas'),('VR004','Pepinos','Pepinos frescos y crujientes.',1400,320,'/images/pepinos.png','Verduras Orgánicas'),('VR005','Lechuga','Lechugas frescas y crocantes.',700,220,'/images/lechugas.png','Verduras Orgánicas');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (13,'mateo.lol@gmail.com','Mateo','$2a$10$N.zmdr9k7uOCQP3kk.9fguIt.XokX3.q.s.j.t.g.w.r.t.y','ROLE_USER'),(14,'admin@huerto.cl','Administrador','$2a$10$ekeZyICiDcBg7lK/ntiFuOqkQyNIGJLQHaGRsP2TYRYjmA7kVHVWK','ROLE_ADMIN'),(15,'manuel.e@gmail.com','Manuel','$2a$10$Ogg5SA2Hng6G0CLka.EJa.xz7AOczIcLasPBiprx5/FecXWDidc1G','CLIENTE');
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

-- Dump completed on 2025-12-15 16:22:16
