/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.service;

import com.example.demo.model.dao.UsuarioRepository;
import com.example.demo.model.entity.UsuarioEntity;
import com.example.demo.model.utils.SecurityGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsuarioService {
	
    @Autowired
    protected UsuarioRepository repository;

    public UsuarioEntity findByLogin(String email, String senha) {
        senha = SecurityGeneric.getSecurePassword(senha);
        System.out.println(senha);
        return repository.findByLogin(email, senha);
    }
    
    public UsuarioEntity findByToken(String token) { return repository.findByToken(token); }
}
