package com.kadet.kadetTODO.persistence.repo;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
public interface ProjectRepository extends JpaRepository<Project, Long>,
        QueryDslPredicateExecutor<Project> {

    Project findByName (String username);

}
