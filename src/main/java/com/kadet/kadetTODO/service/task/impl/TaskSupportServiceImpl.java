package com.kadet.kadetTODO.service.task.impl;

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.service.task.TaskSupportService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Soroka
 */
@Service
public class TaskSupportServiceImpl implements TaskSupportService {

    private Logger logger = Logger.getLogger(TaskSupportServiceImpl.class);

    /**
     * @see com.kadet.kadetTODO.service.task.TaskSupportService
     */
    @Override
    public List<String> getAllLevels () {
        List<String> levels = new ArrayList<String>();
        for (Level level : Level.values()) {
            levels.add(level.name());
        }
        return levels;
    }


    /**
     * @see com.kadet.kadetTODO.service.task.TaskSupportService
     */
    @Override
    public List<String> getAllStatuses () {
        List<String> statuses = new ArrayList<String>();
        for (Status status : Status.values()) {
            statuses.add(status.name());
        }
        return statuses;
    }

}
