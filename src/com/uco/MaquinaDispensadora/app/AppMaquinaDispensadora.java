package com.uco.MaquinaDispensadora.app;

import com.uco.MaquinaDispensadora.dominio.MaquinaDispensadora;
import com.uco.MaquinaDispensadora.dominio.Producto;

public class AppMaquinaDispensadora {
    public static void main(String[] args) {
        Producto cocacola = new Producto("Coca Cola", 1, 4,2000);
        Producto chocolatina = new Producto("Chocolatina", 2, 3,1500);
        Producto bombon = new Producto("Bombon", 3, 1,800);
        Producto papitas = new Producto("Papitas", 4, 5,2200);
        Producto salchicha = new Producto("Salchicha", 5, 1,2400);
        Producto mani = new Producto("Mani", 6, 4,3200);
        Producto galletas = new Producto("Galletas", 7, 3,1950);
        Producto nucita = new Producto("Nucita", 8, 1,3400);
        Producto chicles = new Producto("Chicles", 9, 5,5400);
        Producto cigarrillos = new Producto("Cigarrillos", 10, 5,3200);
        Producto te = new Producto("Te", 11, 1,600);
        Producto banano = new Producto("Banano", 12, 3,500);
        Producto pera = new Producto("Pera", 13, 1,3700);

        MaquinaDispensadora maquinaDispensadora = new MaquinaDispensadora("Tu maquina de confianza");


        int cantidad = 0;
        //Agregamos los productos a la Maquina dispensadora
        maquinaDispensadora.agregarSnackAMaquina(cocacola);
        maquinaDispensadora.agregarSnackAMaquina(chocolatina);
        maquinaDispensadora.agregarSnackAMaquina(bombon);
        maquinaDispensadora.agregarSnackAMaquina(papitas);
        maquinaDispensadora.agregarSnackAMaquina(salchicha);
        maquinaDispensadora.agregarSnackAMaquina(mani);
        maquinaDispensadora.agregarSnackAMaquina(galletas);
        maquinaDispensadora.agregarSnackAMaquina(nucita);
        maquinaDispensadora.agregarSnackAMaquina(chicles);
        maquinaDispensadora.agregarSnackAMaquina(cigarrillos);
        maquinaDispensadora.agregarSnackAMaquina(te);
        maquinaDispensadora.agregarSnackAMaquina(banano);
        maquinaDispensadora.agregarSnackAMaquina(pera);

        //Mostramos el contenido de la Maquina dispensadora y su tamaño
        maquinaDispensadora.getProductos().forEach(p -> {
            System.out.println("Producto "+p.getNombre() + " Código " + p.getCodigo() + " Unidades " + p.getCantidad()+" Precio: "+p.getPrecio());
        });
        System.out.println("La maquina dispensadora tiene " + maquinaDispensadora.getProductos().size() + " productos");

        //Eliminamos una unidad por codigo
        maquinaDispensadora.eliminarUnaUnidadPorCodigo(3);

        //Eliminamos una unidad por nombre
        maquinaDispensadora.eliminarUnaUnidadPorNombre("Coca Cola");

        //Agregamos unidades de un producto por su codigo
        maquinaDispensadora.agregarUnidadesAProducto(7,4);

        //Rebajamos unidades de un producto por su codigo
        maquinaDispensadora.rebajarUnidadesAProducto(5,2);

        //Eliminamos producto por nombre
        maquinaDispensadora.rebajarSnakAMaquina(mani);

        //Consultamos la cantidades de determinado producto
        maquinaDispensadora.cantidadUnidadesSnack(galletas);

        int unidadesAgotadas=0;

        //Snacks Agotados
        maquinaDispensadora.snackAgotados(0);

        //Informacion de la maquina por nombre y cantidad
        maquinaDispensadora.informacionSnack();


        //Ordenamos por precio de Mayor a Menor
        maquinaDispensadora.ordenarListaDeMayorAMenorPrecio();

        //Ordenamos por precio de Menor a Mayor
        maquinaDispensadora.ordenarListaDeMenorAMayorCantidad();

        //Mostramos el tamaño
        System.out.println("La maquina dispensadora tiene " + maquinaDispensadora.getProductos().size() + " productos");
    }
}

