package com.mycompany.lab2;

public class DolGuldurOrkBuilder extends OrkBuilder {
    
    public DolGuldurOrkBuilder() {
        gearFactory = new DolGuldurGearFactory();
    }

    @Override
    public void buildStrength() {
        ork.setStrength(getRandomValue(40, 70)); // Сбалансированная сила
    }

    @Override
    public void buildAgility() {
        ork.setAgility(getRandomValue(40, 70)); // Сбалансированная ловкость
    }

    @Override
    public void buildIntelligence() {
        ork.setIntelligence(getRandomValue(20, 50)); // Умеренный интеллект
    }

    @Override
    public void buildHp() {
        ork.setHp(getRandomValue(100, 150)); // Среднее здоровье
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
