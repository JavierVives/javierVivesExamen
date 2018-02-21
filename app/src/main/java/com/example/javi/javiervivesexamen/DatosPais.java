package com.example.javi.javiervivesexamen;

/**
 * Created by Javi on 21/02/2018.
 */

import java.io.Serializable;

public class DatosPais implements Serializable {
    private String nombre;
    private String clave;
    private String capital;
    private String region;
    private String poblacion;
    private String latlng;
    private String fronteras;

    public DatosPais(String nombre, String clave, String capital, String region, String poblacion, String latlng, String fronteras) {
         this.nombre = nombre;
         this.clave = clave;
         this.capital = capital;
         this.region = region;
         this.poblacion = poblacion;
         this.latlng = latlng;
         this.fronteras = fronteras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getFronteras() {
        return fronteras;
    }

    public void setFronteras(String fronteras) {
        this.fronteras = fronteras;
    }
}
