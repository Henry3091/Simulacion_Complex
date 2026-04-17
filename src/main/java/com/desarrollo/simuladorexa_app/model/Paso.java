package com.desarrollo.simuladorexa_app.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Paso {

    private int paso;
    private String nombre;

    // aquí se guarda TODO lo demás dinámicamente
    private Map<String, Object> datos = new HashMap<>();

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Object> getDatos() {
        return datos;
    }

    // 🔥 clave: captura cualquier campo del JSON
    @JsonAnySetter
    public void agregarCampo(String key, Object value) {
        datos.put(key, value);
    }
}