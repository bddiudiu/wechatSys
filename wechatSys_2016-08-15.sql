# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.26)
# Database: wechatSys
# Generation Time: 2016-08-15 02:20:48 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_sys_dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_dept`;

CREATE TABLE `t_sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(32) DEFAULT NULL,
  `deptDesc` varchar(32) DEFAULT NULL,
  `deptAlias` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_sys_dept` WRITE;
/*!40000 ALTER TABLE `t_sys_dept` DISABLE KEYS */;

INSERT INTO `t_sys_dept` (`id`, `deptName`, `deptDesc`, `deptAlias`)
VALUES
	(1,'dept','dept','dept');

/*!40000 ALTER TABLE `t_sys_dept` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_permission`;

CREATE TABLE `t_sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(32) DEFAULT NULL,
  `url` varchar(32) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sys_role_sys_permission_role_id` (`role_id`),
  CONSTRAINT `fk_sys_role_sys_permission_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_sys_permission` WRITE;
/*!40000 ALTER TABLE `t_sys_permission` DISABLE KEYS */;

INSERT INTO `t_sys_permission` (`id`, `token`, `url`, `description`, `role_id`)
VALUES
	(1,NULL,'/home','首页',1);

/*!40000 ALTER TABLE `t_sys_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `description` varchar(1024) DEFAULT NULL COMMENT '权限简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_sys_role` WRITE;
/*!40000 ALTER TABLE `t_sys_role` DISABLE KEYS */;

INSERT INTO `t_sys_role` (`id`, `name`, `description`)
VALUES
	(1,'admin','管理员');

/*!40000 ALTER TABLE `t_sys_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sys_user_sys_user_role_id` (`user_id`),
  KEY `fk_sys_role_sys_user_role_id` (`role_id`),
  CONSTRAINT `fk_sys_role_sys_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`),
  CONSTRAINT `fk_sys_user_sys_user_role_id` FOREIGN KEY (`user_id`) REFERENCES `t_sys_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_sys_user_role` WRITE;
/*!40000 ALTER TABLE `t_sys_user_role` DISABLE KEYS */;

INSERT INTO `t_sys_user_role` (`id`, `user_id`, `role_id`)
VALUES
	(1,1,1);

/*!40000 ALTER TABLE `t_sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_sys_users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_sys_users`;

CREATE TABLE `t_sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `nikeName` varchar(32) DEFAULT NULL,
  `dept_id` int(11) NOT NULL DEFAULT '1',
  `isAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dept_id` (`dept_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `t_sys_dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `t_sys_users` WRITE;
/*!40000 ALTER TABLE `t_sys_users` DISABLE KEYS */;

INSERT INTO `t_sys_users` (`id`, `username`, `password`, `sex`, `phone`, `mobile`, `email`, `nikeName`, `dept_id`, `isAdmin`)
VALUES
	(1,'admin','admin',1,NULL,NULL,'bddiudiu@qq.com','阿丢丢',1,1),
	(2,'2','2',2,'2',NULL,NULL,NULL,1,NULL),
	(3,'3','3',3,NULL,NULL,NULL,NULL,1,NULL),
	(4,'4','4',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(5,'5','5',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(6,'6','6',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(7,'7','7',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(8,'8','8',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(9,'9','9',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(10,'11','11',NULL,NULL,NULL,NULL,NULL,1,NULL),
	(11,'12','12',NULL,NULL,NULL,NULL,NULL,1,NULL);

/*!40000 ALTER TABLE `t_sys_users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
