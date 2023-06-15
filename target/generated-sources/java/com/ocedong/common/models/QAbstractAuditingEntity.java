package com.ocedong.common.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractAuditingEntity is a Querydsl query type for AbstractAuditingEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAbstractAuditingEntity extends EntityPathBase<AbstractAuditingEntity> {

    private static final long serialVersionUID = 1069550227L;

    public static final QAbstractAuditingEntity abstractAuditingEntity = new QAbstractAuditingEntity("abstractAuditingEntity");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.Instant> createdDate = createDateTime("createdDate", java.time.Instant.class);

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final DateTimePath<java.time.Instant> lastModifiedDate = createDateTime("lastModifiedDate", java.time.Instant.class);

    public final StringPath tenantCode = createString("tenantCode");

    public QAbstractAuditingEntity(String variable) {
        super(AbstractAuditingEntity.class, forVariable(variable));
    }

    public QAbstractAuditingEntity(Path<? extends AbstractAuditingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractAuditingEntity(PathMetadata metadata) {
        super(AbstractAuditingEntity.class, metadata);
    }

}

