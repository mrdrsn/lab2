package com.mycompany.lab2;

public class Controller {
    public static OrkBuilder orkBuilder;
    public static OrkDirector orkDirector;
    public static void resetOrkStaff(){
        orkBuilder = null;
        orkDirector.setOrkBuilder(null);
    }
    public static void tribeButtonPressed(String buttonName){
        orkDirector = new OrkDirector();
        switch(buttonName){
            case "Племя Мордор" ->{
                orkBuilder = OrkBuilderFactory.createOrkBuilder("Mordor");
                System.out.println("Создан MordorOrkBuilder");
            }
            case "Племя Дол Гулдур" ->{
                orkBuilder = OrkBuilderFactory.createOrkBuilder("Dol Guldur");
                System.out.println("Создан DolGuldurOrkBuilder");
            }
            case "Племя Мглистые Горы" ->{
                orkBuilder = OrkBuilderFactory.createOrkBuilder("Misty Mountains");
                System.out.println("Создан MistyMountainsOrkBuilder");
            }
        }
        orkDirector.setOrkBuilder(orkBuilder);
    }
    public static void typeButtonPressed(String buttonName){
        switch(buttonName){
            case "Базовый орк" ->{
                orkDirector.createBasicOrk();
                System.out.println("Создан базовый орк + ("+ orkBuilder.getClass() + ")");
                System.out.println(orkDirector.getOrk());
            }
            case "Орк-разведчик" ->{
                orkDirector.createScoutOrk();
                System.out.println("Создан орк-разведчик + (" + orkBuilder.getClass() + ")");
                System.out.println(orkDirector.getOrk());
            }
            case "Орк-командир" ->{
                orkDirector.createLeaderOrk();
                System.out.println("Создан орк-командир + (" + orkBuilder.getClass() + ")");
            }
        }
//        return orkDirector.getOrk();
    }
    public static String getTribe(){
        Ork orkToGet = orkDirector.getOrk();
        return orkToGet.getTribe();
    }
    public static Ork getOrk(){
        return orkDirector.getOrk();
    }
}
