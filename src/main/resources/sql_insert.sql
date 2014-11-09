-- Admins
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

-- Projects
INSERT INTO `kadetTODO`.`project`
(`name`, `description`, `createdDate`) VALUES
  ('Project1', 'Proj One', sysdate()),
  ('Project2', 'Proj Two', sysdate());

-- Tasks
INSERT INTO `kadetTODO`.`task`
(`title`, `description`, `projectId`, `status`, `level`, `openedDate`) VALUES
  ('Project1-1', '1.Description of task 1', 1, 1, 'CRITICAL', sysdate()),
  ('Project1-2', '1.Description of task 2', 1, 2, 'CRITICAL', sysdate()),
  ('Project1-3', '1.Description of task 3', 1, 3, 'CRITICAL', sysdate()),
  ('Project1-4', '1.Description of task 4', 1, 4, 'CRITICAL', sysdate()),
  ('Project2-1', '2.Description of task 1', 2, 1, 'CRITICAL', sysdate()),
  ('Project2-2', '2.Description of task 2', 2, 2, 'CRITICAL', sysdate()),
  ('Project2-3', '2.Description of task 3', 2, 3, 'CRITICAL', sysdate()),
  ('Project2-4', '2.Description of task 4', 2, 4, 'CRITICAL', sysdate());

-- User - task
INSERT INTO `kadetTODO`.`projectUser`
(`accountId`, `projectId`) VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (1, 2),
  (2, 2);

-- Task - user
INSERT INTO `kadetTODO`.`taskassignedtouser`
(`accountId`, `taskId`) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (1, 5),
  (2, 6),
  (1, 6);