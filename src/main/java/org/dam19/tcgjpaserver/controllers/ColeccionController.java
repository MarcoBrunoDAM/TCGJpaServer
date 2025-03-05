package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.ColeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colecciones")
public class ColeccionController {
    @Autowired
    private ColeccionService coleccionService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearColeccion(@RequestBody ColeccionDto coleccionDto,
                                                        @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")) {
        return ResponseEntity.ok(coleccionService.crearColeccion(coleccionDto));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorID(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")) {
            return ResponseEntity.ok(coleccionService.obtenerColeccionPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    @GetMapping("/todas")
    public ResponseEntity<ResponseModel> obtenerTodasColecciones(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")) {
            return ResponseEntity.ok(coleccionService.obtenerListaColecciones());
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));

    }


    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarColeccionPorId(@PathVariable int id,
                                                                @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")) {
            return ResponseEntity.ok(coleccionService.eliminarColeccionPorId(id));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorNombre(@PathVariable String nombre, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        if(admin.equals("ROLE_true")) {
        return ResponseEntity.ok(coleccionService.obtenerColeccionPorNombre(nombre));
        }
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

}
