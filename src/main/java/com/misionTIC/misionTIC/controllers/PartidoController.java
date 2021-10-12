package com.misionTIC.misionTIC.controllers;

import com.misionTIC.misionTIC.repositories.EquipoRepository;
import com.misionTIC.misionTIC.repositories.PartidoRepository;
import com.misionTIC.misionTIC.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import com.misionTIC.misionTIC.models.Equipo;
import com.misionTIC.misionTIC.models.Partido;
import com.misionTIC.misionTIC.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/partidos")
public class PartidoController {

  @Autowired
  PartidoRepository partidoRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  EquipoRepository equipoRepository;

  // @Autowired
  // EquipoService equipoService;

  @GetMapping()
  List<Partido> getPartidos() {
    return this.partidoRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  Optional<Partido> obtenerPorId(@PathVariable Long id) {
    return partidoRepository.findById(id);
  }

  @PostMapping()
  Partido crearPartido(@RequestBody Partido partido) {
    return this.partidoRepository.save(partido);
  }

  @PutMapping("{partidoId}/usuario/{usuarioId}")
  Partido asignarUsuarioAlPartido(@PathVariable Long partidoId, @PathVariable Long usuarioId) {
    Partido partido = partidoRepository.findById(partidoId).get();
    Usuario usuario = usuarioRepository.findById(usuarioId).get();
    partido.setUsuario(usuario);

    return this.partidoRepository.save(partido);
  }

  @PutMapping("{partidoId}/equipol/{equipoLocalId}/equipov/{equipoVisitanteId}")
  Partido asignarEquiposAlPartido(@PathVariable Long partidoId, @PathVariable Long equipoLocalId,
      @PathVariable Long equipoVisitanteId) {
    Partido partido = partidoRepository.findById(partidoId).get();
    Equipo equipoLocal = equipoRepository.findById(equipoLocalId).get();
    Equipo equipoVisitante = equipoRepository.findById(equipoVisitanteId).get();
    partido.setLocal(equipoLocal);
    partido.setVisitante(equipoVisitante);

    return this.partidoRepository.save(partido);
  }

  // @DeleteMapping(path = "/{id}")
  // public String eliminarPorId(@PathVariable("id") Long id) {
  // boolean ok = equipoService.eliminarPartido(id);
  // if (ok) {
  // return "Se logró eliminar el partido con id " + id;
  // } else {
  // return "No se logró eliminar el partido con id " + id;
  // }
  // }

  // @DeleteMapping(path = "/{id}")
  // public boolean eliminarPorId(@PathVariable("id") Long id) {
  // try {
  // System.out.println(id);
  // equipoRepository.deleteById(id);
  // return true;

  // } catch (Exception err) {
  // System.out.println(err);
  // return false;
  // }
  // }
}
