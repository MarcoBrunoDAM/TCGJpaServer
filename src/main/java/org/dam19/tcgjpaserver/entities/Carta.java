package org.dam19.tcgjpaserver.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('carta_id_carta_seq')")
    @Column(name = "id_carta", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = Integer.MAX_VALUE)
    private String nombre;

    @Column(name = "numero_coleccion")
    private Integer numeroColeccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coleccion")
    private Coleccion idColeccion;

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

    public Integer getNumeroColeccion() {
        return numeroColeccion;
    }

    public void setNumeroColeccion(Integer numeroColeccion) {
        this.numeroColeccion = numeroColeccion;
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

}