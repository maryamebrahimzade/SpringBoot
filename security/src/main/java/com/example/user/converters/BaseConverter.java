package com.example.user.converters;

public interface BaseConverter<D,E> {
    E convertDto(D d);
    D convertEntity(E e);

}
