package com.kadet.kadetTODO.util.mapper;

/**
 * Date: 11.11.2014
 * Time: 10:37
 *
 *  Interface for transforming ExtJS view to to persistence entity and vice versa
 *
 * @author Alex Soroka
 */
// TODO: make by Reflection
public interface Mapper<U, E> {

    /**
     *
     *  From persistence entity to view to
     *
     */
    U toUIEntity (E entity);

    /**
     *
     *  From view to to persistence entity
     *
     */
    E toPersistenceEntity (U ui);

}
