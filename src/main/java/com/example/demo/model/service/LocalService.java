/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.dao.LocalRepository;
import com.example.demo.model.entity.LocalEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LocalService {
    @Autowired
    protected LocalRepository repository;

    @Transactional(readOnly = false)
    public void save(LocalEntity entity) throws Exception {
        repository.save(entity);
    }

    @Transactional(readOnly = false)
    public void update(LocalEntity entity) throws Exception {
        repository.update(entity);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception {
        repository.delete(id);
    }

    public LocalEntity findById(Long id) {
        return repository.findById(id);
    }

    public List<LocalEntity> findAllLocal(){
        return repository.findAll();
    }
}
