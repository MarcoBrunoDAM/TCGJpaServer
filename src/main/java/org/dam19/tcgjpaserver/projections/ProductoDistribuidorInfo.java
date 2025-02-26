package org.dam19.tcgjpaserver.projections;

/**
 * Projection for {@link org.dam19.tcgjpaservertest.entities.ProductoDistribuidor}
 */
public interface ProductoDistribuidorInfo {
    ProductoInfo1 getIdProducto();

    DistribuidoreInfo1 getIdDistibuidor();

    /**
     * Projection for {@link org.dam19.tcgjpaservertest.entities.Producto}
     */
    interface ProductoInfo1 {
        Integer getId();
    }

    /**
     * Projection for {@link org.dam19.tcgjpaservertest.entities.Distribuidore}
     */
    interface DistribuidoreInfo1 {
        Integer getId();
    }
}