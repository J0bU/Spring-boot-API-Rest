package com.misionTIC.misionTIC.models;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;

 @JsonIgnore
 @OneToMany(mappedBy = "usuario")
 Set<Partido> partidos = new HashSet<>();

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public Set<Partido> getPartidos() {
  return partidos;
 }

 public void setPartidos(Set<Partido> partidos) {
  this.partidos = partidos;
 }

}
