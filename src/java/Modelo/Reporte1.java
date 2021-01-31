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
public class Reporte1 {
    private String descripcion;
    private double precioVenta;
    private double promedio;

    public Reporte1(String descripcion, double precioVenta, double promedio) {
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.promedio = promedio;
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

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Reporte1{" + "descripcion=" + descripcion + ", precioVenta=" + precioVenta + ", promedio=" + promedio + '}';
    }
    
    
}
