package com.kadet.kadetTODO.web.controller;

import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.domain.repo.TaskRepository;
import com.kadet.kadetTODO.service.task.impl.TaskServiceImpl;
import com.kadet.kadetTODO.util.mapper.TaskMapper;
import com.kadet.kadetTODO.web.controller.task.TaskController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Alex Soroka
 */
public class TaskControllerTest {


 /*   private TaskController taskController;

    @Mock
    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @Before
    public void init () {
        taskController = new TaskController();
        taskController.setTaskService(taskService);
        taskController.setTaskMapper(taskMapper);
    }
*/


/*

    @Test
    public void findAll () {
        List<Task> persons = new ArrayList<Task>();
        when(taskRepository.findAll(any(Sort.class))).thenReturn(persons);

        List<Task> returned = taskService.findAll();

        ArgumentCaptor<Sort> sortArgument = ArgumentCaptor.forClass(Sort.class);
        verify(taskRepository, times(1)).findAll(sortArgument.capture());

        verifyNoMoreInteractions(taskRepository);

        Sort actualSort = sortArgument.getValue();
        assertEquals(Sort.Direction.ASC, actualSort.getOrderFor("lastName").getDirection());

        assertEquals(persons, returned);
    }
*/

}
