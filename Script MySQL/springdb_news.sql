-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 34.136.43.83    Database: springdb
-- ------------------------------------------------------
-- Server version	8.0.31-google

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'bcd08257-992c-11ee-a615-42010a400003:1-7518';

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `image_url` text NOT NULL,
  `title` varchar(255) NOT NULL,
  `video_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Expertos advierten sobre el aumento de sequías debido al cambio climático. Imágenes revelan caminos convertidos en desiertos. Un oso polar lucha por sobrevivir en un área deshielada, subrayando la urgencia de acciones para el medio ambiente.','https://pixabay.com/get/g0b6df9facd80a20d0f0e65dbc154e75d8bf0e30b131e604100b43a108fa9389d407a48be357f29751c3838311e658fa84aba8f4180a977f6489687b5c5fa65d6_1280.jpg','Cambio climático: Sequía extrema','https://vod-progressive.akamaized.net/exp=1702461966~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1893%2F11%2F284467858%2F1070546514.mp4~hmac=991d3747c8ab40ade4320ec164d71eccc9be5ce6b94447bfda488d9d33f7c687/vimeo-prod-skyfire-std-us/01/1893/11/284467858/1070546514.mp4?filename=file.mp4'),(2,'Un violento incidente conmociona un exclusivo barrio. Una periodista captura la escena donde la policía rodea una lujosa residencia tras un presunto asesinato. El video muestra la intensa actividad policial y la incertidumbre que rodea este caso.','https://images.pexels.com/photos/10464444/pexels-photo-10464444.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Asesinato en Barrio de Alta Sociedad','https://vod-progressive.akamaized.net/exp=1702461896~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1701%2F10%2F258508803%2F948501996.mp4~hmac=71354afffd6b532cf16fa41939b1938ac19fb90a07e0b8467b3d0f1f9079369a/vimeo-prod-skyfire-std-us/01/1701/10/258508803/948501996.mp4?filename=file.mp4'),(3,'En un acto heroico, bomberos rescatan a ciudadanos atrapados. Una periodista informa mientras los rescatistas trabajan intensamente. El video muestra el inicio de esta valiente operación de salvamento.','https://pixabay.com/get/g2f4ee8bada3039e83e1a444d3f70fc72cb8f98b0ff869e83747bef3fbc456256f6ffda8134b969fa0325cdea8b612866de9d174a5cad660a1efcc9d7794d77dd_1280.jpg','Rescate Heroico: Bomberos salvan vidas','https://vod-progressive.akamaized.net/exp=1702462058~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1757%2F7%2F183786939%2F604918297.mp4~hmac=f73821639ee9ec190b8081a829ce459a9215914c0b55c20c6595ef4118c22229/vimeo-prod-skyfire-std-us/01/1757/7/183786939/604918297.mp4?filename=file.mp4');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13  3:52:55
