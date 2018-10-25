CREATE DATABASE `shyali-soap-db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `shyali-soap-db`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first-name` varchar(45) COLLATE utf8_bin NOT NULL,
  `last-name` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;