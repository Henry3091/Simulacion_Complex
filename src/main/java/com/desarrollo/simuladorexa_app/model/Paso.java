package com.desarrollo.simuladorexa_app.model;

public class Paso {

    private int paso;
    private String nombre;

    private String archivo;
    private String codigo;

    // opcionales del JSON
    private Object configuracion;
    private String codigo_sql;
    private Object paquetes;
    private Object archivos;
    private Object acciones;

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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Object configuracion) {
        this.configuracion = configuracion;
    }

    public String getCodigo_sql() {
        return codigo_sql;
    }

    public void setCodigo_sql(String codigo_sql) {
        this.codigo_sql = codigo_sql;
    }

    public Object getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(Object paquetes) {
        this.paquetes = paquetes;
    }

    public Object getArchivos() {
        return archivos;
    }

    public void setArchivos(Object archivos) {
        this.archivos = archivos;
    }

    public Object getAcciones() {
        return acciones;
    }

    public void setAcciones(Object acciones) {
        this.acciones = acciones;
    }
}