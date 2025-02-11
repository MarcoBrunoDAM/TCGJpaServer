package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Producto;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.ProductoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<List<ProductoInfo>> findAllBy();
}