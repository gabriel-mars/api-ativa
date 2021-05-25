/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.entity.UsuarioEntity;
import com.example.demo.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UsuarioController {
	
    @Autowired
    protected UsuarioService service;

    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestBody UsuarioEntity usuario){
        try {
            usuario = service.findByLogin(usuario.getEmail(), usuario.getSenha());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário e/ou senha incorretos.");
        }
    }
}
