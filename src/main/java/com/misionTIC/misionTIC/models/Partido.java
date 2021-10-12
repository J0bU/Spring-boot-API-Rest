package com.misionTIC.misionTIC.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Partido {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String nombre;
 private Date fecha;
 private int golesLocal;
 private int golesVisitante;

 @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
 @JoinColumn(name = "usuario_id", referencedColumnName = "id")
 private Usuario usuario;

 @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
 @JoinColumn(name = "equipo_local", referencedColumnName = "id")
 private Equipo local;

 @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
 @JoinColumn(name = "equipo_visitante", referencedColumnName = "id")
 private Equipo visitante;

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

 public Usuario getUsuario() {
  return usuario;
 }

 public void setUsuario(Usuario usuario) {
  this.usuario = usuario;
 }

 public Equipo getLocal() {
  return local;
 }

 public void setLocal(Equipo local) {
  this.local = local;
 }

 public Equipo getVisitante() {
  return visitante;
 }

 public void setVisitante(Equipo visitante) {
  this.visitante = visitante;
 }

 public Date getFecha() {
  return fecha;
 }

 public void setFecha(Date fecha) {
  this.fecha = fecha;
 }

 public int getGolesLocal() {
  return golesLocal;
 }

 public void setGolesLocal(int golesLocal) {
  this.golesLocal = golesLocal;
 }

 public int getGolesVisitante() {
  return golesVisitante;
 }

 public void setGolesVisitante(int golesVisitante) {
  this.golesVisitante = golesVisitante;
 }

}
