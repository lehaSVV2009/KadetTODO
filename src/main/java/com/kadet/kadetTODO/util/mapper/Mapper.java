package com.kadet.kadetTODO.util.mapper;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Interface for transforming ExtJS view model to persistence entity and vice versa
 *
 * @author Alex Soroka
 */
public interface Mapper<U, E> {

    /**
     *
     *  From persistence entity to view model
     *
     */
    U toUIEntity (E entity);

    /**
     *
     *  From view model to persistence entity
     *
     */
    E toPersistenceEntity (U ui);

}
