package com.uco.Agenda.app;

import com.uco.Agenda.dominio.Agenda;
import com.uco.Agenda.dominio.Contacto;

import java.util.ArrayList;
import java.util.List;


public class AppAgenda {
    public static void main(String[] args) {
        //Ponemos el nombre de la agenda y la empezamos a crear contactos.
        Agenda agenda = new Agenda("Mi Agenda");
        List<Contacto> contactosPorApellido = new ArrayList<>();

        //Imprimimos el nombre de la agenda y el tamaño de la agenda antes de agregar los contactos
        System.out.println("Nombre de la Agenda " + agenda.getNombre());
        System.out.println("Tamaño de la lista: " + agenda.getContactos().size());
        int cantidad=0;
        //Agregamos los contactos a la Agenda
        agenda.agregarContacto("Juan", "Arenas",32412);
        agenda.agregarContacto("Jose", "Quintero",2321);
        agenda.agregarContacto("Lucas", "Arbelaez",34221);
        agenda.agregarContacto("Natalia", "Acevedo",87543);
        agenda.agregarContacto("Carlos", "Marin",98793);
        agenda.agregarContacto("Camilo", "Acevedo",43422);
        agenda.agregarContacto("Luis", "Diaz",4342322);

        agenda.getContactos().forEach(p -> {
            System.out.println(p.getNombre() + " " + p.getApellido() + " # " + p.getCelular());
        });
        System.out.println("Tamaño de la lista: " + agenda.getContactos().size());

        //Eliminamos  contactos a la Agenda
        agenda.eliminarContacto(32412);
        agenda.agregarContacto("Jian","Rojas",43422);

        agenda.buscarNombre("Luis");
        agenda.buscarApellido("Acevedo");
        agenda.buscarPorCelular(34221);

        agenda.cambiarCelular(98793,2222);


        //Buscamos los contactos por Apellido en la Agenda, Nombre y Celular

        // Imprimimos los contactos
        agenda.getContactos().forEach(p -> {
            System.out.println(p.getNombre() + " " + p.getApellido() + " # " + p.getCelular());
        });

        System.out.println("Lista de contactos ordenado alfabeticamente");

        //Ordenams por orden alfabetico
        agenda.ordenarAlfabeticamente().forEach(c->{
            System.out.println(c.getNombre()+ " - "+ c.getApellido());
        });

        // Imprimimos el tamaño y los contactos
        System.out.println("Tamaño de la lista: " + agenda.getContactos().size());
    }
}