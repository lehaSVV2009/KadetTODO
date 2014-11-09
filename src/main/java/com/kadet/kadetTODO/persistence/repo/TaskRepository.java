package com.kadet.kadetTODO.persistence.repo;

import com.kadet.kadetTODO.persistence.entity.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by AlexSoroka on 11/8/2014.
 */
public interface TaskRepository extends JpaRepository<Task, Long>,
        QueryDslPredicateExecutor<Task> {

    @Query("select t from task t where t.project.id = :projectId")
    Page<Task> findByProjectId(@Param("projectId") Long projectId, Pageable pageable);

    @Query("select t from task t where t.project.id = :projectId")
    List<Task> findByProjectId(@Param("projectId") Long projectId);

    Task findByTitle(String title);

}
