package com.uco.MaquinaDispensadora.dominio;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;

public class MaquinaDispensadora {
    private String nombre;
    private List<Producto> productos;
    private int cantidad;

    public MaquinaDispensadora(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.cantidad = 1;
    }

    public static final int CAPACIDAD_MAQUINADISPENSADORA = 12;

    public boolean comprobarSiProductoExiste(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) != null && productos.get(i).equals(producto)) {
                return true;
            }
        }
        return false;
    }

    public void agregarSnackAMaquina(Producto producto) {
        if (comprobarSiProductoExiste(producto)) {
            System.out.println("El producto " + producto.getNombre() + " ya existe");
        } else {
            if (cantidad <= CAPACIDAD_MAQUINADISPENSADORA) {
                this.productos.add(producto);
                System.out.println("Producto ingresado a la maquina");
                cantidad += 1;
            } else {
                System.out.println("Lo sentimos, el producto " + producto.getNombre() + " no se pudo ingresar ya que la maquina esta llena, cuenta con 12 productos");
            }
        }
    }

    public void eliminarUnaUnidadPorCodigo(int codigo) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < productos.size(); i++) {
            if (codigo == (productos.get(i).getCodigo())) {
                this.productos.get(i).disminuirUnidades(1);
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este producto no se encuentra en la maquina ");
        }
    }

    public void eliminarUnaUnidadPorNombre(String nombre) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < productos.size(); i++) {
            if (nombre.equals(productos.get(i).getNombre())) {
                this.productos.get(i).disminuirUnidades(1);
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este producto no se encuentra en la maquina ");
        }
    }

    public boolean agregarUnidadesAProducto(int codigo, int unidadesAAgregar) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < productos.size(); i++) {
            if (codigo == (productos.get(i).getCodigo())) {
                this.productos.get(i).aumentarUnidades(unidadesAAgregar);
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este producto no se encuentra en la maquina ");
        }
        return false;
    }

    public boolean rebajarUnidadesAProducto(int codigo, int unidadesARebajar) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < productos.size(); i++) {
            if (codigo == (productos.get(i).getCodigo())) {
                this.productos.get(i).disminuirUnidades(unidadesARebajar);
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este producto no se encuentra en la maquina ");
        }
        return false;
    }

    public void rebajarSnakAMaquina(Producto producto) {
        if (comprobarSiProductoExiste(producto)) {
            this.productos.remove(producto);
            cantidad -= 1;
            System.out.println("Se procedera a eliminar el Snack " + producto.getNombre());
        } else {
            System.out.println("El producto " + producto.getNombre() + " no existe");
        }
    }

    public void cantidadUnidadesSnack(Producto producto) {
        if (comprobarSiProductoExiste(producto)) {
            System.out.println("La cantidad de " + producto.getNombre() + " es " + producto.getCantidad());
        }
    }

    //preguntar como crear e imprimir un elemento
    // preguntar cuando ser void, cuando boolean y cuando elemento
    public void snackAgotados(long unidadesAgotadas) {
        boolean hayProductosAgotados = false;

        for (Producto producto : productos) {
            if (producto.getCantidad() == unidadesAgotadas) {
                System.out.println("Producto agotado: " + producto.getNombre());
                hayProductosAgotados = true;
            }
        }

        if (!hayProductosAgotados) {
            System.out.println("No hay productos agotados.");
        }
    }


    public void informacionSnack(){
        System.out.println("Informacion Productos Maquina Dispensadora");
        for(int i=0;i<productos.size();i++){
            System.out.println("La Maquina dispensadora tiene el siguiente producto "+productos.get(i).getNombre()+" con "+productos.get(i).getCantidad()+ " unidades");
        }
    }

    public void ordenarListaDeMayorAMenorPrecio() {
        productos.sort(((o1, o2) -> Double.compare(o2.getPrecio(),o1.getPrecio())));
        System.out.println("Lista Ordenada por precio de Menor a Mayor");

        for (Producto snack: productos){
            System.out.println("Nombre: "+ snack.getNombre()+", Precio : " + snack.getPrecio());
        }
    }

    public  void  ordenarListaDeMenorAMayorCantidad() {
        productos.sort((((o1, o2) -> Double.compare(o1.getCantidad(), o2.getCantidad()))));
        System.out.println("Lista ordenada por Cantidad de Menor a Mayor");
        for (Producto snack: productos){
            System.out.println("Nombre: "+ snack.getNombre()+", Cantidad : " + snack.getCantidad());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}