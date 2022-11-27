/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_final;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Veronica
 */
public class ModeloUsuarios extends AbstractTableModel {
    private listaUsuarios usuario;
    
    public ModeloUsuarios(){
        usuario= new listaUsuarios();
        usuario.cargarUsuarios();
    }
    @Override
    public int getRowCount(){
        return usuario.total();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        usuarios aux=usuario.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getIdentificacion();
            case 1: return aux.getNombre();
            default: return aux.getApellido();
        }
    }
    
    @Override
    public String getColumnName(int col){
        switch(col){
            case 0: return "IDENTIFICACION";
            case 1: return "NOMBRE";
            default: return "APELLIDO";
        }
    }
    
    @Override
    public Class getColumnClass(int col){
        switch(col){
            case 0: return Integer.class;
            case 1: return String.class;
            default: return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row,int col){
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int fila, int columna){
        usuarios aux=usuario.obtener(fila);
        switch(columna){
            case 0: aux.setIdentificacion((int)value);
                    break;
            case 1: aux.setNombre((String)value);
                    break;
            default: aux.setApellido((String)value);
        }
        fireTableCellUpdated(fila,columna);
    }
    
    public void agregarUsuario(usuarios Usuario){
        usuario.agregar(Usuario);
        this.fireTableDataChanged();
    }
    
    public void eliminarUsuario(int indice){
         usuario.eliminar(indice);
        this.fireTableDataChanged();
    }
    
    public void guardarEnArchivo(){
        usuario.guardarEnArchivo();
    }
}
