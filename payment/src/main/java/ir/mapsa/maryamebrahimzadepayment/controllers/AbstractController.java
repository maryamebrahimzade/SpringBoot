package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.converters.BaseConverter;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional(readOnly = true)
public abstract class AbstractController<E,D,S extends AbstractService<? extends JpaRepository<E,Long>,E> > {
    @Autowired
    private S service;
    @Autowired
    private BaseConverter<D,E> converter;

    @PostMapping
    @Transactional
    public void add(@RequestBody D e) throws ServiceException {
        service.add(converter.convertDto(e));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody D e) throws ServiceException{
        service.update(converter.convertDto(e));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removeById(@PathVariable("id") Long id) throws ServiceException{
        service.removeById(id);
    }

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) throws ServiceException{
       return converter.convertEntity(service.findById(id).get());
    }

    @GetMapping
    public List<D> getAll() throws ServiceException{
        return converter.convertEntity(service.getAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@RequestBody D e) throws ServiceException{
        return converter.convertEntity(service.findByExample(converter.convertDto(e)));
    }

}
