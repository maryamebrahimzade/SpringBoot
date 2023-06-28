package com.trans.telepardaz.mappers;


import com.trans.telepardaz.exceptions.ServiceException;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<D,E>{
    E convertDto(D d) throws ServiceException;
    D convertEntity(E e);

    default List<E> convertDto(List<D> dList){
        if(dList!=null){
            return dList.stream()
                    .map(i-> {
                        try {
                            return convertDto(i);
                        } catch (ServiceException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEntity(List<E> eList){
        if(eList!=null){
            return eList.stream()
                    .map(i-> convertEntity(i))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
