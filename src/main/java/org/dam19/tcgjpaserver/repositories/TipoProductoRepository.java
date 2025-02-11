package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.TipoProductoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
    Optional<List<TipoProductoInfo>> findAllBy();
}