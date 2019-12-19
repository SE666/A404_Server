/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : a404

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 19/12/2019 11:25:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for form
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `applydate` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `end` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `ifmedia` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `submitdatetime` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO `form` VALUES (1, 1, '2019-11-31', '08:10', '09:10', 5, '否', '****', '待审核', '2019-10-31 08:11:15');
INSERT INTO `form` VALUES (2, 1, '2019-12-14', '09:00', '11:00', 7, '是', '####', '审核通过', '2019-10-31 08:22:40');
INSERT INTO `form` VALUES (3, 3, '2019-12-10', '09:30', '10:30', 5, '是', '，，，', '未通过', '2019-12-08');
INSERT INTO `form` VALUES (4, 4, '2019-12-09', '14:00', '16:30', 7, '否', '。。。', '待审核', '2019-12-08');
INSERT INTO `form` VALUES (5, 3, '2019-12-09', '10:00', '11:30', 6, '是', '、、、', '待审核', '2019-12-08');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '17020031068', '汪wqs', '1068', '17852417737', 1);
INSERT INTO `user` VALUES (3, '17020031071', '王wmx', '1071', '17863998708', 0);
INSERT INTO `user` VALUES (4, '17020031071', '王wmx', '1071', '17863998708', 0);

SET FOREIGN_KEY_CHECKS = 1;
