package com.kadet.kadetTODO.service.project;

import com.kadet.kadetTODO.persistence.entity.project.Project;
import com.kadet.kadetTODO.persistence.entity.user.QUser;
import com.kadet.kadetTODO.persistence.entity.user.User;
import com.kadet.kadetTODO.persistence.repo.UserRepository;
import com.kadet.kadetTODO.util.extjs.FilterRequest;
import com.kadet.kadetTODO.util.mapper.UserMapper;
import com.kadet.kadetTODO.web.model.EmployeeUI;
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
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    private Logger logger = Logger.getLogger(EmployeeService.class);

    public EmployeeService () {
        super();
    }


    public List<EmployeeUI> findAll () {
        return mapper.toUIEntity(userRepository.findAll());
    }

    public Page<EmployeeUI> findAll (Pageable pageable, List<FilterRequest> filters) {
        Predicate predicate = toPredicate(filters);

        return mapper.toUIEntity(userRepository.findAll(predicate, pageable),
                pageable);
    }

    public EmployeeUI findByUsername (String name) {
        return mapper.toUIEntity(userRepository.findByUsername(name));
    }


    private Predicate toPredicate (final List<FilterRequest> filters) {

        logger.info("Entering predicates :: " + filters);


        QUser user = QUser.user;
        BooleanExpression result = null;

        try {
            for (FilterRequest filter : filters) {

                User.COLUMNS column = User.COLUMNS.valueOf(filter.getProperty()
                        .toUpperCase());
                BooleanExpression expression = null;

                switch (column) {
                    case USERNAME:
                        if (checkFilter(filter)) {
                            expression = user.username.like("%"
                                    + filter.getValue() + "%");
                        }
                        break;
                    case FIRSTNAME:
                        if (checkFilter(filter)) {
                            expression = user.firstName.like("%"
                                    + filter.getValue() + "%");
                        }
                        break;
                    case LASTNAME:
                        if (checkFilter(filter)) {
                            expression = user.lastName.like("%"
                                    + filter.getValue() + "%");
                        }
                        break;
                    case EMAIL:
                        if (checkFilter(filter)) {
                            expression = user.email.like("%"
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
