package com.kadet.kadetTODO.service.task;

import java.util.List;

/**
 * Supports the TaskService
 * Provides all levels and statuses (list of strings)
 *
 * @author Alex Soroka
 */
public interface TaskSupportService {

    /**
     *  Get all String values of Task Level
     */
    public List<String> getAllLevels ();

    /**
     *  Get all String values of Task Status
     */
    public List<String> getAllStatuses ();

}
