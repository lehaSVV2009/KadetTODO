-- Tasks
INSERT INTO `kadetTODO`.`task`
(`title`, `description`, `status`, `level`, `openedDate`) VALUES
  ('Project1-1', '1.Description of task 1', 0, 4, sysdate()),
  ('Project1-2', '1.Description of task 2', 0, 4, sysdate()),
  ('Project1-3', '1.Description of task 3', 0, 4, sysdate()),
  ('Project1-4', '1.Description of task 4', 0, 4, sysdate()),
  ('Project2-1', '2.Description of task 1', 0, 4, sysdate()),
  ('Project2-2', '2.Description of task 2', 0, 4, sysdate()),
  ('Project2-3', '2.Description of task 3', 0, 4, sysdate()),
  ('Project2-4', '2.Description of task 4', 0, 4, sysdate());


-- Users
INSERT INTO `kadettodo`.`user`
(`name`, `surname`, `password`, `username`, `role`) VALUES
  ('Administrator', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin', 0),
  ('Administrator1', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin1', 0),
  ('Administrator2', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin2', 0),
  ('Administrator3', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin3', 0),
  ('Administrator4', 'Local', '21232f297a57a5a743894a0e4a801fc3', 'admin4', 0);
;