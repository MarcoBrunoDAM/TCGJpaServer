package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Distribuidore;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.dam19.tcgjpaserver.projections.DistribuidoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistribuidoreRepository extends JpaRepository<Distribuidore, Integer> {
    Optional<List<DistribuidoreInfo>> findAllBy();
}