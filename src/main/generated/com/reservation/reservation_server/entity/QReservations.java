package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservations is a Querydsl query type for Reservations
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservations extends EntityPathBase<Reservations> {

    private static final long serialVersionUID = 2111545737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservations reservations = new QReservations("reservations");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath customerName = createString("customerName");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> reservationTime = createDateTime("reservationTime", java.time.LocalDateTime.class);

    public final StringPath status = createString("status");

    public final QStore store;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QReservations(String variable) {
        this(Reservations.class, forVariable(variable), INITS);
    }

    public QReservations(Path<? extends Reservations> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservations(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservations(PathMetadata metadata, PathInits inits) {
        this(Reservations.class, metadata, inits);
    }

    public QReservations(Class<? extends Reservations> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
    }

}

