package com.example.sebastian.sucapp.entities;

/**
 * Created by sebastian on 4/9/2016.
 */
public class cuatrimestres {
    private String idcuatrimestre,cuatrimestre,status;
    private String fecha_inicio,fecha_fin;


    public String getIdcuatrimestre() {
        return idcuatrimestre;
    }

    public void setIdcuatrimestre(String idcuatrimestre) {
        this.idcuatrimestre = idcuatrimestre;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
