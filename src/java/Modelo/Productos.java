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
public class Productos {
    private int id;
    private String descripcion;
    private double precioVenta;

    public Productos() {
    }
    
    

    public Productos(int id, String descripcion, double precioVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Productos{" + "id=" + id + ", descripcion=" + descripcion + ", precioVenta=" + precioVenta + '}';
    }
    
    
}
