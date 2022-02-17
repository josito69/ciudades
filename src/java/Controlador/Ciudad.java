/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author josito
 */
public class Ciudad {
    int Id,poblacion;
    String nombre,CodigoPais,distrito;

    @Override
    public String toString() {
        return "Ciudad{" + "Id=" + Id + ", poblacion=" + poblacion + ", nombre=" + nombre + ", CodigoPais=" + CodigoPais + ", distrito=" + distrito + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPais() {
        return CodigoPais;
    }

    public void setCodigoPais(String CodigoPais) {
        this.CodigoPais = CodigoPais;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Ciudad(int Id, String nombre, String CodigoPais, String distrito, int poblacion) {
        this.Id = Id;
        this.poblacion = poblacion;
        this.nombre = nombre;
        this.CodigoPais = CodigoPais;
        this.distrito = distrito;
    }
}
