package com.ftc.spring.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftc.spring.api.entitys.Juego;
import com.ftc.spring.api.entitys.Mensaje;
import com.ftc.spring.api.service.JuegoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class JuegoController {

    private final JuegoService juegoService;

    @PostMapping("/juegos/juego")
	ResponseEntity<Mensaje> insertarProducto(@RequestBody Juego juego) {
		return juegoService.save(juego);
	}

	@GetMapping("/juegos") 
	List<Juego> getAllJuegos(@RequestParam(required = false) String developer, @RequestParam(required = false) String title){
		return juegoService.readAllByTitleOrDeveloper(title, developer);
	}

	@GetMapping("/juegos/juego")
	ResponseEntity<?> getJuego(@RequestParam(required = false) String developer,@RequestParam(required = false) String title){
		return juegoService.readByTitleOrDeveloper(title, developer);
	}

	@GetMapping("/juegos/juego/{id}")
	ResponseEntity<?> getJuego(@PathVariable("id") Integer idJuego) {
		return juegoService.readByID(idJuego);
	}

	@PutMapping("/juegos/juego/{id}")
	ResponseEntity<Mensaje> actualizarJuego(@PathVariable("id") Integer idJuego, @RequestBody Juego juego) {
		return juegoService.updateByID(idJuego, juego);
	}

	@DeleteMapping("/juegos/juego/{id}") 
	ResponseEntity<Mensaje> borrarJuego(@PathVariable("id") Integer idJuego) {
		return juegoService.deleteByID(idJuego);
	}

}
