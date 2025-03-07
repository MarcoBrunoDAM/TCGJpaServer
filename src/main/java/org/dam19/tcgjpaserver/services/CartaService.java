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

    public ResponseModel crearCarta (CartaDto cartaDto) {
        //Convertimos CartaDto a una entidad (Carta).
        Carta carta = cartaMapper.toEntity(cartaDto);
        if (cartaRepository.save(carta) != null) {
            return new ResponseModel(0,"Carta creada",carta.getId());
        }
        return new ResponseModel(1,"No se pudo crear la carta",null);

    }

    public ResponseModel obtenerCartaPorId(int id) {
        Optional<List<CartaInfo>> listaCartas = cartaRepository.findCartaById(id);
        //Comprueba si la lista obtenida tiene cartas.
        if(listaCartas.isPresent()) {
            return new ResponseModel(0,"Lista de cartas",listaCartas.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    public ResponseModel obtenerListaCartas() {
        Optional<List<CartaInfo>> listaCartas = cartaRepository.findAllBy();
        return new ResponseModel(0,"Lista de cartas",listaCartas.get());
    }

    public ResponseModel eliminarCartaPorId(int id) {
        long delete = cartaRepository.deleteByIdIs(id);
        if(delete> 0){
            return new ResponseModel(0,"Se ha eliminado la carta",null);
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    public ResponseModel obtenerCartasPorColeccionId(int id){
        Optional<List<CartaInfo>> listaCartas =cartaRepository.findCartasByColeccionId(id);
        //Comprueba si la lista obtenida tiene cartas.
        if(listaCartas.isPresent()) {
            return new ResponseModel(0,"Lista de cartas",listaCartas.get());
        }
        // Si el programa llega hasta aqui, el programa no ha encontrado ninguna carta que pertenezca a dicha id. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);
    }
}
