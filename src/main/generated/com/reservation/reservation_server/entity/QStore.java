package com.reservation.reservation_server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -1915373633L;

    public static final QStore store = new QStore("store");

    public final StringPath address = createString("address");

    public final StringPath bizRegistrationNum = createString("bizRegistrationNum");

    public final StringPath category = createString("category");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    public final BooleanPath isActive = createBoolean("isActive");

    public final StringPath name = createString("name");

    public final ListPath<StoreOperationHour, QStoreOperationHour> operationHours = this.<StoreOperationHour, QStoreOperationHour>createList("operationHours", StoreOperationHour.class, QStoreOperationHour.class, PathInits.DIRECT2);

    public final StringPath ownerName = createString("ownerName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<Product, QProduct> product = this.<Product, QProduct>createList("product", Product.class, QProduct.class, PathInits.DIRECT2);

    public final EnumPath<com.reservation.reservation_server.common.RoleType> role = createEnum("role", com.reservation.reservation_server.common.RoleType.class);

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

