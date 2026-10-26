package dam.acdat.ActEvaluable;

public class Pedidos {

    private int codigo;
    private String nombre;
    private String producto;
    private int uds;
    private double precio;
    private boolean urgente;

    public Pedidos(Integer codigo, String nombre, String producto, Integer uds, Double precio, boolean urgente){
        this.codigo = (codigo != null) ? codigo : 0;
        this.nombre = nombre;
        this.producto = producto;
        this.uds = (uds != null) ? uds : 0;
        this.precio = (precio != null) ? precio : 0;
        this.urgente = urgente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getUds() {
        return uds;
    }

    public void setUds(int uds) {
        this.uds = uds;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.codigo + " | Nombre Cliente: " + this.nombre + " | Producto: " + this.producto + " | Cantidad: " + this.uds + " | Precio: " + this.precio + " | Urgente: " + this.urgente;
    }
}
