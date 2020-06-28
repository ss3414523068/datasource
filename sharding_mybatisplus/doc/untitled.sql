/************************************************************分割线************************************************************/
/* todo 单库水平分表 */

CREATE TABLE `user_1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `user_2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `user_1`(`id`, `name`, `password`) VALUES (1, 'name123', 'pwd1');
INSERT INTO `user_1`(`id`, `name`, `password`) VALUES (3, 'name248', 'pwd3');
INSERT INTO `user_1`(`id`, `name`, `password`) VALUES (5, 'name456', 'pwd2');

INSERT INTO `user_2`(`id`, `name`, `password`) VALUES (2, 'name456', 'pwd2');
INSERT INTO `user_2`(`id`, `name`, `password`) VALUES (4, 'name123', 'pwd1');
INSERT INTO `user_2`(`id`, `name`, `password`) VALUES (6, 'name248', 'pwd3');