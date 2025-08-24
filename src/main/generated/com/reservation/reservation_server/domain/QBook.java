package com.reservation.reservation_server.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = -1968600378L;

    public static final QBook book = new QBook("book");

    public final StringPath bookAuthor = createString("bookAuthor");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final StringPath bookPublisher = createString("bookPublisher");

    public final NumberPath<Integer> bookRating = createNumber("bookRating", Integer.class);

    public final StringPath bookStatus = createString("bookStatus");

    public final StringPath bookThumbnail = createString("bookThumbnail");

    public final StringPath bookTitle = createString("bookTitle");

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

