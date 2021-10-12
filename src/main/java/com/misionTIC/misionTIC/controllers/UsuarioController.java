package com.misionTIC.misionTIC.controllers;

import com.misionTIC.misionTIC.repositories.UsuarioRepository;

import java.util.List;
import com.misionTIC.misionTIC.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

 @Autowired
 UsuarioRepository usuarioRepository;

 @GetMapping()
 public List<Usuario> getUsuarios() {
  return this.usuarioRepository.findAll();
 }

 @PostMapping()
 Usuario creatUsuario(@RequestBody Usuario usuario) {
  return this.usuarioRepository.save(usuario);
 }

}