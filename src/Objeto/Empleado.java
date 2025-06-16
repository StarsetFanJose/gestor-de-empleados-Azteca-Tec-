/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objeto;

/**
 *
 * @author josea
 */
public class Empleado {
    
    private String id;
    private String apellido;
    private String nombres;
    private String fechaNacimiento;
    private String fechaContrato; //formao dd/MM/yyyy
    private String curp;
    private int tiempoTrabajo; //En semanas
    private double pago; //Pago Inicial que se ingresara
    private double salario; //Se calcula el tiempoTrabajo * pago para sacar salario
    private String areaEmpleo;
    private String puestoEmpleo;
    private String estatus;
    
    //Constructor vacio para la flexibilidad de los datos
    public Empleado() {
        
    }
    
    public Empleado(String id, String apellido, String nombres, String fechaNacimiento, String fechaContrato, String curp,
            int tiempoTrabajo, double pago, String areaEmpleo, String puestoEmpleo, String estatus) {
        this.id = id;
        this.apellido = apellido;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContrato = fechaContrato;
        this.curp = curp;
        this.tiempoTrabajo = tiempoTrabajo;
        this.pago = pago;
        this.salario = calcularSalario();
        this.areaEmpleo = areaEmpleo;
        this.puestoEmpleo = puestoEmpleo;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getTiempoTrabajo() {
        return tiempoTrabajo;
    }

    public void setTiempoTrabajo(int tiempoTrabajo) {
        this.tiempoTrabajo = tiempoTrabajo;
        this.salario = calcularSalario();
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
        this.salario = calcularSalario();
    }

    public double getSalario() {
        return salario;
    }
    
    private double calcularSalario() {
        return tiempoTrabajo * pago;
    }


    public String getAreaEmpleo() {
        return areaEmpleo;
    }

    public void setAreaEmpleo(String areaEmpleo) {
        this.areaEmpleo = areaEmpleo;
    }

    public String getPuestoEmpleo() {
        return puestoEmpleo;
    }

    public void setPuestoEmpleo(String puestoEmpleo) {
        this.puestoEmpleo = puestoEmpleo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    @Override
    public String toString() {
        return id + "," + apellido + "," + nombres + "," + fechaNacimiento + "," + fechaContrato + "," + curp + "," +
                tiempoTrabajo + "," + pago + "," + salario + "," + areaEmpleo + "," + puestoEmpleo + "," + estatus;
    }

}
