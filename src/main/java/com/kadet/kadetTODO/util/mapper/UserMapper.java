package com.kadet.kadetTODO.util.mapper;

import com.kadet.kadetTODO.persistence.entity.user.User;
import com.kadet.kadetTODO.web.model.EmployeeUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexSoroka on 11/5/2014.
 */
@Service
public class UserMapper implements Mapper<EmployeeUI, User> {
    @Override
    public EmployeeUI toUIEntity (User entity) {
        EmployeeUI ui = null;
        if (entity != null) {
            ui = new EmployeeUI();
            ui.setUsername(entity.getUsername());
            ui.setFirstName(entity.getFirstName());
            ui.setLastName(entity.getLastName());
            ui.setEmail(entity.getEmail());
            ui.setLastLoggedIn(entity.getLastLoggedIn());
        }
        return ui;
    }

    public List<EmployeeUI> toUIEntity (List<User> employees) {
        List<EmployeeUI> uis = new ArrayList<EmployeeUI>();
        for (User employee : employees) {
            uis.add(toUIEntity(employee));
        }
        return uis;
    }

    public Page<EmployeeUI> toUIEntity (Page<User> groups,
                                       Pageable pageable) {
        Page<EmployeeUI> ui = new PageImpl<EmployeeUI>(
                toUIEntity(groups.getContent()), pageable,
                groups.getTotalElements());

        return ui;
    }

    @Override
    public User toPersistenceEntity (EmployeeUI ui) {
        User user = null;
        if (ui != null) {
            user = new User();
            user.setUsername(ui.getUsername());
        }
        return user;
    }
}
