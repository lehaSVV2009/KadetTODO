package com.kadet.kadetTODO.service.project;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.project.QProject;
import com.kadet.kadetTODO.persistence.repo.ProjectRepository;
import com.kadet.kadetTODO.util.extjs.FilterRequest;
import com.kadet.kadetTODO.util.mapper.ProjectMapper;
import com.kadet.kadetTODO.web.model.ProjectUI;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AlexSoroka on 11/3/2014.
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper mapper;

    private Logger logger = Logger.getLogger(ProjectService.class);

    public ProjectService () {
        super();
    }


    public List<ProjectUI> findAll () {
        return mapper.toUIEntity(projectRepository.findAll());
    }

    public Page<ProjectUI> findAll (Pageable pageable, List<FilterRequest> filters) {
        Predicate predicate = toPredicate(filters);

        return mapper.toUIEntity(projectRepository.findAll(predicate, pageable),
                pageable);
    }

    public ProjectUI findByName (String name) {
        return mapper.toUIEntity(projectRepository.findByName(name));
    }


    private Predicate toPredicate (final List<FilterRequest> filters) {

        logger.info("Entering predicates :: " + filters);

        QProject project = QProject.project;
        BooleanExpression result = null;

        try {
            for (FilterRequest filter : filters) {

                Project.COLUMNS column = Project.COLUMNS.valueOf(filter.getProperty()
                        .toUpperCase());
                BooleanExpression expression = null;

                switch (column) {
                    case NAME:
                        if (checkFilter(filter)) {
                            expression = project.name.like("%"
                                    + filter.getValue() + "%");
                        }
                        break;
                    case DESCRIPTION:
                        if (checkFilter(filter)) {
                            expression = project.description.like("%"
                                    + filter.getValue() + "%");
                        }
                        break;
                }
                if (expression != null) {
                    if (result != null) {
                        result = result.and(expression);
                    } else {
                        result = expression;
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
        logger.info("Result Predicate :: "
                + (result != null ? result.toString() : ""));

        logger.info("Exiting predicates");
        return result;
    }


    private boolean checkFilter (FilterRequest filter) {
        return filter.getValue() != null
                && !"".equals(filter.getValue());
    }

}
