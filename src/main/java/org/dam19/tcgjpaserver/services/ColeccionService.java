package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.entities.Coleccion;
import org.dam19.tcgjpaserver.mappers.ColeccionMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.ColeccionInfo;
import org.dam19.tcgjpaserver.repositories.ColeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColeccionService {
    @Autowired
    private ColeccionRepository coleccionRepository;
    @Autowired
    private ColeccionMapper coleccionMapper;


    public ResponseModel crearColeccion(ColeccionDto coleccionDto) {
        Coleccion coleccion = coleccionMapper.toEntity(coleccionDto);

        if (coleccionRepository.save(coleccion) != null) {
            return new ResponseModel(0,"Coleccion creada",coleccion.getId());
        }
        return new ResponseModel(1,"No se pudo crear la coleccion",null);

    }

    public ResponseModel obtenerColeccionPorId(int id) {
        Optional<List<ColeccionInfo>> listaColecciones = coleccionRepository.obtenerColeccionPorId(id);
        if(listaColecciones.isPresent()){
            return new ResponseModel(0,"Lista de colecciones",listaColecciones.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }

    public ResponseModel obtenerListaColecciones() {
        Optional<List<ColeccionInfo>> listaColecciones = coleccionRepository.findAllBy();
        return new ResponseModel(0,"Lista Colecciones", listaColecciones);

    }
}
