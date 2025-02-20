package org.dam19.tcgjpaserver.services;

import org.dam19.tcgjpaserver.dto.ProductoDto;
import org.dam19.tcgjpaserver.dto.TipoProductoDto;
import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.dam19.tcgjpaserver.mappers.TipoProductoMapper;
import org.dam19.tcgjpaserver.models.ResponseModel;
import org.dam19.tcgjpaserver.projections.TipoProductoInfo;
import org.dam19.tcgjpaserver.repositories.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    @Autowired
    private TipoProductoMapper tipoProductoMapper;

    public ResponseModel crearTipoProducto (TipoProductoDto tipoProductoDto) {
        TipoProducto tipoProducto = tipoProductoMapper.toEntity(tipoProductoDto);
        if (tipoProductoRepository.save(tipoProducto) != null) {
            return new ResponseModel(0,"Tipo producto creado",tipoProducto.getId());
        }
        return new ResponseModel(1,"No se pudo crear el tipo producto",null);

    }

    public ResponseModel obtenerTipoProductoPorId(int id) {
        Optional<List<TipoProductoInfo>> listaProductos = tipoProductoRepository.findTipoProductoById(id);
        if(listaProductos.isPresent()) {
            return new ResponseModel(0,"Lista de tipos productos",listaProductos.get());
        }
        return new ResponseModel(1,"No hay lista", null);

    }
    public ResponseModel obtenerListaTipoProductos() {
        Optional<List<TipoProductoInfo>> listaProductos = tipoProductoRepository.findAllBy();
        return new ResponseModel(0,"Lista de productos",listaProductos.get());
    }

    public ResponseModel eliminarTipoProductoPorId(int id) {
        long delete = tipoProductoRepository.deleteByIdIs(id);
        if(delete> 0){
            return new ResponseModel(0,"Se ha eliminado el tipo",null);
        }
        return new ResponseModel(1,"No hay lista", null);

    }
}
