package com.misionTIC.misionTIC.controllers;

import com.misionTIC.misionTIC.repositories.EquipoRepository;
import com.misionTIC.misionTIC.models.Equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/equipos")
public class EquipoController {
 @Autowired
 EquipoRepository equipoRepository;

 @GetMapping()
 List<Equipo> getEquipos() {
  return this.equipoRepository.findAll();
 }

 @PostMapping()
 Equipo crearEquipo(@RequestBody Equipo equipo) {
  return this.equipoRepository.save(equipo);
 }

}
