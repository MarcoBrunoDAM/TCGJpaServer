package org.dam19.tcgjpaserver.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "producto_distribuidor")
public class ProductoDistribuidor {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_distibuidor", nullable = false)
    private Distribuidore idDistibuidor;

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Distribuidore getIdDistibuidor() {
        return idDistibuidor;
    }

    public void setIdDistibuidor(Distribuidore idDistibuidor) {
        this.idDistibuidor = idDistibuidor;
    }

}