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
        ork.setStrength(50);
    }

    @Override
    public void buildAgility() {
        ork.setAgility(80);
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(20);
    }

    @Override
    public void buildHp() {
        ork.setHp(200);
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
