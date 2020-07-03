/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : spring_all

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 02/07/2020 08:39:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qd_cart
-- ----------------------------
DROP TABLE IF EXISTS `qd_cart`;
CREATE TABLE `qd_cart`  (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `cart_time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `cart_status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `cart_sum` int(16) NOT NULL COMMENT '数量',
  `cart_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '关联 d_order表',
  `user_id` int(16) NULL DEFAULT NULL COMMENT '买家id',
  `cart_user_id` int(16) NULL DEFAULT NULL COMMENT '卖家id',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qd_cart
-- ----------------------------
INSERT INTO `qd_cart` VALUES (1, '华为p40pro', '2020-07-01 16:15:01', '待支付', 2, 9999.00, 1, 1010, 2020);
INSERT INTO `qd_cart` VALUES (2, '小米10pro', '2020-07-01 16:15:01', '待支付', 2, 9999.00, 1, 1010, 2021);
INSERT INTO `qd_cart` VALUES (3, '小米11pro', '2020-07-01 16:15:01', '待支付', 1, 9999.00, 1, 1010, 2022);

-- ----------------------------
-- Table structure for qd_order
-- ----------------------------
DROP TABLE IF EXISTS `qd_order`;
CREATE TABLE `qd_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `order_status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `user_id` int(16) NOT NULL COMMENT '用户id',
  `order_user_id` int(16) NULL DEFAULT NULL COMMENT '卖家id',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qd_order
-- ----------------------------
INSERT INTO `qd_order` VALUES (1, '2020-07-01 16:14:38', '待支付', 1010, 2020);
INSERT INTO `qd_order` VALUES (2, '2020-07-01 16:16:49', '已完成', 1010, 2020);
INSERT INTO `qd_order` VALUES (3, '2020-07-02 08:14:44', '待支付', 1010, 2020);
INSERT INTO `qd_order` VALUES (4, '2020-07-02 08:19:37', '待支付', 1010, 2021);
INSERT INTO `qd_order` VALUES (5, '2020-07-02 08:20:04', '待支付', 1010, 2020);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(16) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1010, '1010', '1010', '用户');
INSERT INTO `user` VALUES (2020, '2020', '2020', '卖家2020');
INSERT INTO `user` VALUES (2021, '2021', '2021', '卖家2021');

SET FOREIGN_KEY_CHECKS = 1;
