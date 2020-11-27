/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication29;

/**
 *
 * @author Familia
 */
public class Pedido {
    private String nombre;
    private String pedido;
    private int  precio;

    public Pedido(String nombre, String pedido, int precio) {
        this.nombre = nombre;
        this.pedido = pedido;
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "El pedido es " + pedido + "con un precio de " + precio; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
