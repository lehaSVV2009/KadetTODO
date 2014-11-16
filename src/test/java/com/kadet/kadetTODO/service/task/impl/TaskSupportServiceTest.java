package com.kadet.kadetTODO.service.task.impl;

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.service.task.TaskSupportService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Soroka
 */
public class TaskSupportServiceTest {

    private TaskSupportService taskSupportService;

    @Before
    public void init () {
        taskSupportService = new TaskSupportServiceImpl();
    }

    @Test
    public void shouldReturnSuchLevels () {

        List<String> levels = Arrays.asList(
                Level.BLOCKER.name(),
                Level.CRITICAL.name(),
                Level.MAJOR.name(),
                Level.MINOR.name(),
                Level.TRIVIAL.name()
        );

        assertEquals(levels, taskSupportService.getAllLevels());
    }


    @Test
    public void shouldReturnSuchStatuses () {

        List<String> statuses = Arrays.asList(
                Status.OPENED.name(),
                Status.CLOSED.name()
        );

        assertEquals(statuses, taskSupportService.getAllStatuses());
    }


}
