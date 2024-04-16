package com.ftc.spring.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftc.spring.api.entitys.Usuario;

@Repository
@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByNombre(String userName);

}
