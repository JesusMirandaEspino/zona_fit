/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zona_fit.zonafit.dominio;

import java.util.Objects;

/**
 *
 * @author jesus
 */
public class cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int menbresia;
    
    public cliente(){}
    
    public cliente(int id){
        this.id = id;
    }
    
    
    public cliente( String nombre, String apellido, int menbresia ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.menbresia = menbresia;
    }
    
    
    public cliente(int id,  String nombre, String apellido, int menbresia ){
        this(nombre, apellido, menbresia);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMenbresia() {
        return menbresia;
    }

    public void setMenbresia(int menbresia) {
        this.menbresia = menbresia;
    }

    @Override
    public String toString() {
        return "cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", menbresia=" + menbresia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellido);
        hash = 97 * hash + this.menbresia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cliente other = (cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.menbresia != other.menbresia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }


    
    
}
