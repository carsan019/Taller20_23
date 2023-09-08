package com.uco.Agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private String nombre;
    private List<Contacto> contactos;

    public static final int CAPACIDAD_AGENDA = 50;

    public Agenda(String nombre) {
        this.nombre = nombre;
        this.contactos = new ArrayList<>();
    }
    public boolean comprobarSiExisteContacto(long celular) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i) != null && contactos.get(i).getCelular() == celular) {
                return true;
            }
        }
        return false;
    }
    int cantidad;
    public void agregarContacto(String nombre, String apellido, long celular) {
        Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
        if (comprobarSiExisteContacto(celular)) {
            System.out.println("Ya existe un contacto con el mismo celular ");
        } else {
            if (cantidad < CAPACIDAD_AGENDA) {
                this.contactos.add(contactoAAgregar);
                cantidad += 1;
                System.out.println("Contacto Ingresado");
            } else {
                System.out.println("Agenda llena");
            }
        }
    }
    public boolean eliminarContacto(long celularAEliminar) {
        Contacto contactoExistente = this.buscarPorCelular(celularAEliminar);
        if (comprobarSiExisteContacto(celularAEliminar)) {
            System.out.println("Contacto Eliminado");
            this.contactos.remove(contactoExistente);
            cantidad -= 1;
        } else {
            System.out.println("Este contacto no existe");
        }return false;
    }
    public boolean buscarApellido(String apellido) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < contactos.size(); i++) {
            if (apellido.equals(contactos.get(i).getApellido())) {
                System.out.println("Este apellido si se encuentra en la agenda, su detalle es: " + contactos.get(i).getNombre() + " " + contactos.get(i).getCelular());
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este apellido no se encuentra agregado en la Agenda");
        }return false;
    }
    public boolean buscarNombre(String nombre) {
        boolean encontrado = false; // Variable para realizar un seguimiento de si se encuentra la coincidencia

        for (int i = 0; i < contactos.size(); i++) {
            if (nombre.equals(contactos.get(i).getNombre())) {
                System.out.println("Este Nombre si se encuentra en la agenda, su detalle es: " + contactos.get(i).getApellido() + " " + contactos.get(i).getCelular());
                encontrado = true; // Se encontró una coincidencia
            }
        }
        if (!encontrado) {
            System.out.println("Este Nombre no se encuentra agregado en la Agenda");
        }return false;
    }
    public Contacto buscarPorCelular(long celularABuscar) {
        return this.contactos.stream()
                .filter(contacto -> contacto.getCelular() == celularABuscar)
                .findFirst().orElse(null);
    }
    public void cambiarCelular(long celularActual, long nuevoCelular) {
        Contacto contactoExistente = this.buscarPorCelular(celularActual);

        if (contactoExistente != null) {
            contactoExistente.celular = nuevoCelular;
        }
    }
    public List<Contacto> ordenarAlfabeticamente(){
        this.contactos.sort(
                Comparator.comparing(Contacto::getNombre)
                        .thenComparing(Contacto::getApellido));
        return this.contactos;
    }


    public String getNombre() {
        return nombre;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }
}