/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author nsoko
 */
public class MordorOrkBuilder extends OrkBuilder{

    public MordorOrkBuilder() {
        gearFactory = new MordorGearFactory();
    }
    
     @Override
    public void buildStrength() {
        ork.setStrength(getRandomValue(70, 100));
    }

    @Override
    public void buildAgility() {
        ork.setAgility(getRandomValue(1, 40)); 
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(getRandomValue(1, 20)); 
    }

    @Override
    public void buildHp() {
        ork.setHp(getRandomValue(150, 200)); 
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
        ork.setTribe("Племя Мордор");
    }
    
}
