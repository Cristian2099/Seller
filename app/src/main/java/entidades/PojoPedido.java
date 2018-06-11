package entidades;

public class PojoPedido {

    private String nombreNegocio;
    private String totalProductos;
    private String precioTotal;

    public PojoPedido(){

    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(String totalProductos) {
        this.totalProductos = totalProductos;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }
}
