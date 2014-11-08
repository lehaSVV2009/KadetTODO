package com.kadet.kadetTODO.persistence.repo;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
public interface ProjectRepository extends JpaRepository<Project, Long>,
        QueryDslPredicateExecutor<Project> {

    Project findByName (String username);

    // TODO: join fetch
   /* @Query("SELECT p FROM Project p JOIN FETCH p.tasks where p.id = :id")
    Project findOneWithTasks (@Param("id") Long id);*/

}
