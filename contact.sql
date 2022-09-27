CREATE DATABASE  IF NOT EXISTS `contact_directory`;
USE `contact_directory`;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `contact`
--

INSERT INTO `contact` VALUES
	(1,'Eric','Elliot','222-555-6575'),
	(2,'Steve','Jobs','220-454-6754'),
	(3,'Fred','Allen','210-657-9886'),
	(4,'Steve','Wozniak','343-675-8786'),
	(5,'Bill','Gates','343-654-9688');

