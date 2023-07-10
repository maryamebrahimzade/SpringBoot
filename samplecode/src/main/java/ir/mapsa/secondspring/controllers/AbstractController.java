package ir.mapsa.secondspring.controllers;

import ir.mapsa.secondspring.Converters.BaseConverter;
import ir.mapsa.secondspring.exceptions.ServiceException;
import ir.mapsa.secondspring.services.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<E, D> {
    @Autowired
    private AbstractService<? extends JpaRepository<E, Long>, E> service;
    @Autowired
    private BaseConverter<D, E> converter;
    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @PostMapping
    public void add(@Validated @RequestBody D e) throws ServiceException {
        logger.info("method call");
        logger.info("parameters add");
        service.add(converter.convertDto(e));
    }

    @PutMapping
    public void update(@Valid @RequestBody D e) throws ServiceException {
        service.update(converter.convertDto(e));
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id) throws ServiceException {
        service.removeById(id);
    }

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) throws ServiceException {
        return converter.convertEntity(service.findById(id).get());
    }

    @GetMapping
    public List<D> findAll() throws Exception {
        return converter.convertEntity(service.findAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@PathVariable D e) throws ServiceException {
        return converter.convertEntity(this.service.findByExample(converter.convertDto(e)));
    }
}
