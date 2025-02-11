package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.TipoProducto}
 */
public class TipoProductoDto implements Serializable {
    private final Integer id;
    private final String tipo;

    public TipoProductoDto(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoProductoDto entity = (TipoProductoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipo, entity.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipo = " + tipo + ")";
    }
}