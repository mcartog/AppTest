/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author marcostoral
 */
public class Tema {
      private static int count = 1;
    private int idTema;
    private String nombre;

    public Tema(String nombre) {
        idTema=count++;
        this.nombre = nombre;
    }

    public int getId() {
        return idTema;
    }

    public void setId(int id) {
        this.idTema = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return idTema + " " + nombre;
    }
}
