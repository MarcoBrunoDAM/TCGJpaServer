package org.dam19.tcgjpaserver.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.Distribuidore}
 */
public interface DistribuidoreInfo {
    Integer getId();

    String getNombre();

    Set<ProductoInfo1> getProductos();

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Producto}
     */
    interface ProductoInfo1 {
        Integer getId();

        String getNombre();

        String getUrlImagen();

        TipoProductoInfo1 getIdTipo();

        ColeccionInfo1 getIdColeccion();

        /**
         * Projection for {@link org.dam19.tcgjpaserver.entities.TipoProducto}
         */
        interface TipoProductoInfo1 {
            Integer getId();

            String getTipo();
        }

        /**
         * Projection for {@link org.dam19.tcgjpaserver.entities.Coleccion}
         */
        interface ColeccionInfo1 {
            Integer getId();

            String getNombre();
        }
    }
}