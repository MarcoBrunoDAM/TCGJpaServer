package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.DistribuidoreDto;
import org.dam19.tcgjpaserver.entities.Distribuidore;
import org.dam19.tcgjpaserver.mappers.DistribuidoreMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.DistribuidoreInfo;
import org.dam19.tcgjpaserver.repositories.DistribuidoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistribuidoresService {
    @Autowired
    DistribuidoreRepository distribuidoreRepository;
    @Autowired
    DistribuidoreMapper distribuidoreMapper;
    //Este metodo permite crear un distribuidor.
    public ResponseModel crearDistribuidor(DistribuidoreDto distribuidoreDto) {
        //Convertimos DistribuidorDto a una entidad (Distribuidor).
        Distribuidore distribuidore = distribuidoreMapper.toEntity(distribuidoreDto);
        //Se procede a crear/editar el distribuidor y se comprueba si devuelve un objeto o no (debe devolver el distribuidor creado/editado).
        if (distribuidoreRepository.save(distribuidore) != null) {
            // Si el programa llega hasta aquí, el programa ha conseguido crear el distribuidor. Devuelve una respuesta al usuario indicando esto y la id del distribuidor.
            return new ResponseModel(0,"Distribuidor creado",distribuidore.getId());
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido crear el distribuidor. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No se pudo crear el distribuidor",null);

    }
    //Este metodo permite obtener un distribuidor determinado a traves de su id.
    public ResponseModel obtenerDistribuidorPorId(int id) {
        //Se guardan todos los tipos de productos existentes en la BBDD en la lista <<listaDistribuidores>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<DistribuidoreInfo>> listaDistribuidores = distribuidoreRepository.obtenerDistribuidorById(id);
        //Comprueba si la lista obtenida tiene distribuidores.
        if(listaDistribuidores.isPresent()){
            // Si el programa llega hasta aquí, el programa ha encontrado un distribuidor con dicha id. Devuelve una respuesta al usuario indicando esto, además de la lista <<listaDistribuidores>>.
            return new ResponseModel(0,"Lista de distribuidores",listaDistribuidores.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    //Este metodo permite obtener todos los distribuidores existentes en la BBDD.
    public ResponseModel obtenerListaDistribuidores(){
        //Se guardan todos los distribuidores existentes en la BBDD en la lista <<listaDistribuidores>>, la cual puede estar vacia sin lanzar NullPointerException gracias a la clase <<Optional>>.
        Optional<List<DistribuidoreInfo>> listaDistribuidores = distribuidoreRepository.findAllBy();
        // El programa devuelve una respuesta al usuario que incluye la lista de distribuidores.
        return new ResponseModel(0,"Lista de distribuidores",listaDistribuidores);
    }
    //Este metodo pemite borrar un distribuidor determinado a traves de su id.
    public ResponseModel eliminarDistribuidorPorId(int id) {
        //Se procede a eliminar el distribuidor y se guarda el numero de registro eliminados en la variable <<delete>>
        long delete = distribuidoreRepository.deleteByIdIs(id);
        //Comprueba si la variable <<delete>> es superior a 0, es decir, si se ha eliminado un distribuidor o mas.
        if(delete > 0){
            // Si el programa llega hasta aquí, el programa ha conseguido eliminar el distribuidor. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
            return new ResponseModel(0,"Se ha eliminado el distribuidor",null);
        }
        // Si el programa llega hasta aquí, el programa no ha conseguido eliminar el distribuidor. Devuelve una respuesta al usuario indicando esto, pero sin devolver datos.
        return new ResponseModel(1,"No hay lista", null);

    }
}
