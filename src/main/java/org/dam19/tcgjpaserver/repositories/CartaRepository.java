package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
}