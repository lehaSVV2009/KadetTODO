package com.kadet.kadetTODO.persistence.entity.project;

import com.kadet.kadetTODO.persistence.entity.task.QTask;
import com.kadet.kadetTODO.persistence.entity.task.Task;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import java.util.Date;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Created by AlexSoroka on 11/4/2014.
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = 1621585841;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QProject project = new QProject("project");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath description = createString("description");

    public final DateTimePath<Date> createdDate = createDateTime("createdDate", Date.class);

    public final SetPath<Task, QTask> tasks = this.createSet("tasks", Task.class, QTask.class);

    public QProject (String variable) {
        this(Project.class, forVariable(variable), INITS);
    }

    public QProject (PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProject (PathMetadata<?> metadata, PathInits inits) {
        this(Project.class, metadata, inits);
    }

    public QProject (Class<? extends Project> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
    }
}
