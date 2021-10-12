package com.misionTIC.misionTIC.repositories;

import com.misionTIC.misionTIC.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
