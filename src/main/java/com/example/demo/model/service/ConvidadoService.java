/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.dao.ConvidadoRepository;
import com.example.demo.model.entity.ConvidadoEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConvidadoService {

    @Autowired
    protected ConvidadoRepository repository;

    @Transactional(readOnly = false)
    public void save(ConvidadoEntity entity) throws Exception {
        repository.save(entity);
    }

    @Transactional(readOnly = false)
    public void update(ConvidadoEntity entity) throws Exception {
        repository.update(entity);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception {
        repository.delete(id);
    }

    public ConvidadoEntity findById(Long id) {
        return repository.findById(id);
    }

    public List<ConvidadoEntity> findAllConvidado(){
        return repository.findAll();
    }
}
