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
public class Equipo {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String name;

 @JsonIgnore
 @OneToMany(mappedBy = "local")
 Set<Partido> locales = new HashSet<>();

 @JsonIgnore
 @OneToMany(mappedBy = "visitante")
 Set<Partido> visitantes = new HashSet<>();

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Set<Partido> getLocales() {
  return locales;
 }

 public void setLocales(Set<Partido> locales) {
  this.locales = locales;
 }

 public Set<Partido> getVisitantes() {
  return visitantes;
 }

 public void setVisitantes(Set<Partido> visitantes) {
  this.visitantes = visitantes;
 }

}
