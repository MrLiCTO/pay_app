-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: third_pay
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('lll1','ddd','男',19),('uuu1','可以_like','女',10);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_authority`
--

DROP TABLE IF EXISTS `security_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_authority` (
  `id` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `module_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn635m2ugdfin7f7kjjsys3qrc` (`module_id`),
  CONSTRAINT `FKn635m2ugdfin7f7kjjsys3qrc` FOREIGN KEY (`module_id`) REFERENCES `sys_moudle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_authority`
--

LOCK TABLES `security_authority` WRITE;
/*!40000 ALTER TABLE `security_authority` DISABLE KEYS */;
INSERT INTO `security_authority` VALUES ('0f569eccbdb54caa9a1ea5ecb039a651','','authority1','world1','b01aeb6022d04edbb14157d05e8a7292'),('2d30a077e1ce4355aba406d13bff82b7','','authority8','world8','b01aeb6022d04edbb14157d05e8a7292'),('2e476d12fc284d46830bef4d94f0704d','','authority2','world2','b01aeb6022d04edbb14157d05e8a7292'),('3ce7a784200d4bc8976697bd98837939','','authority17','world17','b01aeb6022d04edbb14157d05e8a7292'),('3f2a6d6fcb104eb98fbcb4cf2eebeae7','','authority9','world9','b01aeb6022d04edbb14157d05e8a7292'),('4af5013acdb04ec08c60fe8671edb520','','authority0','world0','b01aeb6022d04edbb14157d05e8a7292'),('75138c968f0a4be1adfa06fcd0896773','','authority16','world16','b01aeb6022d04edbb14157d05e8a7292'),('79c76ca5a3f54699bab1915fce884be7','','authority14','world14','b01aeb6022d04edbb14157d05e8a7292'),('7d4a3669061a4991a92547fabec4b3ca','','authority19','world19','b01aeb6022d04edbb14157d05e8a7292'),('877d68157319446aa8b6e15535ed3868','','authority13','world13','b01aeb6022d04edbb14157d05e8a7292'),('935e7e2d052e4889812ce824175fed84','','authority18','world18','b01aeb6022d04edbb14157d05e8a7292'),('9dc1222fe08d43338b0afbc412f37e2d','','authority4','world4','b01aeb6022d04edbb14157d05e8a7292'),('a56b7c40487c419f9fe6a301f3a5c63e','','authority3','world3','b01aeb6022d04edbb14157d05e8a7292'),('aedeebba2d644ac4b301973853b205ea','','authority10','world10','b01aeb6022d04edbb14157d05e8a7292'),('b23f7ef7ea9c491eb9a916fea5ec877a','','authority5','world5','b01aeb6022d04edbb14157d05e8a7292'),('b248ab4f8a6b4175a1e6e6212f10ef23','','authority15','world15','b01aeb6022d04edbb14157d05e8a7292'),('c0977140ecd14d2fba9c852881e6979a','','authority6','world6','b01aeb6022d04edbb14157d05e8a7292'),('cff6be1b08a44ba2a208551cd4fed964','','authority12','world12','b01aeb6022d04edbb14157d05e8a7292'),('d1578b33edf44158ba0f55e22294950f','','authority11','world11','b01aeb6022d04edbb14157d05e8a7292'),('eaf520d09ba84dccba10f44031c1ca5c','','authority7','world7','b01aeb6022d04edbb14157d05e8a7292');
/*!40000 ALTER TABLE `security_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_role`
--

DROP TABLE IF EXISTS `security_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_role` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_role`
--

