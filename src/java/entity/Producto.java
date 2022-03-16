package entity;
/*   Author: Griselda Medina Avendaño
    Creado : 8 mar 2022
    Actualización: 
    Descripción:
*/
import java.util.ArrayList;
import java.util.List;

public class Producto {

    private String codigo;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Producto() {
    }

    public Producto(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void main(String args[]){
       Producto a= new Producto("Camiseta ", 150.50, "Color rosa" );
       Producto b= new Producto("Pantalón", 250.5, "Mezclilla" );
       Producto c= new Producto("Sudadera", 280.5, "Negra talla chica" );
       Producto d= new Producto("Chaleco", 525.5, "Azul marino mediano" );
   
               
       
       
       
       List <Producto> listaProductos =new ArrayList <Producto>();
       listaProductos.add(a);
       listaProductos.add(b);
       listaProductos.add(c);
       listaProductos.add(d);
       
         for ( Producto i:  listaProductos ){
             System.out.println("Producto:"+i.getNombre());
             System.out.println("Precio: $"+i.getPrecio());
             System.out.println("Descripción:"+i.getDescripcion());
             System.out.println("\n\n");   
         }
   
       
    }
}
