package org.dam19.tcgjpaserver.projections;

import java.time.LocalDate;
import java.util.Set;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.Coleccion}
 */
public interface ColeccionInfo {
    Integer getId();

    String getNombre();

    Integer getNumeroCartas();

    LocalDate getFechaLanzamiento();

    String getUrlImagen();

    Set<CartaInfo1> getCartas();

    Set<ProductoInfo> getProductos();

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Carta}
     */
    interface CartaInfo1 {
        Integer getId();

        String getNombre();

        Integer getNumeroColeccion();

        String getUrlImagen();
    }

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Producto}
     */
    interface ProductoInfo {
        Integer getId();

        String getNombre();

        String getUrlImagen();
    }
}