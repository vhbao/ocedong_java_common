package com.ocedong.common.generics;

import com.ocedong.common.models.AbstractAuditingEntity;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Component
public abstract class AbstractBaseController<T extends AbstractAuditingEntity, UUID extends Serializable> {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private AbstractBaseServiceImpl<T, UUID> abstractBaseService;
    @Autowired
    public AbstractBaseController(AbstractBaseServiceImpl<T, UUID> abstractBaseService) {
        this.abstractBaseService = abstractBaseService;
    }
    @GetMapping("GetList")
    public ResponseEntity<Object> GetListItems(@RequestParam(defaultValue="0") Integer page, @RequestParam(defaultValue = "20") Integer size,
                                               @RequestParam(required = false) List<String> sorts, Predicate predicates) {
        try
        {

            Object data = abstractBaseService.GetListItems(page, size, sorts, predicates);
            return ResponseEntity.ok().body(data);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("GetOne")
    public ResponseEntity<Object> GetOneItem(@RequestParam(name = "id") UUID id) {
        try
        {
            Object data = abstractBaseService.GetOneItem(id);
            return ResponseEntity.ok().body(data);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Object> InsertItem(@RequestBody T item)
    {
        try
        {
            Object data = abstractBaseService.InsertItem(item);
            return ResponseEntity.ok().body(data);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<Object> UpdateItem(@RequestBody T item)
    {
        try
        {
            Object data = abstractBaseService.UpdateItem(item);
            return ResponseEntity.ok().body(data);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<Object> DeleteItem(@RequestParam(name = "id") UUID id)
    {
        try
        {
            abstractBaseService.DeleteItem(id);
            return ResponseEntity.ok().body(true);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
