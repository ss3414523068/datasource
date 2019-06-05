/************************************************************分割线************************************************************/

CREATE TABLE `user`  (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT '',
  `password` VARCHAR(255) NULL DEFAULT '',
  PRIMARY KEY (`id`)
);