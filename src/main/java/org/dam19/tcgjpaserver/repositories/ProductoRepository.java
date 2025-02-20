package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Producto;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.ProductoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<List<ProductoInfo>> findAllBy();

    @Query("select p from Producto p where p.id = ?1")
    Optional<List<ProductoInfo>> findProductoById(Integer id);

    @Transactional
    @Modifying
    @Query("delete from Producto p where p.id = ?1")
    int deleteByIdIs(Integer id);

}