/*
Navicat MySQL Data Transfer

Source Server         : EasyMemo
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : easymemo

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2019-01-05 16:07:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `memo_user`
-- ----------------------------
DROP TABLE IF EXISTS `memo_user`;
CREATE TABLE `memo_user` (
  `memo_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(11) COLLATE utf8_bin NOT NULL,
  `memo_content` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `memo_account` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `memo_password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `memo_note` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `memo_date` date DEFAULT NULL,
  PRIMARY KEY (`memo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of memo_user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_account` varchar(11) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_info
-- ----------------------------
