package dam.acdat.ActEvaluable;

public class Empleados {
    private Integer codEmpleado;
    private String dNI;
    private String nombre;
    private Float salarioBrut;
    private Boolean fijo;

    public Empleados(int codEmpleado, String DNI, String nombre, float salarioBrut, boolean fijo) {
        this.codEmpleado = codEmpleado;
        this.dNI = DNI;
        this.nombre = nombre;
        this.salarioBrut = salarioBrut;
        this.fijo = fijo;
    }

    public String getCodEmpleadoString() {
        return (codEmpleado == null) ? "" : codEmpleado.toString();

    }

    public int getCodEmpleado(){
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return (nombre == null) ? "" : nombre;
    }


    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getDNI() {
        return (dNI == null) ? "" : dNI;
    }

    public void setDNI(String DNI) {
        this.dNI = DNI;
    }

    public String getSalarioBrutString() {
        return (salarioBrut == null) ? "" : salarioBrut.toString();
    }

    public float getSalarioBruto(){
        return salarioBrut;
    }

    public void setSalarioBrut(float salarioBrut) {
        this.salarioBrut = salarioBrut;
    }

    public boolean isFijo() {
        return fijo;
    }

    public void setFijo(boolean fijo) {
        this.fijo = fijo;
    }
}
