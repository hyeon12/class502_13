package org.hyeon.day90.board.constants;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardData is a Querydsl query type for BoardData
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardData extends EntityPathBase<BoardData> {

    private static final long serialVersionUID = -1451136759L;

    public static final QBoardData boardData = new QBoardData("boardData");

    public final org.hyeon.day90.global.constants.QBaseEntity _super = new org.hyeon.day90.global.constants.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath poster = createString("poster");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath subject = createString("subject");

    public QBoardData(String variable) {
        super(BoardData.class, forVariable(variable));
    }

    public QBoardData(Path<? extends BoardData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardData(PathMetadata metadata) {
        super(BoardData.class, metadata);
    }

}

