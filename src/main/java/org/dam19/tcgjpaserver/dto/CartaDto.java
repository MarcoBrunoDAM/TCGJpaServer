package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.Carta}
 */
public class CartaDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Integer numeroColeccion;
    private final ColeccionDto idColeccion;
    private final String urlImagen;

    public CartaDto(Integer id, String nombre, Integer numeroColeccion, ColeccionDto idColeccion, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.numeroColeccion = numeroColeccion;
        this.idColeccion = idColeccion;
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumeroColeccion() {
        return numeroColeccion;
    }

    public ColeccionDto getIdColeccion() {
        return idColeccion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaDto entity = (CartaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.numeroColeccion, entity.numeroColeccion) &&
                Objects.equals(this.idColeccion, entity.idColeccion) &&
                Objects.equals(this.urlImagen, entity.urlImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, numeroColeccion, idColeccion, urlImagen);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "numeroColeccion = " + numeroColeccion + ", " +
                "idColeccion = " + idColeccion + ", " +
                "urlImagen = " + urlImagen + ")";
    }

    /**
     * DTO for {@link org.dam19.tcgjpaservertest.entities.Coleccion}
     */
    public static class ColeccionDto implements Serializable {
        private final Integer id;

        public ColeccionDto(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ColeccionDto entity = (ColeccionDto) o;
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