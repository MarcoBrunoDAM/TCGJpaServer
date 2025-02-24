package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
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
public class DistribuidorController {
    @Autowired
    DistribuidoresService distribuidoresService;
//AuthenticationPrincipal UserDetails userDetails
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearDistribuidor(@RequestBody DistribuidoreDto distribuidoreDto,
   @AuthenticationPrincipal UserDetails userDetails) {
//        if(userDetails == null){
//            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
//        }
//        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
//        if(admin.equals("ROLE_true")){
          return ResponseEntity.ok(distribuidoresService.crearDistribuidor(distribuidoreDto));
//        }
//        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

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



    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerListaDistribuidores( @AuthenticationPrincipal UserDetails userDetails) {
//        if(userDetails == null){
//            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
//        }
//        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
//        if(admin.equals("ROLE_true")){
           return ResponseEntity.ok(distribuidoresService.obtenerListaDistribuidores());
//        }
//        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }




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
