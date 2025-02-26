package org.dam19.tcgjpaserver.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('producto_id_producto_seq')")
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = Integer.MAX_VALUE)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private TipoProducto idTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion")
    private Coleccion idColeccion;

    @Column(name = "url_imagen", length = Integer.MAX_VALUE)
    private String urlImagen;

    @ManyToMany
    @JoinTable(name = "producto_distribuidor",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_distibuidor"))
    private Set<Distribuidore> distribuidores = new LinkedHashSet<>();

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

    public TipoProducto getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoProducto idTipo) {
        this.idTipo = idTipo;
    }

    public Coleccion getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Coleccion idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Set<Distribuidore> getDistribuidores() {
        return distribuidores;
    }

    public void setDistribuidores(Set<Distribuidore> distribuidores) {
        this.distribuidores = distribuidores;
    }

}