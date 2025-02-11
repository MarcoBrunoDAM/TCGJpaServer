package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}