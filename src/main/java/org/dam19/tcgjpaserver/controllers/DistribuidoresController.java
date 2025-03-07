package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.DistribuidoreDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.DistribuidoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distribuidores")
public class DistribuidoresController {
    @Autowired
    DistribuidoresService distribuidoresService;
    //AuthenticationPrincipal UserDetails userDetails
    //Este metodo permite crear un distribuidor.
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearDistribuidor(@RequestBody DistribuidoreDto distribuidoreDto,
                                                           @AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
        return ResponseEntity.ok(distribuidoresService.crearDistribuidor(distribuidoreDto));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
    //Este metodo permite obtener un distribuidor determinado a traves de su id.
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerDistribuidorPorID(@PathVariable int id,
                                                                  @AuthenticationPrincipal UserDetails userDetails){
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
           return ResponseEntity.ok(distribuidoresService.obtenerDistribuidorPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    //Este metodo permite obtener todos los distribuidores existentes en la BBDD.
    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerListaDistribuidores( @AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
        return ResponseEntity.ok(distribuidoresService.obtenerListaDistribuidores());
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    //Este metodo pemite borrar un distribuidor determinado a traves de su id.
    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarDistribuidorPorId(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")){
            return ResponseEntity.ok(distribuidoresService.eliminarDistribuidorPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
}