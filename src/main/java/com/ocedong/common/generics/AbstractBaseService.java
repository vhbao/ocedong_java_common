package com.ocedong.common.generics;

import com.ocedong.common.models.AbstractAuditingEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface AbstractBaseService<T extends AbstractAuditingEntity, UUID extends Serializable>{
    public abstract Page<T> GetListItems(Integer page, Integer size, List<String> sorts, Predicate predicates);
    public abstract T GetOneItem(UUID id);
    public abstract T InsertItem (T item);
    public abstract T UpdateItem (T item);
    public void DeleteItem(UUID id);
}
