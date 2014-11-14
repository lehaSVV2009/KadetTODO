DROP TABLE IF EXISTS task;

-- Task
CREATE TABLE IF NOT EXISTS `task` (
  `id`           BIGINT(20)   NOT NULL AUTO_INCREMENT,

  `title`        VARCHAR(255) NOT NULL,
  `description`  VARCHAR(255) DEFAULT NULL,

  `status`       VARCHAR(255) NOT NULL DEFAULT 'OPENED',
  `level`        VARCHAR(255) NOT NULL DEFAULT 'CRITICAL',

  `openedDate`   DATETIME DEFAULT CURRENT_TIMESTAMP,
  `closedDate`   DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  AUTO_INCREMENT =1;
