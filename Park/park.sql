/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : park

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-05-28 12:13:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park` (
  `parkID` varchar(20) NOT NULL,
  `parkStatic` varchar(20) DEFAULT NULL,
  `price` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`parkID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES ('1', 'used', '20');
INSERT INTO `park` VALUES ('2', 'unused', '10');
INSERT INTO `park` VALUES ('7', 'used', '5');
INSERT INTO `park` VALUES ('8', 'used', '10');
