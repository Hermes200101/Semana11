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

    private static int Codigo;
    private static String Nombre;
    private static String Apellidos;
    private static String telefono;
    private static int semestre;

    public int getCodigo() {
        return Codigo;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static String getApellidos() {
        return Apellidos;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static int getSemestre() {
        return semestre;
    }

    public void setCodigo(int Codigo) {
        Estudiante.Codigo = Codigo;
    }

    public void setNombre(String Nombre) {
        Estudiante.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        Estudiante.Apellidos = Apellidos;
    }

    public void setTelefono(String telefono) {
        Estudiante.telefono = telefono;
    }

    public void setSemestre(int semestre) {
        Estudiante.semestre = semestre;
    }

}
