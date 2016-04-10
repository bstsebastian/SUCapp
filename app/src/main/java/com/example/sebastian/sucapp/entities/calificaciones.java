package com.example.sebastian.sucapp.entities;

/**
 * Created by sebastian on 4/9/2016.
 */
public class calificaciones {
    private String id,alumno,materia,unidad;
    private String saber,hacer,ser,Final;
    private String accionMejora;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getSaber() {
        return saber;
    }

    public void setSaber(String saber) {
        this.saber = saber;
    }

    public String getHacer() {
        return hacer;
    }

    public void setHacer(String hacer) {
        this.hacer = hacer;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    public String getFinal() {
        return Final;
    }

    public void setFinal(String aFinal) {
        Final = aFinal;
    }

    public String getAccionMejora() {
        return accionMejora;
    }

    public void setAccionMejora(String accionMejora) {
        this.accionMejora = accionMejora;
    }
}
