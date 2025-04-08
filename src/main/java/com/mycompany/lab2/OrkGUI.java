/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nsoko
 */
public class OrkGUI extends JFrame{
    public OrkGUI(){
        super("Лабораторная работа 2");
        JPanel panel = new JPanel();
        JButton startButton = new JButton("Приступить к созданию армии орков");
        JButton exitButton = new JButton("Выход из программы");
        
//        startButton.addActionListener(l);
//        exitButton.addActionListener(l);
//        JPanel treePanel = new JPanel();
//        JPanel infoPanel = new JPanel();
        GUIDesign.startFrameDesign(panel, startButton, exitButton);
        getContentPane().add(panel);
        setBounds(400,150,800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
