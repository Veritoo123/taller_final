/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_final;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Veronica
 */
public class Archivo {
    private String nombre_ahv;

    public Archivo(String nombre) {
        this.nombre_ahv = nombre;
    }
    
    public LinkedList<String> obtenerTextoArchivo(){
        LinkedList<String> lineastxt=null;
        try{
            File archivo= obtenerArchivo();
            if(archivo.exists()){
                lineastxt=new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea =br.readLine()) != null){
                    System.out.println(linea);
                    lineastxt.add(linea);
                }
                br.close();
            }else{
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
        }
    }catch(Exception ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null,"Se produjo un error");
        }
    return lineastxt;
    }
    
    private File obtenerArchivo(){
        try{
            URL url=getClass().getClassLoader().getResource("archivos/"+nombre_ahv);
            return new File(url.toURI());
        }catch(URISyntaxException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean registrar (String linea){
        File archivo = obtenerArchivo();
        try{
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(linea);
            pw.flush();
            pw.close();
            return true;
        }catch(Exception error){
            error.printStackTrace();
        }
        return false;
    }
    
    public boolean borrarContenido(){
        try{
            File archivo = obtenerArchivo();
            String directorio = archivo.getParent();
            archivo.delete();
            new FileWriter(directorio + "/usuarios.txt", true);
            return true;
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
