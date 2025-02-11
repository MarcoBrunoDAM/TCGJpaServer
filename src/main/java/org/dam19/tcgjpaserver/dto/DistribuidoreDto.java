package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.Distribuidore}
 */
public class DistribuidoreDto implements Serializable {
    private final Integer id;
    private final String nombre;

    public DistribuidoreDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistribuidoreDto entity = (DistribuidoreDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ")";
    }
}