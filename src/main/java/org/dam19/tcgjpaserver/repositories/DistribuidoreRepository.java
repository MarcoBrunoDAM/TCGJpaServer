package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Distribuidore;
import org.dam19.tcgjpaserver.projections.DistribuidoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DistribuidoreRepository extends JpaRepository<Distribuidore, Integer> {
  Optional<List<DistribuidoreInfo>> findAllBy();

  @Query("select d from Distribuidore d where d.id = ?1")
  Optional <List<DistribuidoreInfo>> obtenerDistribuidorById(Integer id);

  @Transactional
  @Modifying
  @Query("delete from Distribuidore d where d.id = ?1")
  int deleteByIdIs(Integer id);

}