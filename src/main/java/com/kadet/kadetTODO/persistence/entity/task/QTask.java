package com.kadet.kadetTODO.persistence.entity.task;

import com.kadet.kadetTODO.persistence.entity.project.QProject;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import java.util.Date;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Created by AlexSoroka on 11/8/2014.
 */
public class QTask extends EntityPathBase<Task>  {

    private static final long serialVersionUID = -2010828676;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QTask task = new QTask("task");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final StringPath description = createString("description");

    public final DateTimePath<Date> openedDate = createDateTime("openedDate", Date.class);

    public final DateTimePath<Date> modifiedDate = createDateTime("modifiedDate", Date.class);

    public final DateTimePath<Date> resolvedDate = createDateTime("resolvedDate", Date.class);

    public final DateTimePath<Date> closedDate = createDateTime("closedDate", Date.class);

    public final DateTimePath<Date> reopenedDate = createDateTime("reopenedDate", Date.class);

    public final DateTimePath<Date> removedDate = createDateTime("removedDate", Date.class);

    public final StringPath level = createString("level");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final QProject project;

    public QTask (String variable) {
        this(Task.class, forVariable(variable), INITS);
    }

    public QTask (PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTask (PathMetadata<?> metadata, PathInits inits) {
        this(Task.class, metadata, inits);
    }

    public QTask (Class<? extends Task> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}
