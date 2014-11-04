-- Staff
INSERT INTO `kadetTODO`.`user`
(`firstName`, `lastName`, `password`, `username`, `email`, `lastLoggedIn`)
VALUES
  ('Administrator', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'local.admin@local.com', sysdate()),
  ('Administrator1', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin1', 'local.admin@local.com', sysdate()),
  ('Administrator2', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin2', 'local.admin@local.com', sysdate()),
  ('Administrator3', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin3', 'local.admin@local.com', sysdate());


INSERT INTO `kadetTODO`.`user`
(`firstName`, `lastName`, `password`, `username`, `email`, `lastLoggedIn`)
VALUES
  ('User', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'user', 'local.admin@local.com', sysdate()),
  ('User1', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'user1', 'local.admin@local.com', sysdate()),
  ('User2', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'user2', 'local.admin@local.com', sysdate()),
  ('User3', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'user3', 'local.admin@local.com', sysdate());

/*`id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `description`*/

-- Product Group 
INSERT INTO `kadetTODO`.`project`
(`name`, `description`, `createdDate`) VALUES
  ('Project1', 'Proj One', sysdate()),
  ('Project2', 'Proj Two', sysdate());