package com.kadet.kadetTODO.util.mapper;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
public interface Mapper<U, E> {

    U toUIEntity (E entity);
    E toPersistenceEntity (U ui);

}
