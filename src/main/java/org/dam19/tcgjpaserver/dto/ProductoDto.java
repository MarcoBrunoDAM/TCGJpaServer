package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.Producto}
 */
public class ProductoDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final TipoProductoDto1 idTipo;
    private final ColeccionDto1 idColeccion;
    private final String urlImagen;
    private final Set<DistribuidoreDto1> distribuidores;

    public ProductoDto(Integer id, String nombre, TipoProductoDto1 idTipo, ColeccionDto1 idColeccion, String urlImagen, Set<DistribuidoreDto1> distribuidores) {
        this.id = id;
        this.nombre = nombre;
        this.idTipo = idTipo;
        this.idColeccion = idColeccion;
        this.urlImagen = urlImagen;
        this.distribuidores = distribuidores;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProductoDto1 getIdTipo() {
        return idTipo;
    }

    public ColeccionDto1 getIdColeccion() {
        return idColeccion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Set<DistribuidoreDto1> getDistribuidores() {
        return distribuidores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDto entity = (ProductoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.idTipo, entity.idTipo) &&
                Objects.equals(this.idColeccion, entity.idColeccion) &&
                Objects.equals(this.urlImagen, entity.urlImagen) &&
                Objects.equals(this.distribuidores, entity.distribuidores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, idTipo, idColeccion, urlImagen, distribuidores);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "idTipo = " + idTipo + ", " +
                "idColeccion = " + idColeccion + ", " +
                "urlImagen = " + urlImagen + ", " +
                "distribuidores = " + distribuidores + ")";
    }

    /**
     * DTO for {@link org.dam19.tcgjpaservertest.entities.TipoProducto}
     */
    public static class TipoProductoDto1 implements Serializable {
        private final Integer id;

        public TipoProductoDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TipoProductoDto1 entity = (TipoProductoDto1) o;
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
     * DTO for {@link org.dam19.tcgjpaservertest.entities.Coleccion}
     */
    public static class ColeccionDto1 implements Serializable {
        private final Integer id;

        public ColeccionDto1(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ColeccionDto1 entity = (ColeccionDto1) o;
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