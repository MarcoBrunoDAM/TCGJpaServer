package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.ProductoInfo;
import org.dam19.tcgjpaserver.projections.TipoProductoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
    Optional<List<TipoProductoInfo>> findAllBy();

    @Query("select t from TipoProducto t where t.id = ?1")
    Optional<List<TipoProductoInfo>> findTipoProductoById(Integer id);

    @Transactional
    @Modifying
    @Query("delete from TipoProducto t where t.id = ?1")
    int deleteByIdIs(Integer id);
}