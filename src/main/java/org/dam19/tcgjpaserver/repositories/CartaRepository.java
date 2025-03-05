package org.dam19.tcgjpaserver.repositories;

import org.dam19.tcgjpaserver.entities.Carta;
import org.dam19.tcgjpaserver.projections.CartaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
  Optional<List<CartaInfo>> findAllBy();

  @Query("select c from Carta c where c.id = ?1")
  Optional<List<CartaInfo>> findCartaById(Integer id);

  @Transactional
  @Modifying
  @Query("delete from Carta c where c.id = ?1")
  int deleteByIdIs(Integer id);

  @Query("select c from Carta c where c.idColeccion.id = ?1")
  Optional<List<CartaInfo>> findCartasByColeccionId(Integer id);

  @Query("select c from Carta c where c.nombre like ?1")
  Optional<List<CartaInfo>> findByNombreLike(String nombre);

}