package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreOperationHour is a Querydsl query type for StoreOperationHour
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreOperationHour extends EntityPathBase<StoreOperationHour> {

    private static final long serialVersionUID = -1728415124L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreOperationHour storeOperationHour = new QStoreOperationHour("storeOperationHour");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Byte> dayOfWeek = createNumber("dayOfWeek", Byte.class);

    public final TimePath<java.time.LocalTime> endTime = createTime("endTime", java.time.LocalTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isActive = createString("isActive");

    public final NumberPath<Integer> slotDuration = createNumber("slotDuration", Integer.class);

    public final TimePath<java.time.LocalTime> startTime = createTime("startTime", java.time.LocalTime.class);

    public final QStore store;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QStoreOperationHour(String variable) {
        this(StoreOperationHour.class, forVariable(variable), INITS);
    }

    public QStoreOperationHour(Path<? extends StoreOperationHour> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreOperationHour(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreOperationHour(PathMetadata metadata, PathInits inits) {
        this(StoreOperationHour.class, metadata, inits);
    }

    public QStoreOperationHour(Class<? extends StoreOperationHour> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store")) : null;
    }

}

