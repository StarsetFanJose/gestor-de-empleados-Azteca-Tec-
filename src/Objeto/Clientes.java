/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

/**
 *
 * @author josea
 */
public class Clientes {
    
    private String id;
    private String apellido;
    private String nombres;
    private String fechaRegistro;
    private String telefono;
    private String email;
    private String direccion;
    private String estatus;
    
    public Clientes() {
        
    }
    
    public Clientes(String id, String apellido, String nombres, String fechaRegistro, String telefono, String email, String direccion, 
            String estatus) {
        this.id = id;
        this.apellido = apellido;
        this.nombres = nombres;
        this.fechaRegistro = fechaRegistro;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estatus = estatus;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    

    
    
    @Override
    public String toString() {
        return id + "," + apellido + "," + nombres + "," + fechaRegistro + "," + telefono + "," + email + "," + direccion +
                "," + estatus;
    }
}
