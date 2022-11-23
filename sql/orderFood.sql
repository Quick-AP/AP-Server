/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : quick-ap

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 13/11/2022 11:54:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `table_id` int NOT NULL,
                              `food_id` varchar(255) NOT NULL DEFAULT '',
                              `price` decimal(10,1) NOT NULL,
                              `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `order_food_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='All food in order under corresponding table.';
SET FOREIGN_KEY_CHECKS = 1;
