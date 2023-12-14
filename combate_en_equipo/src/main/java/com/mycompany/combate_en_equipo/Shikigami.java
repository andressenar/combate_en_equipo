/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combate_en_equipo;

/**
 *
 * @author felii_000
 */
public class Shikigami {
    private String name;
    private int attack;
    private int healthPoints;
    private int defense;
    private int speed;
    private int critical;
    private int critDamage;
    private int effectHit;
    private int effectRes;
    private int maxHealthPoints;

    public Shikigami(int attack, int healthPoints, int defense, int speed, int critical, int critDamage, int effectHit, int effectRes) {
        this.name = name;
        this.attack = attack;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.speed = speed;
        this.critical = critical;
        this.critDamage = critDamage;
        this.effectHit = effectHit;
        this.effectRes = effectRes;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(int critDamage) {
        this.critDamage = critDamage;
    }

    public int getEffectHit() {
        return effectHit;
    }

    public void setEffectHit(int effectHit) {
        this.effectHit = effectHit;
    }

    public int getEffectRes() {
        return effectRes;
    }

    public void setEffectRes(int effectRes) {
        this.effectRes = effectRes;
    }
    
    
     public void receiveDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
        System.out.println(this.getName() + " recibe " + damage + " de daño.");
        if (this.healthPoints == 0) {
            System.out.println(this.getName() + " ha sido derrotado.");
        }
    }
     
     public void decreaseAttackByPercentage(double percentage) {
        int newAttack = (int) (this.attack * (1 - (percentage / 100)));
        this.attack = newAttack;
        System.out.println(this.getName() + " ve su ataque reducido en " + percentage + "%.");
    }
     
     public Shikigami(int healthPoints) {
        this.maxHealthPoints = healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }
    
     public void increaseCritDamageByPercentage(int percentage) {
        this.critDamage += this.critDamage * (percentage / 100);
        if (this.critDamage > 350) {
            this.critDamage = 350;
        }
    }
}