package com.proyecto_desarrollo_web.demo.Producto.Domain;

import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoCantidad;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoNombre;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoPrecio;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.util.HashMap;
import java.util.Objects;

public class Producto {

    private ProductoId id;
    private ProductoNombre nombre;
    private ProductoPrecio precio;
    private ProductoCantidad cantidad;

    public Producto(ProductoId id, ProductoNombre nombre, ProductoPrecio precio, ProductoCantidad cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    private Producto(){};

    public void actualizarPrecio(ProductoPrecio precio){
        this.precio = precio;
    }

    public void actualizarCantidad(ProductoCantidad cantidad){
        this.cantidad = cantidad;
    }

    public void restarUnoCantidad(){
        this.cantidad = new ProductoCantidad(this.cantidad.value() - 1);
    }

    public ProductoPrecio Precio(){
        return  this.precio;
    }
    public ProductoCom crearProductoCom(){
        return new ProductoCom(this.id.value(),this.nombre.value(),this.precio.value(),this.cantidad.value());
    }

    public static Producto crear(ProductoId id, ProductoNombre nombre, ProductoPrecio precio, ProductoCantidad cantidad){
        Producto producto = new Producto(id, nombre, precio, cantidad);
        return producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }

    public HashMap<String, String> crearRespuestaBusqueda() {
        String nombre = this.nombre.value();
        String precio = this.precio.value().toString();
        HashMap<String, String > nuevo = new HashMap<>(){{
            put("Nombre:", nombre);
            put("Precio:", precio);
        }};
        return  nuevo;
    }
}
