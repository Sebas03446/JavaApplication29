/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication29;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Familia
 */
public class JavaApplication29 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Firebase f = new Firebase();
        Interfaz i = new Interfaz();
        
        i.setVisible(true);
        f.initFirebase();
        
        ActionListener receptor = new ActionListener() {              //se unicializa receptor para que se ejecute un evento
            
            @Override
            public void actionPerformed(ActionEvent e) {              //Metodo de la clase ActionListener, para ejecutar un evento, este es para acceder a la aplicación
                String a = i.jTextField3.getText();
                String b = i.jTextField4.getText();
                Empleado e1 = new Empleado(a, b);
                f.subirDatos2(e1);
            }
        };
        i.jButton2.addActionListener(receptor);
        
    }
    
    
}
