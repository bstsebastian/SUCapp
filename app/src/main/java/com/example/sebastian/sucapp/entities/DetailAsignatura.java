package com.example.sebastian.sucapp.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gusta on 11/04/2016.
 */
public class DetailAsignatura {
    private String unidad, saber, hacer, ser, calFinal, accionMejora, asistencia;

    public DetailAsignatura(JSONObject asignatura) {
        try {
            setUnidad(asignatura.getString("unidad"));
            setSaber(asignatura.getString("saber"));
            setHacer(asignatura.getString("hacer"));
            setCalFinal(asignatura.getString("final"));
            setAccionMejora(asignatura.getString("accionMejora"));
            setAsistencia(asignatura.getString("asistencia") + "%");
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    public String getCalFinal() {
        return calFinal;
    }

    public void setCalFinal(String calFinal) {
        this.calFinal = calFinal;
    }

    public String getAccionMejora() {
        return accionMejora;
    }

    public void setAccionMejora(String accionMejora) {
        this.accionMejora = accionMejora;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }
}
