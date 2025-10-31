package co.edu.uniquindio.SOLID.Model.DTO;

import co.edu.uniquindio.SOLID.Model.Empleado;

public class EmpleadoDTO {
    public String id;
    public String nombre;
    public String rol;
    public boolean activo = true;

    public EmpleadoDTO(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() { return rol; }

    public void setRol( String rol ) { this.rol = rol; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public boolean getActivo() { return activo; }

    public void setActivo(boolean activo) { this.activo = activo; }

}
