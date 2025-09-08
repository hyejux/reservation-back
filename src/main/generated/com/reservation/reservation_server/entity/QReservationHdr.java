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

    public final EnumPath<ReservationHdr.ReservationStatus> isActive = createEnum("isActive", ReservationHdr.ReservationStatus.class);

    public final ListPath<Payment, QPayment> payments = this.<Payment, QPayment>createList("payments", Payment.class, QPayment.class, PathInits.DIRECT2);

    public final QProduct product;

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final QReservationDtl reservationDtl;

    public final ListPath<ReservationHistory, QReservationHistory> reservationHistories = this.<ReservationHistory, QReservationHistory>createList("reservationHistories", ReservationHistory.class, QReservationHistory.class, PathInits.DIRECT2);

    public final NumberPath<Long> reservationId = createNumber("reservationId", Long.class);

    public final StringPath status = createString("status");

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
        this.reservationDtl = inits.isInitialized("reservationDtl") ? new QReservationDtl(forProperty("reservationDtl"), inits.get("reservationDtl")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

