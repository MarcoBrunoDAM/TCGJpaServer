package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.ColeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colecciones")
public class ColeccionController {
    @Autowired
    private ColeccionService coleccionService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearColeccion(@RequestBody ColeccionDto coleccionDto) {
        return ResponseEntity.ok(coleccionService.crearColeccion(coleccionDto));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorID(@PathVariable int id) {
        return ResponseEntity.ok(coleccionService.obtenerColeccionPorId(id));
    }
}
