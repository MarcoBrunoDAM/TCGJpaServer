package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.ProductoDistribuidor}
 */
public class ProductoDistribuidorDto implements Serializable {
    private final ProductoDto1 idProducto;
    private final DistribuidoreDto1 idDistibuidor;

    public ProductoDistribuidorDto(ProductoDto1 idProducto, DistribuidoreDto1 idDistibuidor) {
        this.idProducto = idProducto;
        this.idDistibuidor = idDistibuidor;
    }

    public ProductoDto1 getIdProducto() {
        return idProducto;
    }

    public DistribuidoreDto1 getIdDistibuidor() {
        return idDistibuidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDistribuidorDto entity = (ProductoDistribuidorDto) o;
        return Objects.equals(this.idProducto, entity.idProducto) &&
                Objects.equals(this.idDistibuidor, entity.idDistibuidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idDistibuidor);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idProducto = " + idProducto + ", " +
                "idDistibuidor = " + idDistibuidor + ")";
    }

    /**
     * DTO for {@link org.dam19.tcgjpaservertest.entities.Producto}
     */
    public static class ProductoDto1 implements Serializable {
        private final Integer id;

        public ProductoDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductoDto1 entity = (ProductoDto1) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }

    /**
     * DTO for {@link org.dam19.tcgjpaservertest.entities.Distribuidore}
     */
    public static class DistribuidoreDto1 implements Serializable {
        private final Integer id;

        public DistribuidoreDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DistribuidoreDto1 entity = (DistribuidoreDto1) o;
            return Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }
}