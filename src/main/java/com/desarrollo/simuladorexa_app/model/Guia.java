package com.desarrollo.simuladorexa_app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // 🔥 clave para evitar errores como "proyecto"
public class Guia {

    @JsonProperty("orden_ejecucion")
    private List<Paso> ordenEjecucion;

    public List<Paso> getOrdenEjecucion() {
        return ordenEjecucion;
    }

    public void setOrdenEjecucion(List<Paso> ordenEjecucion) {
        this.ordenEjecucion = ordenEjecucion;
    }
}