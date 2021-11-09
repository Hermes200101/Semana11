/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import static archivos.Edicion.*;
import static Clase.Arreglo.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Hermes
 */


public class Metodos {
    public int leerCodigo(){
        try{
            int codigo = Integer.parseInt(txtConsultarCodigo.getText().trim());
            return codigo;
        }catch(Exception ex){
            return -666;
        }
    }
    public int buscarCodigo(int codigo){
        for(int i = 0; i < lista.size(); i++){
            if(codigo == lista.get(i).getCodigo())return i;
            JOptionPane.showMessageDialog(null, "CODIGO ENCONTRADO!");
            
            
            
        }
        return -1;
    }

   
}
