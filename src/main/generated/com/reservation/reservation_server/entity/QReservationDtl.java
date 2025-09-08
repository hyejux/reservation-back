package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationDtl is a Querydsl query type for ReservationDtl
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationDtl extends EntityPathBase<ReservationDtl> {

    private static final long serialVersionUID = 1970848082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationDtl reservationDtl = new QReservationDtl("reservationDtl");

    public final StringPath cancellationPolicy = createString("cancellationPolicy");

    public final QReservationHdr reservationHdr;

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final StringPath specialRequests = createString("specialRequests");

    public QReservationDtl(String variable) {
        this(ReservationDtl.class, forVariable(variable), INITS);
    }

    public QReservationDtl(Path<? extends ReservationDtl> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationDtl(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationDtl(PathMetadata metadata, PathInits inits) {
        this(ReservationDtl.class, metadata, inits);
    }

    public QReservationDtl(Class<? extends ReservationDtl> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservationHdr = inits.isInitialized("reservationHdr") ? new QReservationHdr(forProperty("reservationHdr"), inits.get("reservationHdr")) : null;
    }

}

