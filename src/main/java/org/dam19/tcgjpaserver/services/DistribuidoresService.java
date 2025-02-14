package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.ColeccionDto;
import org.dam19.tcgjpaserver.dto.DistribuidoreDto;
import org.dam19.tcgjpaserver.entities.Coleccion;
import org.dam19.tcgjpaserver.entities.Distribuidore;
import org.dam19.tcgjpaserver.mappers.DistribuidoreMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.ColeccionInfo;
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

    public ResponseModel crearDistribuidor(DistribuidoreDto distribuidoreDto) {
        Distribuidore distribuidore = distribuidoreMapper.toEntity(distribuidoreDto);
        if (distribuidoreRepository.save(distribuidore) != null) {
            return new ResponseModel(0,"Distribuidor creado",distribuidore.getId());
        }
        return new ResponseModel(1,"No se pudo crear el distribuidor",null);

    }

    public ResponseModel obtenerDistribuidorPorId(int id) {
        Optional<List<DistribuidoreInfo>> listaDistribuidores = distribuidoreRepository.obtenerDistribuidorById(id);
        if(listaDistribuidores.isPresent()){
            return new ResponseModel(0,"Lista de colecciones",listaDistribuidores.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    public ResponseModel obtenerListaDistribuidores(){
        Optional<List<DistribuidoreInfo>> listaDistribuidores = distribuidoreRepository.findAllBy();
        return new ResponseModel(0,"Lista de distribuidores",listaDistribuidores);
    }
}
