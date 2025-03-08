package org.dam19.tcgjpaserver.controllers;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductoService productoService;
    //Este metodo permite crear un producto.
    @PostMapping("/crear")
    public ResponseEntity<ResponseModel> crearProducto(@RequestBody ProductoDto productoDto,
                                                       @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.crearProducto(productoDto));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    //Este metodo permite obtener los productos de una coleccion a traves de su id.
    @GetMapping("/buscar/coleccion/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorIDColeccion(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.obtenerProductoByColeccionId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }
    //Este metodo permite obtener los productos con un formato de producto determinado a traves de su id.
    @GetMapping("/buscar/tipo_producto/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorIDTipoProducto(@PathVariable int id,@AuthenticationPrincipal UserDetails userDetails) {
        if(userDetails == null){
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.obtenerProductoByTipoProductoId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    //Este metodo permite obtener un producto determinado a traves de su id.
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorID(@PathVariable int id,
                                                              @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    //Este metodo permite obtener todos los productos existentes en la BBDD.
    @GetMapping("/todos")
    public ResponseEntity<ResponseModel> obtenerTodosProductos( @AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.obtenerListaProductos());
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    //Este metodo pemite borrar un producto determinado a traves de su id.
    @GetMapping("/borrar/{id}")
    public ResponseEntity<ResponseModel> eliminaProductoPorId(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.

            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.eliminarProductoPorId(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }

    //Este metodo obtener todos los productos que tiene un distribuidor a traves de la id de este.
    @GetMapping("/buscar_distribuidor/{id}")
    public ResponseEntity<ResponseModel> obtenerProductoPorIdDistribuidor(@PathVariable int id,
                                                                          @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
        }
        //Se guarda en la variable <<admin>> el rol del usuario.
        String admin = userDetails.getAuthorities().iterator().next().getAuthority();
        //Comprueba si admin es igual a ROLE_true.
        if (admin.equals("ROLE_true")) {
            // Si el programa llega hasta aquí, el usuario está autorizado para llevar a cabo la accion, por lo que la lleva a cabo.
            return ResponseEntity.ok(productoService.obtenerProductoPorIdDistribuidor(id));
        }
        // Si el programa llega hasta aquí, el usuario no está autorizado para llevar a cabo la accion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return ResponseEntity.ok(new ResponseModel(1,"Usuario no autorizado",null));
    }


    }
