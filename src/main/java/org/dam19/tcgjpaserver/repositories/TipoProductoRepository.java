package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {
}