package org.dam19.tcgjpaserver.controllers;

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
    //Este metodo permite crear un tipo de producto.
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearTipoProducto(@RequestBody TipoProductoDto tipoProductoDto,
                                                           @AuthenticationPrincipal UserDetails userDetails) {
        //Comprueba userDetao;
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion, . Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")){
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(tipoProductoService.crearTipoProducto(tipoProductoDto));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    //Este metodo obtener todos los productos que tienen un formato de producto a traves de la id de este.

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorID(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")){
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(tipoProductoService.obtenerTipoProductoPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    //Este metodo permite obtener todos los tipos de producto existentes en la BBDD.
    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerTodosProductos(@AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")){
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(tipoProductoService.obtenerListaTipoProductos());
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }



    //Este metodo pemite borrar un tipo de producto determinado a traves de su id.
    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminarTipoProductoPorId(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if(admin.equals("ROLE_true")){
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(tipoProductoService.eliminarTipoProductoPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


}
