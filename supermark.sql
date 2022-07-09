CREATE DATABASE  IF NOT EXISTS `Supermark` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Supermark`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: Supermark
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `Carrito`
--

DROP TABLE IF EXISTS `Carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Carrito` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `producto_carrito_fk` (`id_producto`),
  KEY `usuario_carrito_fk` (`id_usuario`),
  CONSTRAINT `producto_carrito_fk` FOREIGN KEY (`id_producto`) REFERENCES `Producto` (`id`),
  CONSTRAINT `usuario_carrito_fk` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Carrito`
--

LOCK TABLES `Carrito` WRITE;
/*!40000 ALTER TABLE `Carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `Carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comprobante`
--

DROP TABLE IF EXISTS `Comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comprobante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(1) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `id_tc` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_comprobante_fk` (`id_usuario`),
  KEY `tc_comprobante_fk` (`id_tc`),
  CONSTRAINT `tc_comprobante_fk` FOREIGN KEY (`id_tc`) REFERENCES `TarjetaCredito` (`numero`),
  CONSTRAINT `usuario_comprobante_fk` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comprobante`
--

LOCK TABLES `Comprobante` WRITE;
/*!40000 ALTER TABLE `Comprobante` DISABLE KEYS */;
INSERT INTO `Comprobante` VALUES (3,'C','2022-07-06 05:50:00',1,123456),(4,'C','2022-07-06 05:52:28',1,123456);
/*!40000 ALTER TABLE `Comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Descuento`
--

DROP TABLE IF EXISTS `Descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Descuento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `porcentaje` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Descuento`
--

LOCK TABLES `Descuento` WRITE;
/*!40000 ALTER TABLE `Descuento` DISABLE KEYS */;
INSERT INTO `Descuento` VALUES (1,0),(2,5);
/*!40000 ALTER TABLE `Descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalle`
--

DROP TABLE IF EXISTS `Detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Detalle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_comprobante` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comprobante_fk` (`id_comprobante`),
  KEY `producto_fk` (`id_producto`),
  CONSTRAINT `comprobante_fk` FOREIGN KEY (`id_comprobante`) REFERENCES `Comprobante` (`id`),
  CONSTRAINT `producto_fk` FOREIGN KEY (`id_producto`) REFERENCES `Producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalle`
--

LOCK TABLES `Detalle` WRITE;
/*!40000 ALTER TABLE `Detalle` DISABLE KEYS */;
INSERT INTO `Detalle` VALUES (1,3,2,1),(2,3,1,3),(3,4,1,3),(4,4,2,1);
/*!40000 ALTER TABLE `Detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Domicilio`
--

DROP TABLE IF EXISTS `Domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Domicilio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calle1` varchar(30) DEFAULT NULL,
  `calle2` varchar(30) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `ruta` varchar(30) DEFAULT NULL,
  `km` int DEFAULT NULL,
  `depNumero` int DEFAULT NULL,
  `piso` int DEFAULT NULL,
  `id_localidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `localidad_fk` (`id_localidad`),
  CONSTRAINT `localidad_fk` FOREIGN KEY (`id_localidad`) REFERENCES `Localidad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Domicilio`
--

LOCK TABLES `Domicilio` WRITE;
/*!40000 ALTER TABLE `Domicilio` DISABLE KEYS */;
INSERT INTO `Domicilio` VALUES (2,'Balcarce',NULL,1235,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `Domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Localidad`
--

DROP TABLE IF EXISTS `Localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Localidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `provincia` varchar(20) DEFAULT NULL,
  `departamento` varchar(20) DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Localidad`
--

LOCK TABLES `Localidad` WRITE;
/*!40000 ALTER TABLE `Localidad` DISABLE KEYS */;
INSERT INTO `Localidad` VALUES (1,'Salta','Capital','Salta');
/*!40000 ALTER TABLE `Localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `fecha_venc` date DEFAULT NULL,
  `precio` float NOT NULL,
  `stock` int DEFAULT NULL,
  `id_tipo` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_fk` (`id_tipo`),
  CONSTRAINT `tipo_fk` FOREIGN KEY (`id_tipo`) REFERENCES `Tipo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,'Leche','Ilolay','2022-10-10',210,97,1),(2,'Manteca','Danica','2022-12-20',240,99,1);
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TarjetaCredito`
--

DROP TABLE IF EXISTS `TarjetaCredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TarjetaCredito` (
  `numero` bigint unsigned NOT NULL,
  `banco` varchar(20) DEFAULT NULL,
  `titular` varchar(60) DEFAULT NULL,
  `fecha_caducidad` date DEFAULT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `usuario_tc_fk` (`id_usuario`),
  CONSTRAINT `usuario_tc_fk` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TarjetaCredito`
--

LOCK TABLES `TarjetaCredito` WRITE;
/*!40000 ALTER TABLE `TarjetaCredito` DISABLE KEYS */;
INSERT INTO `TarjetaCredito` VALUES (123456,'Patagonia','Luis Augusto Parada','2028-12-01',1);
/*!40000 ALTER TABLE `TarjetaCredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tipo`
--

DROP TABLE IF EXISTS `Tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(128) DEFAULT NULL,
  `id_descuento` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `descuento_fk` (`id_descuento`),
  CONSTRAINT `descuento_fk` FOREIGN KEY (`id_descuento`) REFERENCES `Descuento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tipo`
--

LOCK TABLES `Tipo` WRITE;
/*!40000 ALTER TABLE `Tipo` DISABLE KEYS */;
INSERT INTO `Tipo` VALUES (1,'Lacteos',2);
/*!40000 ALTER TABLE `Tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `dni` int unsigned NOT NULL,
  `contrasenia` varchar(16) DEFAULT NULL,
  `id_domicilio` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `domicilio_fk` (`id_domicilio`),
  CONSTRAINT `domicilio_fk` FOREIGN KEY (`id_domicilio`) REFERENCES `Domicilio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'Luis','Parada','lap18958@gmail.com',41000199,'luis0199',2);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-09 18:44:22
