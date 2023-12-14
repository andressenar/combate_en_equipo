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

        Shikigami player1 = new Asura(100, 2000, 300, 120, 70, 120, 50, 30);
        player1.setName("Asura uno"); // Establece el nombre del primer jugador
        Shikigami player2 = new Yotohime(100, 3000, 200, 100, 120, 200, 20, 23);
        player2.setName("Yotohime uno");

        while (player1.getHealthPoints() > 0 && player2.getHealthPoints() > 0) {
            showPlayerInfo(player1);
            showPlayerInfo(player2);

            takeTurn(player1, player2, scanner);

            if (player2.getHealthPoints() > 0) {
                takeTurn(player2, player1, scanner);
            }
        }

        showGameResult(player1, player2);

        scanner.close();
    }

   public static void showPlayerInfo(Shikigami player) {
    System.out.println("Información del jugador: " + player.getName());
    System.out.println("Puntos de Vida: " + player.getHealthPoints());
    System.out.println("Ataque: " + player.getAttack());
    System.out.println("Defensa: " + player.getDefense());
    System.out.println("Velocidad: " + player.getSpeed());
    System.out.println("Crítico: " + player.getCritical());
    System.out.println("Daño Crítico: " + player.getCritDamage());
    System.out.println("Probabilidad de Efecto: " + player.getEffectHit());
    System.out.println("Resistencia a Efectos: " + player.getEffectRes());
}


    public static void showGameResult(Shikigami player1, Shikigami player2) {
    if (player1.getHealthPoints() <= 0 && player2.getHealthPoints() <= 0) {
        System.out.println("El juego termina en empate.");
    } else if (player1.getHealthPoints() <= 0) {
        System.out.println(player2.getName() + " ha ganado el juego!");
    } else {
        System.out.println(player1.getName() + " ha ganado el juego!");
    }
}

    public static void takeTurn(Shikigami currentPlayer, Shikigami opponentPlayer, Scanner scanner) {
    System.out.println("Turno de " + currentPlayer.getName());

    System.out.println("Habilidades disponibles:");
    if (currentPlayer instanceof Yotohime) {
        System.out.println("1. Cursed Blade");
        System.out.println("2. Ghostly Blade");
    } else if (currentPlayer instanceof Asura) {
        System.out.println("1. Annihilation Flames");
        System.out.println("2. Mighty Crush");
        System.out.println("3. Inferno Slaughter");
    }

    System.out.print("Elige una habilidad (1, 2, etc.): ");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            if (currentPlayer instanceof Yotohime) {
                ((Yotohime) currentPlayer).cursedBlade(opponentPlayer);
            } else if (currentPlayer instanceof Asura) {
                ((Asura) currentPlayer).annihilationFlames(opponentPlayer);
            }
            break;
        case 2:
             if (currentPlayer instanceof Yotohime) {
        Yotohime yotohime = (Yotohime) currentPlayer;
        if (yotohime.getCritical() >= 350) {
            yotohime.enterGloriousBladeState();
            System.out.println("Yotohime entra en el estado Glorious Blade debido al incremento de su Crit DMG.");
        } else {
            yotohime.increaseCritDamageByPercentage(10);
            System.out.println("Yotohime aumenta su Crit DMG por un golpe crítico.");
        }
    } else if (currentPlayer instanceof Asura) {
        ((Asura) currentPlayer).useMightyCrush(opponentPlayer);
    }
            break;
        case 3:
            if (currentPlayer instanceof Asura) {
                ((Asura) currentPlayer).useInfernoSlaughter(opponentPlayer);
            }
            break;
        default:
            System.out.println("Habilidad no válida.");
            break;
    }
}
    
    
}

