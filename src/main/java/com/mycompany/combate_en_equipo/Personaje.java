/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combate_en_equipo;

import java.util.Random;

/**
 *
 * @author felii_000
 */
class Personaje {

    String nombre;
    int salud;
    int ataque;
    int velocidad;
    boolean atributoEspecialDisponible;

    public Personaje(String nombre, int salud, int ataque, int velocidad) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.atributoEspecialDisponible = true;
    }

    public void atacar(Personaje enemigo) {
        int daño = new Random().nextInt(ataque) + 1;
        enemigo.salud -= daño;
        System.out.println(nombre + " ataca a " + enemigo.nombre + " y causa " + daño + " de daño.");
    }

    public void usarAtributoEspecial(Personaje enemigo) {
        if (atributoEspecialDisponible) {

            int dañoEspecial = 25;
            enemigo.salud -= dañoEspecial;

            System.out.println(nombre + " usa su atributo especial y causa " + dañoEspecial + " de daño a " + enemigo.nombre + ".");

            atributoEspecialDisponible = false;
        } else {
            System.out.println(nombre + " intenta usar su atributo especial, pero no está disponible.");
        }
    }

    public boolean esAtributoEspecialDisponible() {
        return atributoEspecialDisponible;
    }
}
