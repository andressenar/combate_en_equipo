/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combate_en_equipo;

/**
 *
 * @author felii_000
 */
public class Yotohime extends Shikigami {
private int onibi;
    public Yotohime(int attack, int healthPoints, int defense, int speed, int critical, int critDamage, int effectHit, int effectRes) {
        super(attack, healthPoints, defense, speed, critical, critDamage, effectHit, effectRes);
        this.onibi = 0;
    }
     private boolean ghostlyBladeActive;
    private static final int CRIT_DAMAGE_THRESHOLD = 350; 
    public void cursedBlade(Shikigami enemy) {
    if (onibi >= 0) {
        int damage = (int) (getAttack() * 1.2);

        enemy.receiveDamage(damage);

        System.out.println("Yotohime usa Cursed Blade y causa " + damage + " de daño.");
    } else {
        System.out.println("No hay suficientes orbes para usar Cursed Blade.");
    }
}
    private boolean gloriousBladeActive;
    private int onibiCount;


    public void enterGloriousBladeState() {
        if (!gloriousBladeActive) {
            gloriousBladeActive = true;
            System.out.println("Yotohime entra en el estado Glorious Blade.");
        }
    }

    public void dazzlingCleave(Shikigami enemy) {
    if (gloriousBladeActive && onibi >= 3) {
        int damagePerStrike = (int) (0.8 * getAttack());
        
        for (int i = 0; i < 6; i++) {
            int ignoredDefense = (int) (enemy.getDefense() * 0.5);
            int finalDamage = Math.max(0, damagePerStrike - ignoredDefense);

            enemy.receiveDamage(finalDamage);
            System.out.println("Yotohime realiza un golpe de Dazzling Cleave causando " + finalDamage + " de daño a " + enemy.getName());
        }

        resetOnibiCount();
        gloriousBladeActive = false;
    } else {
        System.out.println("No se cumplen las condiciones para usar Dazzling Cleave.");
    }
}

    private void resetOnibiCount() {
        onibiCount = 0;
        System.out.println("El contador de Onibi ha sido reiniciado.");
    }
public void savageCombo(Shikigami enemy) {
        if (onibiCount >= 3) {
            int damagePerStrike = (int) (0.58 * getAttack());

            for (int i = 0; i < 6; i++) {
                enemy.receiveDamage(damagePerStrike);
                System.out.println("Yotohime realiza un golpe de Savage Combo causando " + damagePerStrike + " de daño.");
            }

            resetOnibiCount();
        } else {
            System.out.println("No hay suficientes Onibi para usar Savage Combo.");
        }
    }
@Override
 public void increaseCritDamageByPercentage(int percentage) {
         int newCritDamage = getCritDamage() + percentage;
        setCritDamage(newCritDamage);
        System.out.println(getName() + " aumenta su daño crítico en " + percentage + "%.");
    
    }
public void evaluateGhostlyBlade() {
        if (getCritical() >= CRIT_DAMAGE_THRESHOLD && !ghostlyBladeActive) {
            ghostlyBladeActive = true;
            increaseCritDamageByPercentage(15);
            System.out.println(getName() + " activa Ghostly Blade.");
        }
    }

}
