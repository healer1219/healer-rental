-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: healer_rental
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
-- Table structure for table `brand_info`
--

DROP TABLE IF EXISTS `brand_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand_info` (
  `id` varchar(255) NOT NULL COMMENT '品牌id',
  `name` varchar(255) NOT NULL COMMENT '品牌名称\n',
  `img` varchar(255) NOT NULL COMMENT '品牌logo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_info`
--

LOCK TABLES `brand_info` WRITE;
/*!40000 ALTER TABLE `brand_info` DISABLE KEYS */;
INSERT INTO `brand_info` VALUES ('1364107085649448960','上汽大众','sqdz.png'),('1364478455709376512','广汽本田','gqbt.png'),('1364478766167564288','五菱汽车','wlqc.png');
/*!40000 ALTER TABLE `brand_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_desc`
--

DROP TABLE IF EXISTS `car_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_desc` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '具体信息id',
  `car_id` int NOT NULL COMMENT '车型id',
  `pid` int NOT NULL COMMENT '车辆类型id',
  `name` varchar(50) DEFAULT NULL COMMENT '车辆名称',
  `image` varchar(50) DEFAULT NULL COMMENT '车辆图片',
  `length` varchar(50) DEFAULT NULL COMMENT '轴距',
  `engine` varchar(50) DEFAULT NULL COMMENT '发动机名称',
  `engine_power` varchar(50) DEFAULT NULL COMMENT '马力',
  `drive_method` varchar(50) DEFAULT NULL COMMENT '驱动形式',
  `fuel` varchar(50) DEFAULT NULL COMMENT '燃料形式',
  `gearbox` varchar(50) DEFAULT NULL COMMENT '变速箱',
  `intro` varchar(255) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_desc`
--

LOCK TABLES `car_desc` WRITE;
/*!40000 ALTER TABLE `car_desc` DISABLE KEYS */;
INSERT INTO `car_desc` VALUES (1,1,1,'passat','passat.png','2871','ea888','220','前驱','燃油','自动','黑 色 高 级 轿 车'),(2,2,1,'桑塔纳','santana.png','2603','ea211','112','前驱','燃油','五速手动','白色高级小车'),(3,3,1,'雅阁','accord.png','2830','LFB11','146','前驱','油电混合','E-CVT无级变速','本田高级轿车');
/*!40000 ALTER TABLE `car_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_info`
--

DROP TABLE IF EXISTS `car_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '车型id',
  `pid` int NOT NULL COMMENT '车辆类型id\n',
  `brand_id` varchar(50) NOT NULL COMMENT '品牌id',
  `desc_id` int NOT NULL COMMENT '具体详情id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_info`
--

LOCK TABLES `car_info` WRITE;
/*!40000 ALTER TABLE `car_info` DISABLE KEYS */;
INSERT INTO `car_info` VALUES (1,1,'1364107085649448960',1,'passat','passat.png'),(2,1,'1364107085649448960',2,'桑塔纳','santana.png'),(3,1,'1364478455709376512',3,'雅阁','accord.png');
/*!40000 ALTER TABLE `car_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_parents`
--

DROP TABLE IF EXISTS `car_parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_parents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_parents`
--

LOCK TABLES `car_parents` WRITE;
/*!40000 ALTER TABLE `car_parents` DISABLE KEYS */;
INSERT INTO `car_parents` VALUES (1,'五座轿车'),(2,'五座旅行车'),(3,'七座MPV'),(4,'轻型载货车'),(5,'五座SUV');
/*!40000 ALTER TABLE `car_parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_desc`
--

DROP TABLE IF EXISTS `item_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_desc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `front_img` varchar(255) DEFAULT NULL,
  `front_desc` varchar(255) DEFAULT NULL,
  `front_left_img` varchar(255) DEFAULT NULL,
  `front_left_desc` varchar(255) DEFAULT NULL,
  `front_right_img` varchar(255) DEFAULT NULL,
  `front_right_desc` varchar(255) DEFAULT NULL,
  `back_img` varchar(255) DEFAULT NULL,
  `back_desc` varchar(255) DEFAULT NULL,
  `back_left_img` varchar(255) DEFAULT NULL,
  `back_left_desc` varchar(255) DEFAULT NULL,
  `back_right_img` varchar(255) DEFAULT NULL,
  `back_right_desc` varchar(255) DEFAULT NULL,
  `inside_img` varchar(255) DEFAULT NULL,
  `inside_desc` varchar(255) DEFAULT NULL,
  `inside_front_img` varchar(255) DEFAULT NULL,
  `inside_front_desc` varchar(255) DEFAULT NULL,
  `inside_back_img` varchar(255) DEFAULT NULL,
  `inside_back_desc` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_desc`
--

LOCK TABLES `item_desc` WRITE;
/*!40000 ALTER TABLE `item_desc` DISABLE KEYS */;
INSERT INTO `item_desc` VALUES (1,'f.jpg',NULL,'fl.jpg',NULL,'fr.jpg',NULL,'b.jpg',NULL,'bl.jpg',NULL,'br.jpg',NULL,'inside.jpg',NULL,'insidef.jpg',NULL,'insideb.jpg',NULL,'车况良好，无明显损伤');
/*!40000 ALTER TABLE `item_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_item`
--

DROP TABLE IF EXISTS `rental_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` varchar(255) NOT NULL COMMENT '车牌号',
  `car_id` int NOT NULL COMMENT '车辆详情id',
  `status` int NOT NULL DEFAULT '0' COMMENT '是否出租，0为否，1为是',
  `desc_id` int NOT NULL COMMENT '详情id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_item`
--

LOCK TABLES `rental_item` WRITE;
/*!40000 ALTER TABLE `rental_item` DISABLE KEYS */;
INSERT INTO `rental_item` VALUES (1,'京123456',1,1,1);
/*!40000 ALTER TABLE `rental_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_order`
--

DROP TABLE IF EXISTS `rental_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(100) DEFAULT NULL,
  `order_amount` decimal(10,0) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL COMMENT '租赁人',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '订单状态：0为未交付，1为已交付，2为已还车',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `item_id` int DEFAULT NULL COMMENT '租赁车辆id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_order`
--

LOCK TABLES `rental_order` WRITE;
/*!40000 ALTER TABLE `rental_order` DISABLE KEYS */;
INSERT INTO `rental_order` VALUES (1,'DD2021030416434589371',1200,'healer','tjeti','123456',2,'1','2021-03-04 08:43:46',NULL,1),(2,'DD2021030416434589371',1200,'healer','tjeti','123456',1,'1','2021-03-04 08:43:46','2021-03-04 12:02:50',1);
/*!40000 ALTER TABLE `rental_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-18 14:40:25
