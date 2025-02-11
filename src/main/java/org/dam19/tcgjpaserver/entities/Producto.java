package org.dam19.tcgjpaserver.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribuidor")
    private Distribuidore idDistribuidor;

    @Column(name = "url_imagen", length = Integer.MAX_VALUE)
    private String urlImagen;

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

    public Distribuidore getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Distribuidore idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}