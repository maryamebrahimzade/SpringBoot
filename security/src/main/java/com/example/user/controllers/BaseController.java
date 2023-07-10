package com.example.user.controllers;

import com.example.user.converters.BaseConverter;
import com.example.user.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseController<E, D, S extends BaseService<? extends JpaRepository<E, Long>, E>> {
    @Autowired
    private S service;
    @Autowired
    private BaseConverter<D,E> converter;

}
