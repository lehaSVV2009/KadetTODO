package com.kadet.kadetTODO.util.mapper;

import com.kadet.kadetTODO.domain.entity.task.Level;
import com.kadet.kadetTODO.domain.entity.task.Task;
import com.kadet.kadetTODO.web.to.TaskTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alex Soroka
 */
public class TaskMapperTest {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void shouldCreateTaskTOFromTask () {

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Blabla");
        task.setDescription("Blabla \nDesc");
        task.setLevel(Level.BLOCKER);

        TaskTO taskTO = taskMapper.toUIEntity(task);

        Assert.assertNotNull(taskTO);

    }

    @Test
    public void shouldCreateNullFromTaskWithoutId () {

        Task task = new Task();

        TaskTO taskTO = taskMapper.toUIEntity(task);

        Assert.assertNull(taskTO);

    }


    @Test
    public void shouldCreateTaskFromTaskTO () {

        TaskTO taskTO = new TaskTO();
        taskTO.setId(1L);
        taskTO.setTitle("Blabla");
        taskTO.setDescription("Blabla \nDesc");
        taskTO.setLevel("BLOCKER");

        Task task = taskMapper.toPersistenceEntity(taskTO);

        Assert.assertNotNull(task);

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLevelHasWrongValue () {

        TaskTO taskTO = new TaskTO();
        String wrongLevel = "wrongValue";
        taskTO.setId(1L);
        taskTO.setLevel(wrongLevel);

        taskMapper.toPersistenceEntity(taskTO);

    }



}
