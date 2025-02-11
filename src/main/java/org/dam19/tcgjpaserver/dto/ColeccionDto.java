package org.dam19.tcgjpaserver.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link org.dam19.tcgjpaserver.entities.Coleccion}
 */
public class ColeccionDto implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Integer numeroCartas;
    private final LocalDate fechaLanzamiento;
    private final String urlImagen;

    public ColeccionDto(Integer id, String nombre, Integer numeroCartas, LocalDate fechaLanzamiento, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.numeroCartas = numeroCartas;
        this.fechaLanzamiento = fechaLanzamiento;
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumeroCartas() {
        return numeroCartas;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColeccionDto entity = (ColeccionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.numeroCartas, entity.numeroCartas) &&
                Objects.equals(this.fechaLanzamiento, entity.fechaLanzamiento) &&
                Objects.equals(this.urlImagen, entity.urlImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, numeroCartas, fechaLanzamiento, urlImagen);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "numeroCartas = " + numeroCartas + ", " +
                "fechaLanzamiento = " + fechaLanzamiento + ", " +
                "urlImagen = " + urlImagen + ")";
    }
}