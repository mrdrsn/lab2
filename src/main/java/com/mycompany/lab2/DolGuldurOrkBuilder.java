package com.mycompany.lab2;

public class DolGuldurOrkBuilder extends OrkBuilder {
    
    public DolGuldurOrkBuilder() {
        gearFactory = new DolGuldurGearFactory();
    }

    @Override
    public void buildStrength() {
        ork.setStrength(getRandomValue(40, 70));
    }

    @Override
    public void buildAgility() {
        ork.setAgility(getRandomValue(40, 70)); 
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(getRandomValue(20, 50));
    }

    @Override
    public void buildHp() {
        ork.setHp(getRandomValue(100, 150)); 
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
       ork.setTribe("Племя Дол Гулдур");
    }
    
}
