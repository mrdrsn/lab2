/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author nsoko
 */
public class OrkBuilderFactory {
    public static OrkBuilder createOrkBuilder(String tride){
        switch(tride){
            case "Mordor" -> { 
                return new MordorOrkBuilder();
            }
            case "Dol Guldur" -> {
                return new DolGuldurOrkBuilder();
            }
            case "Misty Mountains" -> {
                return new MistyMountainsOrkBuilder();
            }
            default ->{
                return null;
            }
        }
    }
}
