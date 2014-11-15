DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS user;

-- Task
CREATE TABLE IF NOT EXISTS `task` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,

  `title`        VARCHAR(255) NOT NULL,
  `description`  VARCHAR(255) DEFAULT NULL,

  `status`       int(10) NOT NULL DEFAULT 0,
  `level`        int(10) NOT NULL DEFAULT 4,

  `openedDate`   DATETIME DEFAULT CURRENT_TIMESTAMP,
  `closedDate`   DATETIME DEFAULT NULL,
  `reopenedDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;

-- User
CREATE TABLE IF NOT EXISTS `user` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,

  `username`     VARCHAR(255) NOT NULL,
  `password`     VARCHAR(255) NOT NULL,

  `surname`      VARCHAR(255) NOT NULL,
  `name`         VARCHAR(255) NOT NULL,

  `role`         int(10) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;
