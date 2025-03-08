package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.CartaDto;
import org.dam19.tcgjpaserver.entities.Carta;
import org.dam19.tcgjpaserver.mappers.CartaMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService {
    @Autowired
    CartaRepository cartaRepository;
    @Autowired
    CartaMapper cartaMapper;
    //Este metodo permite crear una carta.
    public ResponseModel crearCarta (CartaDto cartaDto) {
        //Convertimos CartaDto a una entidad (Carta).
        Carta carta = cartaMapper.toEntity(cartaDto);
        //Se procede a crear/editar la carta y se comprueba si devuelve un objeto o no (debe devolver la carta creada/editada).
        if (cartaRepository.save(carta) != null) {
            // Si el programa llega hasta aquí, el programa ha conseguido crear la carta. Devuelve una respuesta al usuario indicando esto y la id de la carta.
            return new ResponseModel(0,"Carta creada",carta.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido crear la carta. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No se pudo crear la carta",null);

    }
    //Este metodo permite obtener una carta determinada a traves de su id.
    public ResponseModel obtenerCartaPorId(int id) {
        //Se procede a buscar la carta con dicha id y se guarda en la lista <<listaCartas>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<CartaInfo>> listaCartas = cartaRepository.findCartaById(id);
        //Comprueba si la lista obtenida tiene cartas.
        if(listaCartas.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado una carta con dicha id. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaCartas>>.
            return new ResponseModel(0,"Lista de cartas",listaCartas.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ninguna carta con dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }    //Este metodo permite obtener todas las cartas existentes en la BBDD.
    public ResponseModel obtenerListaCartas() {
        //Se guardan todos las cartas existentes en la BBDD en la lista <<listaCartas>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<CartaInfo>> listaCartas = cartaRepository.findAllBy();
        // El programa devuelve una respuesta al usuario que incluye la lista de cartas.
        return new ResponseModel(0,"Lista de cartas",listaCartas.get());
    }
    //Este metodo pemite borrar una carta determinada a traves de su id.
    public ResponseModel eliminarCartaPorId(int id) {
        //Se procede a eliminar la carta y se guarda el numero de registro eliminados en la variable <<delete>>
        long delete = cartaRepository.deleteByIdIs(id);
        //Comprueba si la variable <<delete>> es superior a 0, es decir, si se ha eliminado una carta o mas.
        if(delete> 0){
            // Si el programa llega hasta aquí, el programa ha conseguido eliminar la carta. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return new ResponseModel(0,"Se ha eliminado la carta",null);
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido eliminar la carta. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
    //Este metodo obtener todas las cartas que pertenecen a una coleccion a traves de su id.
    public ResponseModel obtenerCartasPorColeccionId(int id){
        //Se procede a buscar las cartas de dicha coleccion con la id de esta y se guarda en la lista <<listaCartas>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<CartaInfo>> listaCartas =cartaRepository.findCartasByColeccionId(id);
        //Comprueba si la lista obtenida tiene cartas.
        if(listaCartas.isPresent()) {
            // Si el programa llega hasta aquí, el programa ha encontrado una o más cartas pertenecientes a dicha coleccion. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaCartas>>.
            return new ResponseModel(0,"Lista de cartas",listaCartas.get());
        }
        // Si el programa llega hasta aquí, el programa no ha encontrado ninguna carta que pertenezca a dicha coleccion. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);
    }
}
