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
public class Confirmacion {
    private int id;
    private String descripcion;
    private double costoUnitario;

    public Confirmacion(int id, String descripcion, double costoUnitario) {
        this.id = id;
        this.descripcion = descripcion;
        this.costoUnitario = costoUnitario;
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

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Confirmacion{" + "id=" + id + ", descripcion=" + descripcion + ", costoUnitario=" + costoUnitario + '}';
    }
    
    
}
