/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author Hermes
 */
public class Estudiante {

    private static String Codigo;
    private static String Nombre;
    private static String Apellidos;
    private static String telefono;
    private static String semestre;

    public Estudiante() {
    }
    
    public Estudiante(String Codigo, String Nombre, String Apellidos, String telefono, String semestre) {
        Estudiante.Codigo = Codigo;
        Estudiante.Nombre = Nombre;
        Estudiante.Apellidos = Apellidos;
        Estudiante.telefono = telefono;
        Estudiante.semestre = semestre;
    }

    public static String getCodigo() {
        return Codigo;
    }

    public static void setCodigo(String Codigo) {
        Estudiante.Codigo = Codigo;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        Estudiante.Nombre = Nombre;
    }

    public static String getApellidos() {
        return Apellidos;
    }

    public static void setApellidos(String Apellidos) {
        Estudiante.Apellidos = Apellidos;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        Estudiante.telefono = telefono;
    }

    public static String getSemestre() {
        return semestre;
    }

    public static void setSemestre(String semestre) {
        Estudiante.semestre = semestre;
    }
    
    
    Arreglo a = new Arreglo();
    public void eliminarRegistro(int i){
        a.vector.remove(i);
    }

    

    

}
