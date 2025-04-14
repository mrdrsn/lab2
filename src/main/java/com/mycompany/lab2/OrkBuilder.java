/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import com.github.javafaker.Faker;

/**
 *
 * @author nsoko
 */
public abstract class OrkBuilder {
    protected OrkGearFactory gearFactory;
    protected Ork ork;
    
    public abstract void buildTribe();
    public abstract void buildStrength();
    public abstract void buildAgility();
    public abstract void buildIntelligence();
    public abstract void buildHp();
    public abstract void buildWeapon();
    public abstract void buildArmor();
    public abstract void buildBanner();
    
    public void buildName(){
        Faker faker = new Faker();
        ork.setName(faker.lordOfTheRings().character());
    }
    public void buildType(String type){
        ork.setType(type);
    }
    public void buildBow(){
        Weapon bow = new Bow();
        ork.setWeapon(bow);
    }
    public void buildHorn(){
        Horn horn = new Horn();
        ork.setHorn(horn);
    }
    public Ork getOrk(){
        return ork;
    }
    public void createNewOrk(){
       ork = new Ork();
    }
}
