package com.kadet.kadetTODO.web.controller;

/**
 * @author Alex Soroka
 */
public class TaskControllerTest {

    /*
    * @Test
    public void findAll() {
        List<Person> persons = new ArrayList<Person>();
        when(personRepositoryMock.findAll(any(Sort.class))).thenReturn(persons);

        List<Person> returned = personService.findAll();

        ArgumentCaptor<Sort> sortArgument = ArgumentCaptor.forClass(Sort.class);
        verify(personRepositoryMock, times(1)).findAll(sortArgument.capture());

        verifyNoMoreInteractions(personRepositoryMock);

        Sort actualSort = sortArgument.getValue();
        assertEquals(Sort.Direction.ASC, actualSort.getOrderFor("lastName").getDirection());

        assertEquals(persons, returned);
    }*/

}
