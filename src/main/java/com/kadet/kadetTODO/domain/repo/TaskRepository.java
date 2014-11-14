package com.kadet.kadetTODO.domain.repo;

import com.kadet.kadetTODO.domain.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * @author Alex Soroka
 */
@Resource
public interface TaskRepository extends JpaRepository<Task, Long> {



}
