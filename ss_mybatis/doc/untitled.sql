/************************************************************分割线************************************************************/
/* todo mybatis_test */

CREATE TABLE `mybatis_test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT 0,
  `create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `mybatis_test` VALUES (1, 0, '');
INSERT INTO `mybatis_test` VALUES (2, 0, '');
INSERT INTO `mybatis_test` VALUES (3, 0, '');
INSERT INTO `mybatis_test` VALUES (4, 0, '');
INSERT INTO `mybatis_test` VALUES (5, 0, '');
INSERT INTO `mybatis_test` VALUES (6, 0, '');
INSERT INTO `mybatis_test` VALUES (7, 0, '2018-12-26 18:00:00');
INSERT INTO `mybatis_test` VALUES (8, 0, '2018-12-26 19:00:00');
INSERT INTO `mybatis_test` VALUES (9, 0, '2018-12-27 18:00:00');
INSERT INTO `mybatis_test` VALUES (10, 0, '2018-12-27 19:00:00');

/************************************************************分割线************************************************************/
/* todo mybatis_user/mybatis_role/mybatis_user_role（映射） */

CREATE TABLE `mybatis_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `mybatis_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `mybatis_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT 0,
  `role_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `mybatis_user` VALUES (1, 'name1', 'pwd1');
INSERT INTO `mybatis_role` VALUES (1, 'role1');
INSERT INTO `mybatis_role` VALUES (2, 'role2');
INSERT INTO `mybatis_user_role` VALUES (1, 1, 1);
INSERT INTO `mybatis_user_role` VALUES (2, 1, 2);