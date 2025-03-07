package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.dto.TipoProductoDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo_producto")
public class TipoProductoController {
    @Autowired
    TipoProductoService tipoProductoService;
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearTipoProducto(@RequestBody TipoProductoDto tipoProductoDto,
                                                           @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
        return ResponseEntity.ok(tipoProductoService.crearTipoProducto(tipoProductoDto));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

//Hola

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorID(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
            return ResponseEntity.ok(tipoProductoService.obtenerTipoProductoPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerTodosProductos(@AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
            return ResponseEntity.ok(tipoProductoService.obtenerListaTipoProductos());
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }




    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarTipoProductoPorId(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
            return ResponseEntity.ok(tipoProductoService.eliminarTipoProductoPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


}
