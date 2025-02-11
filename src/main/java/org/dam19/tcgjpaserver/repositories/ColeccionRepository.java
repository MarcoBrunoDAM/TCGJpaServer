package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Coleccion;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.ColeccionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ColeccionRepository extends JpaRepository<Coleccion, Integer> {
    Optional<List<ColeccionInfo>> findAllBy();
}