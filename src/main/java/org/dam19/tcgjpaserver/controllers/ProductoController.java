package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.CartaDto;
import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearProducto(@RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.crearProducto(productoDto));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorID(@PathVariable int id) {
        return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerTodosProductos(){
        return ResponseEntity.ok(productoService.obtenerListaProductos());
    }

    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminaProductoPorId(@PathVariable int id) {
        return ResponseEntity.ok(productoService.eliminarProductoPorId(id));
    }

}
