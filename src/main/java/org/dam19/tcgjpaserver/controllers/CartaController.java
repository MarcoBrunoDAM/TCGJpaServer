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
    //Este metodo permite crear una carta.
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearCarta(@RequestBody CartaDto cartaDto,
                                                    @AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aqui, el usuario no esta autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(cartaService.crearCarta(cartaDto));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    //Este metodo permite obtener una carta determinada a traves de su id.
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerCartaPorID(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(cartaService.obtenerCartaPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    //Este metodo permite obtener todas las cartas existentes en la BBDD.
    @GetMapping("/todas")
    public ResponseEntity<ResponseModel> obtenerTodasCartas(@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(cartaService.obtenerListaCartas());
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
    //Este metodo pemite borrar una carta determinada a traves de su id.
    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarCartaPorId(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(cartaService.eliminarCartaPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
    //Este metodo obtener todas las cartas que pertenecen a una coleccion a traves de su id.
    @GetMapping("/buscarPorColeccionId/{id}")
    public ResponseEntity<ResponseModel> obtenerCartaPorColeccionId(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(cartaService.obtenerCartasPorColeccionId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

}
