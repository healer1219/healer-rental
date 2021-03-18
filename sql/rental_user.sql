-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rental-user
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `pe_permission`
--

DROP TABLE IF EXISTS `pe_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_permission` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `code` varchar(20) DEFAULT NULL,
  `description` text COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_permission`
--

LOCK TABLES `pe_permission` WRITE;
/*!40000 ALTER TABLE `pe_permission` DISABLE KEYS */;
INSERT INTO `pe_permission` VALUES ('1','添加用户','user-add',NULL),('2','查询用户','user-find',NULL),('3','更新用户','user-update',NULL),('4','删除用户','user-delete',NULL);
/*!40000 ALTER TABLE `pe_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_role`
--

DROP TABLE IF EXISTS `pe_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_role` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `name` varchar(40) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k3beff7qglfn58qsf2yvbg41i` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_role`
--

LOCK TABLES `pe_role` WRITE;
/*!40000 ALTER TABLE `pe_role` DISABLE KEYS */;
INSERT INTO `pe_role` VALUES ('1','系统管理员','全部权限'),('2','实名用户','租车权限'),('3','未实名用户','有限权限');
/*!40000 ALTER TABLE `pe_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_role_permission`
--

DROP TABLE IF EXISTS `pe_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_role_permission` (
  `role_id` varchar(40) NOT NULL COMMENT '角色ID',
  `permission_id` varchar(40) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK74qx7rkbtq2wqms78gljv87a0` (`permission_id`),
  KEY `FKee9dk0vg99shvsytflym6egxd` (`role_id`),
  CONSTRAINT `fk-p-rid` FOREIGN KEY (`role_id`) REFERENCES `pe_role` (`id`),
  CONSTRAINT `fk-pid` FOREIGN KEY (`permission_id`) REFERENCES `pe_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_role_permission`
--

LOCK TABLES `pe_role_permission` WRITE;
/*!40000 ALTER TABLE `pe_role_permission` DISABLE KEYS */;
INSERT INTO `pe_role_permission` VALUES ('1','1'),('1','2'),('2','2'),('1','3'),('1','4');
/*!40000 ALTER TABLE `pe_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_user`
--

DROP TABLE IF EXISTS `pe_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_user` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `username` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_real_name` int NOT NULL DEFAULT '0' COMMENT '是否实名，1为是，0为否，默认0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_user`
--

LOCK TABLES `pe_user` WRITE;
/*!40000 ALTER TABLE `pe_user` DISABLE KEYS */;
INSERT INTO `pe_user` VALUES ('1','zhangsan','aab5beed7b7db7e1a82fcfd443d93737',NULL,'1234561',1),('1365984130029494272','healer11','c3427bf9893a75ee2dff0534aac7fde1',NULL,'1234562',0),('1365989075281686528','healer131','b1f391312a649001c7e152d51382139d','123@123.com','1234569',0),('1368201203510063104','new','e021a1e28c8ce227efa3917d5407bbe5','123@123','12345',0),('1368420826926981120','123','8eda1535b635e6b2c3672cc502249fe0','123','1234567',0),('2','lisi','16f807d62105b4896034552ee5caeb8a',NULL,'1234563',0),('3','wangwu','123456',NULL,'1234564',0),('4','healer','5863d83951bf823b822a2d05528601a8',NULL,'1234565',0);
/*!40000 ALTER TABLE `pe_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe_user_role`
--

DROP TABLE IF EXISTS `pe_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pe_user_role` (
  `role_id` varchar(40) NOT NULL COMMENT '角色ID',
  `user_id` varchar(40) NOT NULL COMMENT '权限ID',
  KEY `FK74qx7rkbtq2wqms78gljv87a1` (`role_id`),
  KEY `FKee9dk0vg99shvsytflym6egx1` (`user_id`),
  CONSTRAINT `fk-rid` FOREIGN KEY (`role_id`) REFERENCES `pe_role` (`id`),
  CONSTRAINT `fk-uid` FOREIGN KEY (`user_id`) REFERENCES `pe_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe_user_role`
--

LOCK TABLES `pe_user_role` WRITE;
/*!40000 ALTER TABLE `pe_user_role` DISABLE KEYS */;
INSERT INTO `pe_user_role` VALUES ('1','1');
/*!40000 ALTER TABLE `pe_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 14:40:58
