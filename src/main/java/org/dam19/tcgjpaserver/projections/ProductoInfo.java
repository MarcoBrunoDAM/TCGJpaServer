package org.dam19.tcgjpaserver.projections;

/**
 * Projection for {@link org.dam19.tcgjpaserver.entities.Producto}
 */
public interface ProductoInfo {
    Integer getId();

    String getNombre();

    String getUrlImagen();

    TipoProductoInfo1 getIdTipo();

    ColeccionInfo1 getIdColeccion();

    DistribuidoreInfo getIdDistribuidor();

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

    /**
     * Projection for {@link org.dam19.tcgjpaserver.entities.Distribuidore}
     */
    interface DistribuidoreInfo {
        Integer getId();

        String getNombre();
    }
}