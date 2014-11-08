package com.kadet.kadetTODO.web.controller.employee;

import com.kadet.kadetTODO.service.employee.EmployeeService;
import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.util.extjs.ExtJSResponse;
import com.kadet.kadetTODO.util.extjs.FilterRequest;
import com.kadet.kadetTODO.util.extjs.JsonUtils;
import com.kadet.kadetTODO.web.model.EmployeeUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by AlexSoroka on 11/3/2014.
 */
@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ExtJSResponse<EmployeeUI> extJS;

    private Logger logger = Logger.getLogger(EmployeeController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> list (@RequestParam int page, @RequestParam int start, @RequestParam int limit, @RequestParam(required = false) Object filter) {
        try {

            Pageable pageable = new PageRequest(page - 1, limit);
            Page<EmployeeUI> employees = null;

            List<FilterRequest> filters = new ArrayList<FilterRequest>();

            if (filter != null) {
                filters.addAll(JsonUtils.getListFromJsonArray((String) filter));
            }

            employees = employeeService.findAll(pageable, filters);
            long total = employees.getTotalElements();

            logger.debug("employees : " + employees.getContent());

            return extJS.mapOK(employees.getContent(), total);

        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECTS_RETRIEVE_ERROR);
        }
    }


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, ? extends Object> getProject (@PathVariable("name") String name) {
        try {
            EmployeeUI employeeUI = employeeService.findByUsername(name);
            return extJS.mapOK(employeeUI);
        } catch (Exception e) {
            logger.error(e);
            return extJS.mapError(Strings.PROJECT_RETRIEVE_ERROR);
        }
    }


}
