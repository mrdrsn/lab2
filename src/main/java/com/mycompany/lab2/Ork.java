package com.mycompany.lab2;

public class Ork {
    private String name;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private Horn horn;
    private int strength;
    private int agility;
    private int intelligence;
    private int hp;
    
    public void setName(String name){
        this.name = name;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public void setBanner(Banner banner){
        this.banner = banner;
    }
    public void setHorn(Horn horn){
        this.horn = horn;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    
    @Override
    public String toString(){
        return this.name + "\nСила: " + this.strength + "\nЛовкость: " + this.agility + "\nИнтеллект: " + this.intelligence +
                "\nЗдоровье: " + this.hp + "\nОружие: " + this.weapon + "\nБроня: " + this.armor + "\nЗнамя: " + (this.banner == null ? "У этого орка нет знамени!" : this.banner) + 
                "\nГорн: " + (this.horn == null ? "У этого орка нет горна!" : this.horn); 
                
    }
         
}
