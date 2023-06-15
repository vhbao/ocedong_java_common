package com.ocedong.common.generics;

import com.ocedong.common.helpers.ObjectHelper;
import com.ocedong.common.models.AbstractAuditingEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AbstractBaseServiceImpl<T extends AbstractAuditingEntity, UUID extends Serializable>
    implements AbstractBaseService<T, UUID> {

    private AbstractBaseRepository<T, UUID> abstractBaseRepository;

    @Autowired
    public AbstractBaseServiceImpl(AbstractBaseRepository<T, UUID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }
    public Page<T> GetListItems(Integer page, Integer size, List<String> sorts, Predicate predicates) {
        List<Order> orders = new ArrayList<Order>();
        if(sorts != null) {
            for(int i = 0;i < sorts.size();i++) {
                String[] item = sorts.get(i).split("-");
                String column = item[0], direction = item[1];
                if(direction.toLowerCase().equals("asc")) {
                    orders.add(new Order(Sort.Direction.ASC, column));
                }
                else if(direction.toLowerCase().equals("desc")) {
                    orders.add(new Order(Sort.Direction.DESC, column));
                }
            }
        }
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(orders));
        Page<T> result = abstractBaseRepository.findAll(predicates, pageRequest);
        return result;
    }
    public T GetOneItem(UUID id) {
        T result = abstractBaseRepository.findById(id).orElse(null);
        return result;
    }
    public T InsertItem(T item) {
        T result = abstractBaseRepository.save(item);
        return result;
    }
    public T UpdateItem(T item) {
        T itemSource = abstractBaseRepository.findById((UUID) item.getId()).orElse(null);
        ObjectHelper.CopyProperties(item, itemSource);
        T result = abstractBaseRepository.save(itemSource);
        return result;
    }
    public void DeleteItem(UUID id) {
        abstractBaseRepository.deleteById(id);
    }
}
