package com.ocedong.common.helpers;

import org.springframework.beans.BeanUtils;

public class ObjectHelper {
    public static void CopyProperties(Object source, Object target)
    {
        String[] ignoreProperties = {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"};
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }
}
