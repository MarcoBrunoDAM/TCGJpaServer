package org.dam19.tcgjpaserver.projections;

import java.util.Set;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.TipoProducto}
 */
public interface TipoProductoInfo {
    Integer getId();

    String getTipo();

    Set<ProductoInfo> getProductos();

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Producto}
     */
    interface ProductoInfo {
        Integer getId();

        String getNombre();

        String getUrlImagen();

        ColeccionInfo1 getIdColeccion();

        DistribuidoreInfo getIdDistribuidor();

        /**
         * Projection for {@link org.dam19.tcgjpaserver.entities.Coleccion}
         */
        interface ColeccionInfo1 {
            Integer getId();

            String getNombre();
        }

        /**
         * Projection for {@link org.dam19.tcgjpaserver.entities.Distribuidore}
         */
        interface DistribuidoreInfo {
            Integer getId();

            String getNombre();
        }
    }
}