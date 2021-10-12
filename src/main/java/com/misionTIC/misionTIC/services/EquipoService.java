package com.misionTIC.misionTIC.services;

import com.misionTIC.misionTIC.repositories.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
 @Autowired
 EquipoRepository equipoRepository;

 public boolean eliminarPartido(Long id) {
  try {
   equipoRepository.deleteById(id);
   return true;
  } catch (Exception error) {
   return false;
  }
 }

}
