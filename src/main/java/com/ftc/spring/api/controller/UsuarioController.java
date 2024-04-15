package com.ftc.spring.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftc.spring.api.entitys.Mensaje;
import com.ftc.spring.api.entitys.Usuario;
import com.ftc.spring.api.service.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/users/usuario") 
	ResponseEntity<Mensaje> create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

    @GetMapping("/users/usuario/{correo}") 
	ResponseEntity<?> read(@PathVariable("correo") String correoUsuario) {
		return usuarioService.read(correoUsuario);
	}

    @PutMapping("/users/usuario/{correo}") 
	ResponseEntity<Mensaje> update(@PathVariable("correo") String correoUsuario, @RequestBody Usuario usuario) {
		return usuarioService.update(correoUsuario, usuario);
	}

    @DeleteMapping("/users/usuario/{correo}") 
	ResponseEntity<Mensaje> delete(@PathVariable("correo") String correoUsuario) {
        return usuarioService.delete(correoUsuario);
	}

}
