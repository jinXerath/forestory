package com.forestory.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QForestory is a Querydsl query type for Forestory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QForestory extends EntityPathBase<Forestory> {

    private static final long serialVersionUID = -1711789807L;

    public static final QForestory forestory = new QForestory("forestory");

    public final StringPath forestoryContent = createString("forestoryContent");

    public final NumberPath<Long> forestoryNo = createNumber("forestoryNo", Long.class);

    public final NumberPath<Integer> forestoryReadcnt = createNumber("forestoryReadcnt", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> forestoryRegdate = createDateTime("forestoryRegdate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> forestoryReplycnt = createNumber("forestoryReplycnt", Integer.class);

    public final StringPath forestoryTitle = createString("forestoryTitle");

    public final DateTimePath<java.time.LocalDateTime> forestoryUptdate = createDateTime("forestoryUptdate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> forestroyLikecnt = createNumber("forestroyLikecnt", Integer.class);

    public QForestory(String variable) {
        super(Forestory.class, forVariable(variable));
    }

    public QForestory(Path<? extends Forestory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QForestory(PathMetadata metadata) {
        super(Forestory.class, metadata);
    }

}

