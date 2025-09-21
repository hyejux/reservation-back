package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationHdr is a Querydsl query type for ReservationHdr
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationHdr extends EntityPathBase<ReservationHdr> {

    private static final long serialVersionUID = 1970851436L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationHdr reservationHdr = new QReservationHdr("reservationHdr");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final BooleanPath isActive = createBoolean("isActive");

    public final QProduct product;

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final EnumPath<com.reservation.reservation_server.common.ReservationStatus> status = createEnum("status", com.reservation.reservation_server.common.ReservationStatus.class);

    public final QStore store;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final TimePath<java.time.LocalTime> time = createTime("time", java.time.LocalTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QReservationHdr(String variable) {
        this(ReservationHdr.class, forVariable(variable), INITS);
    }

    public QReservationHdr(Path<? extends ReservationHdr> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationHdr(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationHdr(PathMetadata metadata, PathInits inits) {
        this(ReservationHdr.class, metadata, inits);
    }

    public QReservationHdr(Class<? extends ReservationHdr> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

