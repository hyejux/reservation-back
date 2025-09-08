package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationHistory is a Querydsl query type for ReservationHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationHistory extends EntityPathBase<ReservationHistory> {

    private static final long serialVersionUID = 1595962634L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationHistory reservationHistory = new QReservationHistory("reservationHistory");

    public final DateTimePath<java.time.LocalDateTime> changedAt = createDateTime("changedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> changedBy = createNumber("changedBy", Long.class);

    public final NumberPath<Long> historyId = createNumber("historyId", Long.class);

    public final StringPath reason = createString("reason");

    public final QReservationHdr reservationHdr;

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final StringPath statusAfter = createString("statusAfter");

    public final StringPath statusBefore = createString("statusBefore");

    public QReservationHistory(String variable) {
        this(ReservationHistory.class, forVariable(variable), INITS);
    }

    public QReservationHistory(Path<? extends ReservationHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationHistory(PathMetadata metadata, PathInits inits) {
        this(ReservationHistory.class, metadata, inits);
    }

    public QReservationHistory(Class<? extends ReservationHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservationHdr = inits.isInitialized("reservationHdr") ? new QReservationHdr(forProperty("reservationHdr"), inits.get("reservationHdr")) : null;
    }

}

