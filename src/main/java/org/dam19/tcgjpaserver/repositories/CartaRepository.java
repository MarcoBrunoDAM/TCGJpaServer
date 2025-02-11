package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Carta;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
    Optional<List<CartaInfo>> findAllBy();
}