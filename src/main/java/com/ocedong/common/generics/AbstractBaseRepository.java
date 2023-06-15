package com.ocedong.common.generics;

import com.ocedong.common.models.AbstractAuditingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import java.io.Serializable;


public interface AbstractBaseRepository<T extends AbstractAuditingEntity, UUID extends Serializable>
    extends JpaRepository<T, UUID>,QuerydslPredicateExecutor<T> {

}
