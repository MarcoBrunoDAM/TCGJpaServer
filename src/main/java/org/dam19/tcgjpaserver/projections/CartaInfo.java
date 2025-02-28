package org.dam19.tcgjpaserver.projections;

import java.time.LocalDate;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.Carta}
 */
public interface CartaInfo {
    Integer getId();

    String getNombre();

    Integer getNumeroColeccion();

    String getUrlImagen();

    ColeccionInfo1 getIdColeccion();

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Coleccion}
     */
    interface ColeccionInfo1 {
        Integer getId();

        String getNombre();

        Integer getNumeroCartas();

        LocalDate getFechaLanzamiento();

        String getUrlImagen();
    }
}