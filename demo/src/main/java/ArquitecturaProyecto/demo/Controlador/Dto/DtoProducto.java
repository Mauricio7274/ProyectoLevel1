package ArquitecturaProyecto.demo.Controlador.Dto;

public class DtoProducto {
    private int id;
    private String nombre;
    private int cantidad_en_stock;
    private String descripcion;
    private int categoria_id;
    private double precio;
    public DtoProducto() {
        // Constructor vacío necesario para la deserialización JSON
    }

    public DtoProducto(int id, String nombre, String descripcion, double precio, int cantidad_en_stock, int categoria_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_en_stock = cantidad_en_stock;
        this.categoria_id = categoria_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockQuantity() {
        return cantidad_en_stock;
    }

    public void setStockQuantity(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidad_en_stock=" + cantidad_en_stock +
                ", categoria_id=" + categoria_id +
                '}';
    }
}
