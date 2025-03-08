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
    //Este metodo permite crear una coleccion.
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearColeccion(@RequestBody ColeccionDto coleccionDto,
                                                        @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(coleccionService.crearColeccion(coleccionDto));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    //Este metodo permite obtener una coleccion determinada a traves de su id.
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorID(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(coleccionService.obtenerColeccionPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    //Este metodo permite obtener todas las colecciones existentes en la BBDD.
    @GetMapping("/todas")
    public ResponseEntity<ResponseModel> obtenerTodasColecciones(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(coleccionService.obtenerListaColecciones());
        }
        // Si el programa llega hasta aqui, el usuario no esta autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));

    }

    //Este metodo pemite borrar una coleccion determinada a traves de su id.
    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarColeccionPorId(@PathVariable int id,
                                                                @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(coleccionService.eliminarColeccionPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
    //Este metodo permite obtener una coleccion determinada a traves de su nombre.
    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<ResponseModel> obtenerColeccionPorNombre(@PathVariable String nombre, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(coleccionService.obtenerColeccionPorNombre(nombre));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

}
