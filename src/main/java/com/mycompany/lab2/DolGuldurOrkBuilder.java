package com.mycompany.lab2;

public class DolGuldurOrkBuilder extends OrkBuilder {
    
    public DolGuldurOrkBuilder() {
        gearFactory = new DolGuldurGearFactory();
    }

    @Override
    public void buildStrength() {
        ork.setStrength(50);
    }

    @Override
    public void buildAgility() {
        ork.setAgility(50);
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(50);
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
       ork.setTribe("Племя Дол Гулдур");
    }
    
}
