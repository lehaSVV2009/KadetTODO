DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS taskAssignedToUser;
DROP TABLE IF EXISTS projectUser;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS project;

-- User
CREATE TABLE IF NOT EXISTS `user` (
  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT,
  `firstName`    VARCHAR(255) DEFAULT NULL,
  `lastName`     VARCHAR(255) DEFAULT NULL,
  `password`     VARCHAR(255) DEFAULT NULL,
  `username`     VARCHAR(255) DEFAULT NULL,
  `email`        VARCHAR(255) DEFAULT NULL,
  `lastLoggedIn` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;

-- Role
CREATE TABLE IF NOT EXISTS `role` (
  `id`     BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role`   INT(11) DEFAULT NULL,
  `userId` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3580769128426C` (`userId`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;

-- Project
CREATE TABLE IF NOT EXISTS `project` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `createdDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projectname` (`name`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;

-- Task
CREATE TABLE IF NOT EXISTS `task` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(255) NOT NULL,
  `description`  VARCHAR(255) DEFAULT NULL,
  `project`      BIGINT(20)   NOT NULL,
  `manager`      BIGINT(20)   NOT NULL,
  `status`       INT(10)      NOT NULL DEFAULT 1,
  `level`        INT(10)      NOT NULL DEFAULT 1,
  `openedDate`   DATETIME DEFAULT NULL,
  `modifiedDate` DATETIME DEFAULT NULL,
  `resolvedDate` DATETIME DEFAULT NULL,
  `closedDate`   DATETIME DEFAULT NULL,
  `reopenedDate` DATETIME DEFAULT NULL,
  `removedDate`  DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `taskname` (`name`),
  KEY `FKPROJECT` (`project`),
  CONSTRAINT `FKPROJECT` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;
/*
-- User - Project (many to many)
CREATE TABLE IF NOT EXISTS `projectUser` (
  `id`        BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `projectId` VARCHAR(255) NOT NULL,
  `accountId` BIGINT(20)   NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKPUPRJID` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`),
  CONSTRAINT `FKPUUSRID` FOREIGN KEY (`accountId`) REFERENCES `user` (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;
*/
-- Task - User (many to many)
CREATE TABLE IF NOT EXISTS `taskAssignedToUser` (
  `id`        BIGINT(20) NOT NULL AUTO_INCREMENT,
  `taskId`    BIGINT(20) NOT NULL,
  `accountId` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKTATUUSERID` FOREIGN KEY (`accountId`) REFERENCES `user` (`id`),
  CONSTRAINT `FKTATUTASKID` FOREIGN KEY (`taskId`) REFERENCES `task` (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;
