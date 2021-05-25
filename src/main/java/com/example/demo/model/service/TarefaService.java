/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.dao.TarefaRepository;
import com.example.demo.model.entity.TarefaEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TarefaService {

    @Autowired
    protected TarefaRepository repository;

    @Transactional(readOnly = false)
    public void save(TarefaEntity entity) throws Exception {
        repository.save(entity);
    }

    @Transactional(readOnly = false)
    public void update(TarefaEntity entity) throws Exception {
        repository.update(entity);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception {
        repository.delete(id);
    }

    public TarefaEntity findById(Long id) {
        return repository.findById(id);
    }

    public List<TarefaEntity> findAllLocal(){
        return repository.findAll();
    }
}
