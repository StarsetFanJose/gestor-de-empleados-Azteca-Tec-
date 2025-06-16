/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

/**
 *
 * @author josea
 */
public class Actividades {
    
    private int numAct;
    private String nombreAct;
    private String fechaInicio;
    private String fechaFin;
    private String estatusAct;
    private String idCliente;
    private String apellidoCliente;
    private String nomCliente;
    private String telefonoCliente;
    private String idEmpleado;
    private String apellidoEmpleado;
    private String nomEmpleado;
    private String curp;
    private String area;
    private String puesto;
    
    public Actividades() {
        
    }
    
    public Actividades(int numAct, String nombreAct, String fechaInicio, String fechaFin, String estatusAct, String idCliente, String apellidoCliente,String nomCliente, String telefonoCliente,
            String idEmpleado,String apellidoEmpleado, String nomEmpleado, String curp, String area, String puesto) {
        this.numAct = numAct;
        this.nombreAct = nombreAct;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estatusAct = estatusAct;
        this.idCliente = idCliente;
        this.apellidoCliente = apellidoCliente;
        this.nomCliente = nomCliente;
        this.telefonoCliente = telefonoCliente;
        this.idEmpleado = idEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.nomEmpleado = nomEmpleado;
        this.curp = curp;
        this.area = area;
        this.puesto = puesto;
    }

    public int getNumAct() {
        return numAct;
    }

    public void setNumAct(int numAct) {
        this.numAct = numAct;
    }

    public String getNombreAct() {
        return nombreAct;
    }

    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstatusAct() {
        return estatusAct;
    }

    public void setEstatusAct(String estatusAct) {
        this.estatusAct = estatusAct;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
    @Override
    public String toString() {
        return numAct + "," + nombreAct + "," + fechaInicio + "," + fechaFin + "," + estatusAct + "," + idCliente + "," + apellidoCliente + 
                "," + nomCliente + "," + telefonoCliente + "," + idEmpleado + "," + apellidoEmpleado + "," + nomEmpleado +
                 "," + curp + "," + area + "," + puesto;
    }

}
