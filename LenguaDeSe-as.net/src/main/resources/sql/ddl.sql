DROP DATABASE IF EXISTS `lengua_de_senias`;
CREATE DATABASE lengua_de_senias;
USE lengua_de_senias;

-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: lengua_senias
-- ------------------------------------------------------
-- Server version	8.0.22-0ubuntu0.20.04.3

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` text,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `nombre` text,
  `pais` int DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fcategorias`
--

DROP TABLE IF EXISTS `fcategorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fcategorias` (
  `id_fcategoria` tinyint NOT NULL AUTO_INCREMENT,
  `nombre` text,
  PRIMARY KEY (`id_fcategoria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `frases`
--

DROP TABLE IF EXISTS `frases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frases` (
  `id_frase` int NOT NULL AUTO_INCREMENT,
  `contenido` text,
  `fcategoria` int DEFAULT NULL,
  `gif` text,
  `lengua` int DEFAULT NULL,
  PRIMARY KEY (`id_frase`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idioma` (
  `id_idioma` int NOT NULL AUTO_INCREMENT,
  `abreviatura` char(2) DEFAULT NULL,
  `nombre` text,
  PRIMARY KEY (`id_idioma`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `idioma_paises`
--

DROP TABLE IF EXISTS `idioma_paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `idioma_paises` (
  `idioma_id_idioma` int NOT NULL,
  `paises_id_pais` tinyint NOT NULL,
  KEY `FKtobibrscw68tlgsovnwag8dmt` (`paises_id_pais`),
  KEY `FKdt1xgmf3ur5lsmr2w3m01mht8` (`idioma_id_idioma`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lenguapaises`
--

DROP TABLE IF EXISTS `lenguapaises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguapaises` (
  `lenguas_id` int NOT NULL,
  `paises_id` tinyint NOT NULL,
  KEY `FKmd1xwel3qb3jlspi43eqaok0k` (`paises_id`),
  KEY `FK5afg4tie2hb89dp74mngxsiet` (`lenguas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lenguas`
--

DROP TABLE IF EXISTS `lenguas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguas` (
  `id_lenguas` int NOT NULL AUTO_INCREMENT,
  `abreviatura` varchar(4) DEFAULT NULL,
  `nombre` text,
  PRIMARY KEY (`id_lenguas`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lenguas_paises`
--

DROP TABLE IF EXISTS `lenguas_paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lenguas_paises` (
  `lengua_id_lenguas` int NOT NULL,
  `paises_id_pais` tinyint NOT NULL,
  KEY `FK6u9f6kt4j2ljfsjk7amt24vrv` (`paises_id_pais`),
  KEY `FK56mlf4yksoxxwyi2nf1y45dr` (`lengua_id_lenguas`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `id_pais` tinyint NOT NULL AUTO_INCREMENT,
  `abreviatura` char(2) DEFAULT NULL,
  `pais` text,
  PRIMARY KEY (`id_pais`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `palabra`
--

DROP TABLE IF EXISTS `palabra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `palabra` (
  `id_palabra` int NOT NULL AUTO_INCREMENT,
  `contexto_senia` text,
  `definicion` text,
  `nombre` text,
  `categoria_id_categoria` int DEFAULT NULL,
  PRIMARY KEY (`id_palabra`),
  KEY `FKb51njtte1ojro89g7a8g1j1wu` (`categoria_id_categoria`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `palabra_senias`
--

DROP TABLE IF EXISTS `palabra_senias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `palabra_senias` (
  `palabra_id_palabra` int NOT NULL,
  `senias_id_senias` int NOT NULL,
  KEY `FKpkfjumtgoh47332123a51xmco` (`senias_id_senias`),
  KEY `FKtg2mlq54es81iyroxo8t2lkwn` (`palabra_id_palabra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `senia`
--

DROP TABLE IF EXISTS `senia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `senia` (
  `id_senias` int NOT NULL AUTO_INCREMENT,
  `gif` text,
  PRIMARY KEY (`id_senias`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre_tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `id_tipo_usuario` int DEFAULT NULL,
  `idioma` int DEFAULT NULL,
  `pais` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKr9xk0brid147iaydo8j47o9p2` (`id_tipo_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_frases_favoritas`
--

DROP TABLE IF EXISTS `usuario_frases_favoritas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_frases_favoritas` (
  `usuario_id_usuario` int NOT NULL,
  `frases_favoritas_id_frase` int NOT NULL,
  KEY `FKi5toi4tl702k1ng89s49qalod` (`frases_favoritas_id_frase`),
  KEY `FK5kigj8an9wi0je1kit2f66y87` (`usuario_id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_palabras_favoritas`
--

DROP TABLE IF EXISTS `usuario_palabras_favoritas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_palabras_favoritas` (
  `usuario_id_usuario` int NOT NULL,
  `palabras_favoritas_id_palabra` int NOT NULL,
  KEY `FKhp7qudwbrf3ex88d8xckpvspi` (`palabras_favoritas_id_palabra`),
  KEY `FK3arycyp82dif837lg8n2yeikm` (`usuario_id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-10 13:02:29

insert into tipo_usuario (descripcion, nombre_tipo_usuario) values 
	("Rol para superusuario", "ADMINISTRADOR"),
	("Rol para editor", "EDITOR"),
	("Rol para usuario", "USUARIO");
	
insert into paises (abreviatura, pais) values 
	("MX", "Mexico"), ("US", "Estados Unidos"), ("CA", "Canada"), ("FR", "Francia");

insert into estado (nombre, pais) values 
	("Guanajuato", 3), ("Queretaro", 3), ("Baja California", 3), ("Ciudad de México", 3), ("México", 3), ("Puebla", 3), 
	("New York", 4), ("Arizona", 4), ("California", 4), ("Florida", 4), ("Texas", 4), ("Virginia", 4),
	("Ontario", 5), ("Quebec", 5), ("Manitoba", 5), ("Yukón", 5), ("Alberta", 5),
	("Gran Este", 6), ("Nueva Aquitania", 6), ("Bretaña", 6), ("Isla de Francia", 6), ("Occitania", 6);

insert into usuario (email, estado, pais, id_tipo_usuario, idioma, password) values 
	('admin@mail.com', 1, 1, 4, 1, '$2a$10$QRPYAo0t/YTvh.lQpuNeYOehVzWd1E4znI5bvtyas/my5Zm3agcey'),
	('editor@mail.com', 1, 1, 5, 1, '$2a$10$QRPYAo0t/YTvh.lQpuNeYOehVzWd1E4znI5bvtyas/my5Zm3agcey'),
	('user@mail.com', 1, 1, 6, 1, '$2a$10$QRPYAo0t/YTvh.lQpuNeYOehVzWd1E4znI5bvtyas/my5Zm3agcey');

insert into idioma (abreviatura, nombre) values 
	("ES"," Español"),("EN", "Ingles"), ("FR", "Frances");

insert into categoria (nombre) values ("Saludos"),("Presentaciones"),("Hogar"),("Trabajo"),( "Turismo"),("Direcciones"),( "Preposiciones");

insert into fcategorias (nombre) values ("Saludos"),("Presentaciones"),("Hogar"),("Trabajo"),( "Turismo"),("Direcciones"),( "Preposiciones");

insert into lenguas (abreviatura, nombre) values 
	("LSA","Lengua de señas argentina"),("LSM","Lengua de señas mexicana"),("LSPE","Lengua de señas peruana"),("LSV","Lengua de señas venezolana "),("LSCh","Lengua de señas chilena");

