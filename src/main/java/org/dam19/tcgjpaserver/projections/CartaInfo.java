package org.dam19.tcgjpaserver.projections;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.Carta}
 */
public interface CartaInfo {
    Integer getId();

    String getNombre();

    Integer getNumeroColeccion();

    String getUrlImagen();

    ColeccionInfo getIdColeccion();

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Coleccion}
     */
    interface ColeccionInfo {
        Integer getId();

        String getNombre();

        Integer getNumeroCartas();
    }
}