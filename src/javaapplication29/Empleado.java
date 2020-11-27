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
public class Empleado {
    private String usuario;
    private String contraseña;

    public Empleado(String usuraio, String contraseña) {
        this.usuario = usuraio;
        this.contraseña = contraseña;
    }

    public String getUsuraio() {
        return usuario;
    }

    public void setUsuraio(String usuraio) {
        this.usuario = usuraio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
}
