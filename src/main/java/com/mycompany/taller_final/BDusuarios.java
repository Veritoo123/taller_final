/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_final;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Veronica
 */
public class BDusuarios {
    public LinkedList<usuarios> obtener(){
        LinkedList<usuarios> usuario=null;
        Archivo archivo=new Archivo("usuarios.txt");
        LinkedList<String> lineas = archivo.obtenerTextoArchivo();
        if (lineas != null){
           usuario= new LinkedList();
           for (int i=0; i < lineas.size(); i++){
               String linea= lineas.get(i);
               StringTokenizer tokens = new StringTokenizer(linea,";");
               int identificacion = Integer.parseInt(tokens.nextToken());
               String nombre = tokens.nextToken();
               String apellido = tokens.nextToken();
               usuario.add(new usuarios(identificacion,nombre,apellido));
               
           }
        }
         return usuario;
    }
    
    public boolean registrarUsuario(usuarios p){
        Archivo archivo= new Archivo("archivo.txt");
        return archivo.registrar(p.getIdentificacion()+";"+p.getNombre()+";"+p.getApellido()+";");
    }
}