LOCK TABLES `security_role` WRITE;
/*!40000 ALTER TABLE `security_role` DISABLE KEYS */;
INSERT INTO `security_role` VALUES ('1e22dd1a6f604244b08221551ffdff96','0006','','role6'),('2f1663eeedde4efeb9c211c05ef98cca','0001','','role1'),('41f227e1c1374126bf75a23f5d50e740','0003','','role3'),('610671132e3b464eb0a79ad2b98b5ea3','0007','','role7'),('7d9fcb0e28f0442792fe04f2540fcfe9','0008','','role8'),('aec4fd7b198a44c08511e06e639a7143','0009','','role9'),('bff6b3fd46e141c89e89493a1b2f783f','0005','','role5'),('ccadafb86188477faa119952fd5117a7','0002','','role2'),('d0b6135d63fe4079a6bef34f138f1327','0004','','role4'),('fd2af3f51f1a41e7b10c8b65118bbcad','0000','','role0');
/*!40000 ALTER TABLE `security_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_user`
--

DROP TABLE IF EXISTS `security_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_user` (
  `id` varchar(255) NOT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_user`
--

LOCK TABLES `security_user` WRITE;
/*!40000 ALTER TABLE `security_user` DISABLE KEYS */;
INSERT INTO `security_user` VALUES ('a7fa0671c1244c159b62bdb360db3534','','','','','testWorld','testHello');
/*!40000 ALTER TABLE `security_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_moudle`
--

DROP TABLE IF EXISTS `sys_moudle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_moudle` (
  `id` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2nipqn6gphaw64v2moec0qstu` (`parent_id`),
  CONSTRAINT `FK2nipqn6gphaw64v2moec0qstu` FOREIGN KEY (`parent_id`) REFERENCES `sys_moudle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_moudle`
--

LOCK TABLES `sys_moudle` WRITE;
/*!40000 ALTER TABLE `sys_moudle` DISABLE KEYS */;
INSERT INTO `sys_moudle` VALUES ('b01aeb6022d04edbb14157d05e8a7292','','model',NULL);
/*!40000 ALTER TABLE `sys_moudle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_authority`
--

DROP TABLE IF EXISTS `t_role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_authority` (
  `role_id` varchar(255) NOT NULL,
  `authority_id` varchar(255) NOT NULL,
  KEY `FKpf2uv4w2mnof2aj36hnoau3af` (`authority_id`),
  KEY `FKf000830meceg4pn4l5e91lqat` (`role_id`),
  CONSTRAINT `FKf000830meceg4pn4l5e91lqat` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`),
  CONSTRAINT `FKpf2uv4w2mnof2aj36hnoau3af` FOREIGN KEY (`authority_id`) REFERENCES `security_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_authority`
--

LOCK TABLES `t_role_authority` WRITE;
/*!40000 ALTER TABLE `t_role_authority` DISABLE KEYS */;
INSERT INTO `t_role_authority` VALUES ('fd2af3f51f1a41e7b10c8b65118bbcad','4af5013acdb04ec08c60fe8671edb520'),('fd2af3f51f1a41e7b10c8b65118bbcad','0f569eccbdb54caa9a1ea5ecb039a651'),('fd2af3f51f1a41e7b10c8b65118bbcad','2e476d12fc284d46830bef4d94f0704d'),('fd2af3f51f1a41e7b10c8b65118bbcad','a56b7c40487c419f9fe6a301f3a5c63e'),('fd2af3f51f1a41e7b10c8b65118bbcad','9dc1222fe08d43338b0afbc412f37e2d'),('fd2af3f51f1a41e7b10c8b65118bbcad','b23f7ef7ea9c491eb9a916fea5ec877a'),('fd2af3f51f1a41e7b10c8b65118bbcad','c0977140ecd14d2fba9c852881e6979a'),('fd2af3f51f1a41e7b10c8b65118bbcad','eaf520d09ba84dccba10f44031c1ca5c'),('fd2af3f51f1a41e7b10c8b65118bbcad','2d30a077e1ce4355aba406d13bff82b7'),('fd2af3f51f1a41e7b10c8b65118bbcad','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('fd2af3f51f1a41e7b10c8b65118bbcad','aedeebba2d644ac4b301973853b205ea'),('fd2af3f51f1a41e7b10c8b65118bbcad','d1578b33edf44158ba0f55e22294950f'),('fd2af3f51f1a41e7b10c8b65118bbcad','cff6be1b08a44ba2a208551cd4fed964'),('fd2af3f51f1a41e7b10c8b65118bbcad','877d68157319446aa8b6e15535ed3868'),('fd2af3f51f1a41e7b10c8b65118bbcad','79c76ca5a3f54699bab1915fce884be7'),('fd2af3f51f1a41e7b10c8b65118bbcad','b248ab4f8a6b4175a1e6e6212f10ef23'),('fd2af3f51f1a41e7b10c8b65118bbcad','75138c968f0a4be1adfa06fcd0896773'),('fd2af3f51f1a41e7b10c8b65118bbcad','3ce7a784200d4bc8976697bd98837939'),('fd2af3f51f1a41e7b10c8b65118bbcad','935e7e2d052e4889812ce824175fed84'),('fd2af3f51f1a41e7b10c8b65118bbcad','7d4a3669061a4991a92547fabec4b3ca'),('2f1663eeedde4efeb9c211c05ef98cca','4af5013acdb04ec08c60fe8671edb520'),('2f1663eeedde4efeb9c211c05ef98cca','0f569eccbdb54caa9a1ea5ecb039a651'),('2f1663eeedde4efeb9c211c05ef98cca','2e476d12fc284d46830bef4d94f0704d'),('2f1663eeedde4efeb9c211c05ef98cca','a56b7c40487c419f9fe6a301f3a5c63e'),('2f1663eeedde4efeb9c211c05ef98cca','9dc1222fe08d43338b0afbc412f37e2d'),('2f1663eeedde4efeb9c211c05ef98cca','b23f7ef7ea9c491eb9a916fea5ec877a'),('2f1663eeedde4efeb9c211c05ef98cca','c0977140ecd14d2fba9c852881e6979a'),('2f1663eeedde4efeb9c211c05ef98cca','eaf520d09ba84dccba10f44031c1ca5c'),('2f1663eeedde4efeb9c211c05ef98cca','2d30a077e1ce4355aba406d13bff82b7'),('2f1663eeedde4efeb9c211c05ef98cca','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('2f1663eeedde4efeb9c211c05ef98cca','aedeebba2d644ac4b301973853b205ea'),('2f1663eeedde4efeb9c211c05ef98cca','d1578b33edf44158ba0f55e22294950f'),('2f1663eeedde4efeb9c211c05ef98cca','cff6be1b08a44ba2a208551cd4fed964'),('2f1663eeedde4efeb9c211c05ef98cca','877d68157319446aa8b6e15535ed3868'),('2f1663eeedde4efeb9c211c05ef98cca','79c76ca5a3f54699bab1915fce884be7'),('2f1663eeedde4efeb9c211c05ef98cca','b248ab4f8a6b4175a1e6e6212f10ef23'),('2f1663eeedde4efeb9c211c05ef98cca','75138c968f0a4be1adfa06fcd0896773'),('2f1663eeedde4efeb9c211c05ef98cca','3ce7a784200d4bc8976697bd98837939'),('2f1663eeedde4efeb9c211c05ef98cca','935e7e2d052e4889812ce824175fed84'),('2f1663eeedde4efeb9c211c05ef98cca','7d4a3669061a4991a92547fabec4b3ca'),('ccadafb86188477faa119952fd5117a7','4af5013acdb04ec08c60fe8671edb520'),('ccadafb86188477faa119952fd5117a7','0f569eccbdb54caa9a1ea5ecb039a651'),('ccadafb86188477faa119952fd5117a7','2e476d12fc284d46830bef4d94f0704d'),('ccadafb86188477faa119952fd5117a7','a56b7c40487c419f9fe6a301f3a5c63e'),('ccadafb86188477faa119952fd5117a7','9dc1222fe08d43338b0afbc412f37e2d'),('ccadafb86188477faa119952fd5117a7','b23f7ef7ea9c491eb9a916fea5ec877a'),('ccadafb86188477faa119952fd5117a7','c0977140ecd14d2fba9c852881e6979a'),('ccadafb86188477faa119952fd5117a7','eaf520d09ba84dccba10f44031c1ca5c'),('ccadafb86188477faa119952fd5117a7','2d30a077e1ce4355aba406d13bff82b7'),('ccadafb86188477faa119952fd5117a7','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('ccadafb86188477faa119952fd5117a7','aedeebba2d644ac4b301973853b205ea'),('ccadafb86188477faa119952fd5117a7','d1578b33edf44158ba0f55e22294950f'),('ccadafb86188477faa119952fd5117a7','cff6be1b08a44ba2a208551cd4fed964'),('ccadafb86188477faa119952fd5117a7','877d68157319446aa8b6e15535ed3868'),('ccadafb86188477faa119952fd5117a7','79c76ca5a3f54699bab1915fce884be7'),('ccadafb86188477faa119952fd5117a7','b248ab4f8a6b4175a1e6e6212f10ef23'),('ccadafb86188477faa119952fd5117a7','75138c968f0a4be1adfa06fcd0896773'),('ccadafb86188477faa119952fd5117a7','3ce7a784200d4bc8976697bd98837939'),('ccadafb86188477faa119952fd5117a7','935e7e2d052e4889812ce824175fed84'),('ccadafb86188477faa119952fd5117a7','7d4a3669061a4991a92547fabec4b3ca'),('41f227e1c1374126bf75a23f5d50e740','4af5013acdb04ec08c60fe8671edb520'),('41f227e1c1374126bf75a23f5d50e740','0f569eccbdb54caa9a1ea5ecb039a651'),('41f227e1c1374126bf75a23f5d50e740','2e476d12fc284d46830bef4d94f0704d'),('41f227e1c1374126bf75a23f5d50e740','a56b7c40487c419f9fe6a301f3a5c63e'),('41f227e1c1374126bf75a23f5d50e740','9dc1222fe08d43338b0afbc412f37e2d'),('41f227e1c1374126bf75a23f5d50e740','b23f7ef7ea9c491eb9a916fea5ec877a'),('41f227e1c1374126bf75a23f5d50e740','c0977140ecd14d2fba9c852881e6979a'),('41f227e1c1374126bf75a23f5d50e740','eaf520d09ba84dccba10f44031c1ca5c'),('41f227e1c1374126bf75a23f5d50e740','2d30a077e1ce4355aba406d13bff82b7'),('41f227e1c1374126bf75a23f5d50e740','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('41f227e1c1374126bf75a23f5d50e740','aedeebba2d644ac4b301973853b205ea'),('41f227e1c1374126bf75a23f5d50e740','d1578b33edf44158ba0f55e22294950f'),('41f227e1c1374126bf75a23f5d50e740','cff6be1b08a44ba2a208551cd4fed964'),('41f227e1c1374126bf75a23f5d50e740','877d68157319446aa8b6e15535ed3868'),('41f227e1c1374126bf75a23f5d50e740','79c76ca5a3f54699bab1915fce884be7'),('41f227e1c1374126bf75a23f5d50e740','b248ab4f8a6b4175a1e6e6212f10ef23'),('41f227e1c1374126bf75a23f5d50e740','75138c968f0a4be1adfa06fcd0896773'),('41f227e1c1374126bf75a23f5d50e740','3ce7a784200d4bc8976697bd98837939'),('41f227e1c1374126bf75a23f5d50e740','935e7e2d052e4889812ce824175fed84'),('41f227e1c1374126bf75a23f5d50e740','7d4a3669061a4991a92547fabec4b3ca'),('d0b6135d63fe4079a6bef34f138f1327','4af5013acdb04ec08c60fe8671edb520'),('d0b6135d63fe4079a6bef34f138f1327','0f569eccbdb54caa9a1ea5ecb039a651'),('d0b6135d63fe4079a6bef34f138f1327','2e476d12fc284d46830bef4d94f0704d'),('d0b6135d63fe4079a6bef34f138f1327','a56b7c40487c419f9fe6a301f3a5c63e'),('d0b6135d63fe4079a6bef34f138f1327','9dc1222fe08d43338b0afbc412f37e2d'),('d0b6135d63fe4079a6bef34f138f1327','b23f7ef7ea9c491eb9a916fea5ec877a'),('d0b6135d63fe4079a6bef34f138f1327','c0977140ecd14d2fba9c852881e6979a'),('d0b6135d63fe4079a6bef34f138f1327','eaf520d09ba84dccba10f44031c1ca5c'),('d0b6135d63fe4079a6bef34f138f1327','2d30a077e1ce4355aba406d13bff82b7'),('d0b6135d63fe4079a6bef34f138f1327','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('d0b6135d63fe4079a6bef34f138f1327','aedeebba2d644ac4b301973853b205ea'),('d0b6135d63fe4079a6bef34f138f1327','d1578b33edf44158ba0f55e22294950f'),('d0b6135d63fe4079a6bef34f138f1327','cff6be1b08a44ba2a208551cd4fed964'),('d0b6135d63fe4079a6bef34f138f1327','877d68157319446aa8b6e15535ed3868'),('d0b6135d63fe4079a6bef34f138f1327','79c76ca5a3f54699bab1915fce884be7'),('d0b6135d63fe4079a6bef34f138f1327','b248ab4f8a6b4175a1e6e6212f10ef23'),('d0b6135d63fe4079a6bef34f138f1327','75138c968f0a4be1adfa06fcd0896773'),('d0b6135d63fe4079a6bef34f138f1327','3ce7a784200d4bc8976697bd98837939'),('d0b6135d63fe4079a6bef34f138f1327','935e7e2d052e4889812ce824175fed84'),('d0b6135d63fe4079a6bef34f138f1327','7d4a3669061a4991a92547fabec4b3ca'),('bff6b3fd46e141c89e89493a1b2f783f','4af5013acdb04ec08c60fe8671edb520'),('bff6b3fd46e141c89e89493a1b2f783f','0f569eccbdb54caa9a1ea5ecb039a651'),('bff6b3fd46e141c89e89493a1b2f783f','2e476d12fc284d46830bef4d94f0704d'),('bff6b3fd46e141c89e89493a1b2f783f','a56b7c40487c419f9fe6a301f3a5c63e'),('bff6b3fd46e141c89e89493a1b2f783f','9dc1222fe08d43338b0afbc412f37e2d'),('bff6b3fd46e141c89e89493a1b2f783f','b23f7ef7ea9c491eb9a916fea5ec877a'),('bff6b3fd46e141c89e89493a1b2f783f','c0977140ecd14d2fba9c852881e6979a'),('bff6b3fd46e141c89e89493a1b2f783f','eaf520d09ba84dccba10f44031c1ca5c'),('bff6b3fd46e141c89e89493a1b2f783f','2d30a077e1ce4355aba406d13bff82b7'),('bff6b3fd46e141c89e89493a1b2f783f','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('bff6b3fd46e141c89e89493a1b2f783f','aedeebba2d644ac4b301973853b205ea'),('bff6b3fd46e141c89e89493a1b2f783f','d1578b33edf44158ba0f55e22294950f'),('bff6b3fd46e141c89e89493a1b2f783f','cff6be1b08a44ba2a208551cd4fed964'),('bff6b3fd46e141c89e89493a1b2f783f','877d68157319446aa8b6e15535ed3868'),('bff6b3fd46e141c89e89493a1b2f783f','79c76ca5a3f54699bab1915fce884be7'),('bff6b3fd46e141c89e89493a1b2f783f','b248ab4f8a6b4175a1e6e6212f10ef23'),('bff6b3fd46e141c89e89493a1b2f783f','75138c968f0a4be1adfa06fcd0896773'),('bff6b3fd46e141c89e89493a1b2f783f','3ce7a784200d4bc8976697bd98837939'),('bff6b3fd46e141c89e89493a1b2f783f','935e7e2d052e4889812ce824175fed84'),('bff6b3fd46e141c89e89493a1b2f783f','7d4a3669061a4991a92547fabec4b3ca'),('1e22dd1a6f604244b08221551ffdff96','4af5013acdb04ec08c60fe8671edb520'),('1e22dd1a6f604244b08221551ffdff96','0f569eccbdb54caa9a1ea5ecb039a651'),('1e22dd1a6f604244b08221551ffdff96','2e476d12fc284d46830bef4d94f0704d'),('1e22dd1a6f604244b08221551ffdff96','a56b7c40487c419f9fe6a301f3a5c63e'),('1e22dd1a6f604244b08221551ffdff96','9dc1222fe08d43338b0afbc412f37e2d'),('1e22dd1a6f604244b08221551ffdff96','b23f7ef7ea9c491eb9a916fea5ec877a'),('1e22dd1a6f604244b08221551ffdff96','c0977140ecd14d2fba9c852881e6979a'),('1e22dd1a6f604244b08221551ffdff96','eaf520d09ba84dccba10f44031c1ca5c'),('1e22dd1a6f604244b08221551ffdff96','2d30a077e1ce4355aba406d13bff82b7'),('1e22dd1a6f604244b08221551ffdff96','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('1e22dd1a6f604244b08221551ffdff96','aedeebba2d644ac4b301973853b205ea'),('1e22dd1a6f604244b08221551ffdff96','d1578b33edf44158ba0f55e22294950f'),('1e22dd1a6f604244b08221551ffdff96','cff6be1b08a44ba2a208551cd4fed964'),('1e22dd1a6f604244b08221551ffdff96','877d68157319446aa8b6e15535ed3868'),('1e22dd1a6f604244b08221551ffdff96','79c76ca5a3f54699bab1915fce884be7'),('1e22dd1a6f604244b08221551ffdff96','b248ab4f8a6b4175a1e6e6212f10ef23'),('1e22dd1a6f604244b08221551ffdff96','75138c968f0a4be1adfa06fcd0896773'),('1e22dd1a6f604244b08221551ffdff96','3ce7a784200d4bc8976697bd98837939'),('1e22dd1a6f604244b08221551ffdff96','935e7e2d052e4889812ce824175fed84'),('1e22dd1a6f604244b08221551ffdff96','7d4a3669061a4991a92547fabec4b3ca'),('610671132e3b464eb0a79ad2b98b5ea3','4af5013acdb04ec08c60fe8671edb520'),('610671132e3b464eb0a79ad2b98b5ea3','0f569eccbdb54caa9a1ea5ecb039a651'),('610671132e3b464eb0a79ad2b98b5ea3','2e476d12fc284d46830bef4d94f0704d'),('610671132e3b464eb0a79ad2b98b5ea3','a56b7c40487c419f9fe6a301f3a5c63e'),('610671132e3b464eb0a79ad2b98b5ea3','9dc1222fe08d43338b0afbc412f37e2d'),('610671132e3b464eb0a79ad2b98b5ea3','b23f7ef7ea9c491eb9a916fea5ec877a'),('610671132e3b464eb0a79ad2b98b5ea3','c0977140ecd14d2fba9c852881e6979a'),('610671132e3b464eb0a79ad2b98b5ea3','eaf520d09ba84dccba10f44031c1ca5c'),('610671132e3b464eb0a79ad2b98b5ea3','2d30a077e1ce4355aba406d13bff82b7'),('610671132e3b464eb0a79ad2b98b5ea3','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('610671132e3b464eb0a79ad2b98b5ea3','aedeebba2d644ac4b301973853b205ea'),('610671132e3b464eb0a79ad2b98b5ea3','d1578b33edf44158ba0f55e22294950f'),('610671132e3b464eb0a79ad2b98b5ea3','cff6be1b08a44ba2a208551cd4fed964'),('610671132e3b464eb0a79ad2b98b5ea3','877d68157319446aa8b6e15535ed3868'),('610671132e3b464eb0a79ad2b98b5ea3','79c76ca5a3f54699bab1915fce884be7'),('610671132e3b464eb0a79ad2b98b5ea3','b248ab4f8a6b4175a1e6e6212f10ef23'),('610671132e3b464eb0a79ad2b98b5ea3','75138c968f0a4be1adfa06fcd0896773'),('610671132e3b464eb0a79ad2b98b5ea3','3ce7a784200d4bc8976697bd98837939'),('610671132e3b464eb0a79ad2b98b5ea3','935e7e2d052e4889812ce824175fed84'),('610671132e3b464eb0a79ad2b98b5ea3','7d4a3669061a4991a92547fabec4b3ca'),('7d9fcb0e28f0442792fe04f2540fcfe9','4af5013acdb04ec08c60fe8671edb520'),('7d9fcb0e28f0442792fe04f2540fcfe9','0f569eccbdb54caa9a1ea5ecb039a651'),('7d9fcb0e28f0442792fe04f2540fcfe9','2e476d12fc284d46830bef4d94f0704d'),('7d9fcb0e28f0442792fe04f2540fcfe9','a56b7c40487c419f9fe6a301f3a5c63e'),('7d9fcb0e28f0442792fe04f2540fcfe9','9dc1222fe08d43338b0afbc412f37e2d'),('7d9fcb0e28f0442792fe04f2540fcfe9','b23f7ef7ea9c491eb9a916fea5ec877a'),('7d9fcb0e28f0442792fe04f2540fcfe9','c0977140ecd14d2fba9c852881e6979a'),('7d9fcb0e28f0442792fe04f2540fcfe9','eaf520d09ba84dccba10f44031c1ca5c'),('7d9fcb0e28f0442792fe04f2540fcfe9','2d30a077e1ce4355aba406d13bff82b7'),('7d9fcb0e28f0442792fe04f2540fcfe9','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('7d9fcb0e28f0442792fe04f2540fcfe9','aedeebba2d644ac4b301973853b205ea'),('7d9fcb0e28f0442792fe04f2540fcfe9','d1578b33edf44158ba0f55e22294950f'),('7d9fcb0e28f0442792fe04f2540fcfe9','cff6be1b08a44ba2a208551cd4fed964'),('7d9fcb0e28f0442792fe04f2540fcfe9','877d68157319446aa8b6e15535ed3868'),('7d9fcb0e28f0442792fe04f2540fcfe9','79c76ca5a3f54699bab1915fce884be7'),('7d9fcb0e28f0442792fe04f2540fcfe9','b248ab4f8a6b4175a1e6e6212f10ef23'),('7d9fcb0e28f0442792fe04f2540fcfe9','75138c968f0a4be1adfa06fcd0896773'),('7d9fcb0e28f0442792fe04f2540fcfe9','3ce7a784200d4bc8976697bd98837939'),('7d9fcb0e28f0442792fe04f2540fcfe9','935e7e2d052e4889812ce824175fed84'),('7d9fcb0e28f0442792fe04f2540fcfe9','7d4a3669061a4991a92547fabec4b3ca'),('aec4fd7b198a44c08511e06e639a7143','4af5013acdb04ec08c60fe8671edb520'),('aec4fd7b198a44c08511e06e639a7143','0f569eccbdb54caa9a1ea5ecb039a651'),('aec4fd7b198a44c08511e06e639a7143','2e476d12fc284d46830bef4d94f0704d'),('aec4fd7b198a44c08511e06e639a7143','a56b7c40487c419f9fe6a301f3a5c63e'),('aec4fd7b198a44c08511e06e639a7143','9dc1222fe08d43338b0afbc412f37e2d'),('aec4fd7b198a44c08511e06e639a7143','b23f7ef7ea9c491eb9a916fea5ec877a'),('aec4fd7b198a44c08511e06e639a7143','c0977140ecd14d2fba9c852881e6979a'),('aec4fd7b198a44c08511e06e639a7143','eaf520d09ba84dccba10f44031c1ca5c'),('aec4fd7b198a44c08511e06e639a7143','2d30a077e1ce4355aba406d13bff82b7'),('aec4fd7b198a44c08511e06e639a7143','3f2a6d6fcb104eb98fbcb4cf2eebeae7'),('aec4fd7b198a44c08511e06e639a7143','aedeebba2d644ac4b301973853b205ea'),('aec4fd7b198a44c08511e06e639a7143','d1578b33edf44158ba0f55e22294950f'),('aec4fd7b198a44c08511e06e639a7143','cff6be1b08a44ba2a208551cd4fed964'),('aec4fd7b198a44c08511e06e639a7143','877d68157319446aa8b6e15535ed3868'),('aec4fd7b198a44c08511e06e639a7143','79c76ca5a3f54699bab1915fce884be7'),('aec4fd7b198a44c08511e06e639a7143','b248ab4f8a6b4175a1e6e6212f10ef23'),('aec4fd7b198a44c08511e06e639a7143','75138c968f0a4be1adfa06fcd0896773'),('aec4fd7b198a44c08511e06e639a7143','3ce7a784200d4bc8976697bd98837939'),('aec4fd7b198a44c08511e06e639a7143','935e7e2d052e4889812ce824175fed84'),('aec4fd7b198a44c08511e06e639a7143','7d4a3669061a4991a92547fabec4b3ca');
/*!40000 ALTER TABLE `t_role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  KEY `FK9bmt317466eg6ec4nr3pf2cw1` (`role_id`),
  KEY `FKhg969mnxp490no964cu91qrb9` (`user_id`),
  CONSTRAINT `FK9bmt317466eg6ec4nr3pf2cw1` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`),
  CONSTRAINT `FKhg969mnxp490no964cu91qrb9` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES ('a7fa0671c1244c159b62bdb360db3534','fd2af3f51f1a41e7b10c8b65118bbcad'),('a7fa0671c1244c159b62bdb360db3534','2f1663eeedde4efeb9c211c05ef98cca'),('a7fa0671c1244c159b62bdb360db3534','ccadafb86188477faa119952fd5117a7'),('a7fa0671c1244c159b62bdb360db3534','41f227e1c1374126bf75a23f5d50e740'),('a7fa0671c1244c159b62bdb360db3534','d0b6135d63fe4079a6bef34f138f1327'),('a7fa0671c1244c159b62bdb360db3534','bff6b3fd46e141c89e89493a1b2f783f'),('a7fa0671c1244c159b62bdb360db3534','1e22dd1a6f604244b08221551ffdff96'),('a7fa0671c1244c159b62bdb360db3534','610671132e3b464eb0a79ad2b98b5ea3'),('a7fa0671c1244c159b62bdb360db3534','7d9fcb0e28f0442792fe04f2540fcfe9'),('a7fa0671c1244c159b62bdb360db3534','aec4fd7b198a44c08511e06e639a7143');
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-06 17:26:17
