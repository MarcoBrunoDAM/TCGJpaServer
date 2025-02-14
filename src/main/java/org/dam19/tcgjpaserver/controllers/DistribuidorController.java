package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.dto.DistribuidoreDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.DistribuidoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distribuidores")
public class DistribuidorController {
    @Autowired
    DistribuidoresService distribuidoresService;

    @PostMapping
    public ResponseEntity<ResponseModel> crearDistribuidor(@RequestBody DistribuidoreDto distribuidoreDto) {
        return ResponseEntity.ok(distribuidoresService.crearDistribuidor(distribuidoreDto));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerDistribuidorPorID(@PathVariable int id) {
        return ResponseEntity.ok(distribuidoresService.obtenerDistribuidorPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerListaDistribuidores() {
        return ResponseEntity.ok(distribuidoresService.obtenerListaDistribuidores());
    }

}
