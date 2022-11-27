/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_final;

import java.util.LinkedList;

/**
 *
 * @author Veronica
 */
public class listaUsuarios {
    private LinkedList<usuarios> Usuarios;
    
    public void agregar(usuarios usuario){
        Usuarios.add(usuario);
    }
    
    public void eliminar(int indice){
        Usuarios.remove(indice);
    }
    
    public int total(){
        return Usuarios.size();
    }
    
    public usuarios obtener(int indice){
        return Usuarios.get(indice);
    }
    
    public void cargarUsuarios(){
        BDusuarios bd = new BDusuarios();
        Usuarios = bd.obtener();
    }
    
    public void imprimir(){
        for(int i=0; i<Usuarios.size();i++){
            System.out.println(Usuarios.get(i).getIdentificacion()+" "+Usuarios.get(i).getNombre());
        }
    }
    
    public void guardarEnArchivo(){
        BDusuarios bd = new BDusuarios();
        bd.borrarTodo();
        for (int i=0; i<Usuarios.size(); i++){
            bd.registrarUsuario(Usuarios.get(i));
        }
    }
}

