package com.example.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<R extends JpaRepository<E,Long>,E> {
    @Autowired
    protected R repository;
}
