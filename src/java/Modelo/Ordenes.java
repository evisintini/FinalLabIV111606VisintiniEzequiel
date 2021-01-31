/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Ordenes {
    private int id;
    private Productos producto;
    private int cantidad;
    private double costoTotal;
    private Responsables responsable;

    public Ordenes(int id, Productos producto, int cantidad, double costoTotal, Responsables responsable) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.responsable = responsable;
    }

    public Ordenes(Productos producto, int cantidad, double costoTotal, Responsables responsable) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Responsables getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsables responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Ordenes{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", responsable=" + responsable + '}';
    }        
    
}
