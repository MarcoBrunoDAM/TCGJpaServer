package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.CartaDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartas")
public class CartaController {
    @Autowired
    CartaService cartaService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearCarta(@RequestBody CartaDto cartaDto,
                                                    @AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if (admin.equals("ROLE_true")) {
            return ResponseEntity.ok(cartaService.crearCarta(cartaDto));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }




    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorID(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if (admin.equals("ROLE_true")) {
            return ResponseEntity.ok(cartaService.obtenerCartaPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }




    @GetMapping("/todas")
    public ResponseEntity<ResponseModel> obtenerTodasColecciones(@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if (admin.equals("ROLE_true")) {
            return ResponseEntity.ok(cartaService.obtenerListaCartas());
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }




    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarCartaPorId(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if (admin.equals("ROLE_true")) {
            return ResponseEntity.ok(cartaService.eliminarCartaPorId(id));
        }
       return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

}
