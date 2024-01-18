package com.forestory.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -1213660610L;

    public static final QBoard board = new QBoard("board");

    public final StringPath boardCategory = createString("boardCategory");

    public final StringPath boardContent = createString("boardContent");

    public final NumberPath<Long> boardNo = createNumber("boardNo", Long.class);

    public final NumberPath<Integer> boardReadcnt = createNumber("boardReadcnt", Integer.class);

    public final DatePath<java.util.Date> boardRegdate = createDate("boardRegdate", java.util.Date.class);

    public final StringPath boardTitle = createString("boardTitle");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

