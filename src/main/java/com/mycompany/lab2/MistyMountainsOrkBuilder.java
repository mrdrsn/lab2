/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author nsoko
 */
public class MistyMountainsOrkBuilder extends OrkBuilder {

    public MistyMountainsOrkBuilder() {
        gearFactory = new MistyMountainsGearFactory();
    }

    @Override
    public void buildStrength() {
        ork.setStrength(getRandomValue(1, 40)); // Низкая сила
    }

    @Override
    public void buildAgility() {
        ork.setAgility(getRandomValue(70, 100)); // Высокая ловкость
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(getRandomValue(1, 15)); // Очень низкий интеллект
    }

    @Override
    public void buildHp() {
        ork.setHp(getRandomValue(50, 100)); // Низкое здоровье
    }

    
    @Override
    public void buildWeapon() {
        ork.setWeapon(gearFactory.createWeapon());
    }

    @Override
    public void buildArmor() {
        ork.setArmor(gearFactory.createArmor());
    }

    @Override
    public void buildBanner() {
        ork.setBanner(gearFactory.createBanner());
    }

    @Override
    public void buildTribe() {
        ork.setTribe("Племя Мглистые Горы");
    }
    
}
