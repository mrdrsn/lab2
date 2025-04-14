/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author nsoko
 */
public class OrkDirector {
    private OrkBuilder orkBuilder;
    public void setOrkBuilder(OrkBuilder ob){
        this.orkBuilder = ob;
    }
    public Ork getOrk(){
       return orkBuilder.getOrk();
    }
    public void createBasicOrk(){
        orkBuilder.createNewOrk();
        orkBuilder.buildType("Базовый орк");
        orkBuilder.buildTribe();
        orkBuilder.buildName();
        orkBuilder.buildStrength();
        orkBuilder.buildAgility();
        orkBuilder.buildIntelligence();
        orkBuilder.buildHp();
        orkBuilder.buildWeapon();
        orkBuilder.buildArmor();
    }
    public void createScoutOrk(){
        createBasicOrk();
        orkBuilder.buildType("Орк-разведчик");
        orkBuilder.buildBow();
    }
    public void createLeaderOrk(){
        createBasicOrk();
        orkBuilder.buildType("Орк-командир");
        orkBuilder.buildBanner();
        orkBuilder.buildHorn();
    }
}
