package org.dam19.tcgjpaserver.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam19.tcgjpaservertest.entities.Distribuidore}
 */
public interface DistribuidoreInfo {
    Integer getId();

    String getNombre();

    Set<ProductoInfo> getProductos();

    /**
     * Projection for {@link org.dam19.tcgjpaservertest.entities.Producto}
     */
    interface ProductoInfo {
        Integer getId();

        String getNombre();

        String getUrlImagen();

        TipoProductoInfo getIdTipo();

        ColeccionInfo1 getIdColeccion();

        /**
         * Projection for {@link org.dam19.tcgjpaservertest.entities.TipoProducto}
         */
        interface TipoProductoInfo {
            Integer getId();

            String getTipo();
        }

        /**
         * Projection for {@link org.dam19.tcgjpaservertest.entities.Coleccion}
         */
        interface ColeccionInfo1 {
            Integer getId();

            String getNombre();
        }
    }
}