package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColeccionRepository extends JpaRepository<Coleccion, Integer> {
}