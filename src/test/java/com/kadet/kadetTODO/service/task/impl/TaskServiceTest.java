package com.kadet.kadetTODO.service.task.impl;

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Status;
import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.domain.repo.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

/**
 * @author Alex Soroka
 */
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @Before
    public void init () {
        taskService = new TaskServiceImpl();
        taskService.setTaskRepository(taskRepository);
    }


    /**
     *  CREATE
     */

    @Test
    public void shouldSetOpenedDateToTaskBeforeCreating () {

        // opened date now is null
        Task task = createDefaultTaskWithoutId();
        ArgumentCaptor<Task> argument = ArgumentCaptor.forClass(Task.class);

        taskService.create(task);

        // verify that opened date is not null now
        verify(taskRepository).save(argument.capture());
        assertNotNull(argument.getValue().getOpenedDate());

    }


    /**
     *  UPDATE
     */

    @Test
    public void shouldSetClosedDateIfNewStatusIsClosed () {

        // task with status closed
        Task newTask
                = createTaskWithClosedStatus();
        Task oldTask = createDefaultTask();
        ArgumentCaptor<Task> argument
                = ArgumentCaptor.forClass(Task.class);
        given(taskRepository.findOne(anyLong()))
                .willReturn(oldTask);

        taskService.update(newTask);


        // verify closed date of task for updating as not null
        verify(taskRepository)
                .save(argument.capture());
        assertNotNull(
                argument.getValue().getClosedDate());

    }

    @Test
    public void shouldSetReopenedDateIfNewStatusIsOpenedAndOldStatusIsClosed () {

        // task with status opened
        Task task = createTaskWithOpenedStatus();
        // old task with status closed and not null closed date
        Task oldTask
                = createTaskWithClosedStatusAndClosedDate();
        ArgumentCaptor<Task> argument = ArgumentCaptor.forClass(Task.class);
        given(taskRepository.findOne(anyLong())).willReturn(oldTask);


        taskService.update(task);


        verify(taskRepository).save(argument.capture());
        // verify that reopened date is not null
        assertNotNull(argument.getValue().getReopenedDate());
        // verify that closed date is null
        assertNull(argument.getValue().getClosedDate());
    }

    @Test
    public void shouldReturnNullWithoutId () {

        // Task without id
        Task task = createDefaultTaskWithoutId();

        Task updatedTask = taskService.update(task);

        assertNull(updatedTask);
    }


    /**
     *  DELETE
     */

    @Test
    public void shouldReturnFalseIfTaskWasNotFounded () {

        Task task = createDefaultTask();
        given(taskRepository.findOne(anyLong())).willReturn(null);

        boolean result = taskService.delete(task);

        assertFalse(result);

    }


    /**
     *  util
     */

    private Task createTaskWithClosedStatusAndClosedDate () {
        Task task = createTaskWithClosedStatus();
        task.setClosedDate(new Date());
        return task;
    }

    private Task createTaskWithClosedStatus () {
        Task task = createDefaultTask();
        task.setStatus(Status.CLOSED);
        return task;
    }

    private Task createTaskWithOpenedStatus () {
        Task task = createDefaultTask();
        task.setStatus(Status.OPENED);
        return task;
    }


    private Task createDefaultTaskWithoutId () {
        Task task = new Task();
        task.setTitle("title");
        task.setDescription("desc");
        task.setLevel(Level.TRIVIAL);
        return task;
    }

    private Task createDefaultTask () {
        Task task = createDefaultTaskWithoutId();
        task.setId(2L);
        task.setOpenedDate(new Date());
        return task;
    }

}
