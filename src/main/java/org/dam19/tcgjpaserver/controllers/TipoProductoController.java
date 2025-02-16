package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.dto.TipoProductoDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo_producto")
public class TipoProductoController {
    @Autowired
    TipoProductoService tipoProductoService;
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearTipoProducto(@RequestBody TipoProductoDto tipoProductoDto) {
        return ResponseEntity.ok(tipoProductoService.crearTipoProducto(tipoProductoDto));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorID(@PathVariable int id) {
        return ResponseEntity.ok(tipoProductoService.obtenerTipoProductoPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerTodosProductos(){
        return ResponseEntity.ok(tipoProductoService.obtenerListaTipoProductos());
    }
}
