/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.combate_en_equipo;

import java.util.Scanner;

/**
 *
 * @author felii_000
 */
public class Combate_en_equipo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Personaje jugador1 = new Personaje("Jugador 1", 100, 20, 2);
        Personaje jugador2 = new Personaje("Jugador 2", 100, 18, 3);

        Personaje[] jugadores = {jugador1, jugador2};

        while (jugador1.salud > 0 && jugador2.salud > 0) {
            System.out.println("\n---- Nuevo Turno ----");

            ordenarPorVelocidad(jugadores);

            for (Personaje turnoActual : jugadores) {
                System.out.println("\nTurno de " + turnoActual.nombre);
                realizarTurno(turnoActual, obtenerOponente(turnoActual, jugadores), scanner);

                if (turnoActual.velocidad > obtenerOponente(turnoActual, jugadores).velocidad) {
                    if (obtenerOponente(turnoActual, jugadores).salud <= 0) {
                        System.out.println(obtenerOponente(turnoActual, jugadores).nombre + " ha perdido. ¡" + turnoActual.nombre + " es el ganador!");
                        return;
                    }
                }
            }
        }

        scanner.close();
    }

    private static void realizarTurno(Personaje atacante, Personaje defensor, Scanner scanner) {
        System.out.println(atacante.nombre + ": Salud = " + atacante.salud);
        System.out.println(defensor.nombre + ": Salud = " + defensor.salud);
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("1. Atacar");
        System.out.println("2. Usar atributo especial");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                atacante.atacar(defensor);
                break;
            case 2:
                atacante.usarAtributoEspecial(defensor);
                break;
            default:
                System.out.println("Opción no válida. Selecciona 1 o 2.");
                break;
        }
    }

    private static void ordenarPorVelocidad(Personaje[] jugadores) {
        for (int i = 0; i < jugadores.length - 1; i++) {
            for (int j = 0; j < jugadores.length - 1 - i; j++) {
                if (jugadores[j].velocidad < jugadores[j + 1].velocidad) {
                    Personaje temp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = temp;
                }
            }
        }
    }

    private static Personaje obtenerOponente(Personaje turnoActual, Personaje[] jugadores) {
        return (turnoActual == jugadores[0]) ? jugadores[1] : jugadores[0];
    }
}
