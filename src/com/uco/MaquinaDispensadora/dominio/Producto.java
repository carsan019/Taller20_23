package com.uco.MaquinaDispensadora.dominio;

public class Producto {
    private String nombre;
    protected int codigo;
    protected int unidades;
    protected int precio;

    public Producto(String nombre, int codigo, int unidades, int precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.unidades = unidades;
        this.precio = precio;
    }
    public static final int CAPACIDAD_PRODUCTO = 6 ;
    public void aumentarUnidades(int cantidad) {
        if ((cantidad + unidades) <= CAPACIDAD_PRODUCTO) {
            System.out.println("Fueron agregadas "+ cantidad +" unidades de "+ getNombre());
            this.unidades += cantidad;

        } else System.out.println("No se puede agregar " + cantidad + " unidades de "+ getNombre()+ ". Las unidades maximas son 6 y en esto momentos cuenta con "+ unidades+" unidades.");
    }
    public void disminuirUnidades(int cantidad){
        if((unidades-cantidad)>=0){
            System.out.println("Fueron retiradas "+ cantidad +" unidades de "+ getNombre());
            this.unidades-=cantidad;
        }else System.out.println("No se puede rebajar "+ cantidad+" unidades de "+getNombre()+ " . Solo se cuentan con "+ unidades+ " unidades");
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPrecio() {return precio;}

    public int getCantidad() {return unidades;


    }
}