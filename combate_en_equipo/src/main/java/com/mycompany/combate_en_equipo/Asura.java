/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combate_en_equipo;

/**
 *
 * @author felii_000
 */
public class Asura extends Shikigami {
    private int onibi; 
    private int sanity;
    public Asura(int attack, int healthPoints, int defense, int speed, int critical, int critDamage, int effectHit, int effectRes) {
        super(attack, healthPoints, defense, speed, critical, critDamage, effectHit, effectRes);
        this.onibi = 0; 
        this.sanity = 9;
    }

   

    public void annihilationFlames(Shikigami enemy) {
    if (onibi >= 0) {
        int damage = (int) (getAttack() * 1.2);
        enemy.receiveDamage(damage);
        if (enemy.getHealthPoints() <= 0) {
            onibi++;
            applyAnnihilation(enemy);
        }
        System.out.println("Asura usa Annihilation Flames y causa " + damage + " de daño.");
    } else {
        System.out.println("No hay suficientes orbes para usar Annihilation Flames.");
    }
}

private void applyAnnihilation(Shikigami enemy) {
    enemy.decreaseAttackByPercentage(50);
}
    
    public void useMightyCrush(Shikigami enemy) {
        System.out.println(getName() + " usa Mighty Crush.");
        if (sanity < 9) {
            sanity++;
            System.out.println(getName() + " recupera 1 punto de Sanity.");
        }

        if (sanity == 9) {
            System.out.println(getName() + " es inmune a efectos de control este turno.");
        }

        if (sanity < 9) {
            applyControlEffects();
        }

        int enemiesAttacked = 1;
        sanity -= enemiesAttacked;

        int hpRecovered = (int) (getMaxHealthPoints() * 0.08 * (9 - sanity));
        setHealthPoints(getHealthPoints() + hpRecovered);

        double damageReductionPercentage = 0.09 * sanity;
        decreaseDamageTaken(damageReductionPercentage);
    }

    private void applyControlEffects() {
        System.out.println(getName() + " es afectado por efectos de control (sueño, etc.) durante un turno.");
    }

    private void decreaseDamageTaken(double percentage) {
        double newDefense = getDefense() * (1 - percentage);
        setDefense((int) newDefense);
    }
    
    public void useInfernoSlaughter(Shikigami enemy) {
    System.out.println(getName() + " usa Inferno Slaughter.");

    int initialDamage = (int) (getAttack() * 3.15);
    enemy.receiveDamage(initialDamage);
    System.out.println("Asura ataca a " + enemy.getName() + " con un daño inicial de " + initialDamage + ".");

    int followUpDamage = (int) (getAttack() * 0.63);
    while (sanity > 0) {
        enemy.receiveDamage(followUpDamage);
        sanity--;
        System.out.println("Asura realiza un ataque adicional a " + enemy.getName() + " con un daño de " + followUpDamage + ".");

        if (sanity == 0) {
            System.out.println(getName() + " ha consumido todos sus puntos de Sanity.");
        }
    }
}
}



