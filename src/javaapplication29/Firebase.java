/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication29;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.Log;
import com.google.firebase.internal.NonNull;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author Familia
 */
public class Firebase {
    public FirebaseDatabase firebaseDatabase;
    
    
    public void listaDatos(){
       // LinkedHashMap<String,Transaccion> test = new LinkedHashMap<String, Transaccion>();
    DatabaseReference data=firebaseDatabase.getInstance().getReference();
                try {
                    data.child("items").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot ds) {
                        System.out.println(ds.exists());
                        if(ds.exists()){ 
                           
                            for(DataSnapshot ds2 : ds.getChildren()) {
                                    
                                    String name = ds2.child("nombre").getValue().toString();
                                    Long cedula=Long.parseLong(ds2.child("cedula").getValue().toString());
                                    Double monto=Double.parseDouble(ds2.child("cedula").getValue().toString());
                                    //Transaccion t=new Transaccion(name,cedula,monto);
                                    //test.put(name,t);
                                    System.out.println(name);
                                   
                                    
                                    /*for (Map.Entry<String, Transaccion> entrySet : test.entrySet()) {                  //For each para mostra en pantalla el nombre y el vehiculo que ingreso
                                    
                                    String key = entrySet.getKey();
                                    Transaccion value = entrySet.getValue();
                                    
                                    System.out.println(key);
                                    System.out.println(value);
                                }*/
                                    
                            }
                            /*for (Map.Entry<String, Transaccion> entrySet : test.entrySet()) { 
                                Interfaz2 h = new Interfaz2();
                                String key = entrySet.getKey();
                                Transaccion value = entrySet.getValue();
                                h.jTextArea1.append(key+"\n" +value.toString()+"\n");
                                System.out.println(key);
                                System.out.println(value);
                            }*/

                        }


                    }
                @Override
                    public void onCancelled(DatabaseError de) {
                        }
                });
            } catch (Exception ex) {
                System.out.println(ex);
            }
                
                
    }
    public void subirDatos(){
        ActionListener receptor = new ActionListener() {              //se unicializa receptor para que se ejecute un evento
            
            @Override
            public void actionPerformed(ActionEvent e) {              //Metodo de la clase ActionListener, para ejecutar un evento, este es para acceder a la aplicación
                try {
                    //saveMessage(campo2.getText());
                    DatabaseReference data2=firebaseDatabase.getInstance().getReference();
                    //data2.child("items").child("-MLjxwP2KWZPMdJ55wO1").child("-MM2yp7vGlsZQiGh5PSS").setValue(campo2.getText());
                    //camp.append("\n"+ campo2.getText());
                    //campo.append("\n");
                }catch(Exception e1){
                    System.out.println(e1);
                 }
                }
            };
            //boton.addActionListener(receptor);
        
    
    }
    public void subirDatos2(Empleado p){
        DatabaseReference databaseReference = firebaseDatabase.getReference("/");
        DatabaseReference childReference = databaseReference.child("items");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        childReference.push().setValue(p, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Registro guardado!");
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    
    
    }
    public void subirDatos3(Pedido e){
        DatabaseReference databaseReference = firebaseDatabase.getReference("/");
        DatabaseReference childReference = databaseReference.child("pedidos");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        childReference.push().setValue(e, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Registro guardado!");
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    
    
    }
    public void initFirebase() {
        try {
            
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://parcial-2-1e5c1.firebaseio.com/") 
                    .setServiceAccount(new FileInputStream(new File("C:\\Users\\Familia\\Desktop\\AlmaceNSM\\JavaApplication29\\parcial-2-1e5c1-firebase-adminsdk-3ewkx-2f09b2c0c5.json")))

                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();
            System.out.println("La conexión se realizo exitosamente...");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
