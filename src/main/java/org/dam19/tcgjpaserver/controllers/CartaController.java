package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.CartaDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartas")
public class CartaController {
    @Autowired
    CartaService cartaService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearCarta(@RequestBody CartaDto cartaDto) {
        return ResponseEntity.ok(cartaService.crearCarta(cartaDto));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorID(@PathVariable int id) {
        return ResponseEntity.ok(cartaService.obtenerCartaPorId(id));
    }

    @GetMapping("/todas")
    public ResponseEntity<ResponseModel> obtenerTodasColecciones(){
        return ResponseEntity.ok(cartaService.obtenerListaCartas());
    }
}
