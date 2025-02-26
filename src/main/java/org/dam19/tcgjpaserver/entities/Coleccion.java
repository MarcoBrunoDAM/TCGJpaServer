package org.dam19.tcgjpaserver.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "coleccion")
public class Coleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('coleccion_id_coleccion_seq')")
    @Column(name = "id_coleccion", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = Integer.MAX_VALUE)
    private String nombre;

    @Column(name = "numero_cartas")
    private Integer numeroCartas;

    @ColumnDefault("now()")
    @Column(name = "fecha_lanzamiento")
    private LocalDate fechaLanzamiento;

    @Column(name = "url_imagen", length = Integer.MAX_VALUE)
    private String urlImagen;

    @OneToMany(mappedBy = "idColeccion")
    private Set<Carta> cartas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idColeccion")
    private Set<Producto> productos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroCartas() {
        return numeroCartas;
    }

    public void setNumeroCartas(Integer numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

}