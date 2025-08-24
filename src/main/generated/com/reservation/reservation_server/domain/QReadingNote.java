package com.reservation.reservation_server.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReadingNote is a Querydsl query type for ReadingNote
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReadingNote extends EntityPathBase<ReadingNote> {

    private static final long serialVersionUID = -737519071L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReadingNote readingNote = new QReadingNote("readingNote");

    public final QBook book;

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath noteContent = createString("noteContent");

    public final NumberPath<Long> noteId = createNumber("noteId", Long.class);

    public final StringPath noteTag = createString("noteTag");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUser user;

    public QReadingNote(String variable) {
        this(ReadingNote.class, forVariable(variable), INITS);
    }

    public QReadingNote(Path<? extends ReadingNote> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReadingNote(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReadingNote(PathMetadata metadata, PathInits inits) {
        this(ReadingNote.class, metadata, inits);
    }

    public QReadingNote(Class<? extends ReadingNote> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new QBook(forProperty("book")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

