package com.mycompany.lab2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIDesign {

    public static void startFrameDesign(JPanel panel, JButton button1, JButton button2) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));
        panel.setBackground(Color.decode("#f2eeff"));

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension buttonSize = new Dimension(310, 50);
        button1.setMaximumSize(buttonSize);
        button2.setMaximumSize(buttonSize);

        button1.setBackground(Color.decode("#8e7cc3"));
        button1.setForeground(Color.WHITE);
        button2.setBackground(Color.decode("#8e7cc3"));
        button2.setForeground(Color.WHITE);

        Font customFont = new Font("Arial", Font.BOLD, 14);
        button1.setFont(customFont);
        button2.setFont(customFont);

        panel.add(button1);
        panel.add(Box.createVerticalStrut(20));
        panel.add(button2);
    }

    public static void setDiviationDesign(JPanel mainPanel, JPanel treePanel, JPanel cardPanel) {
        mainPanel.setLayout(new BorderLayout());

        // Настройка левой панели (дерево)
        treePanel.setBackground(Color.LIGHT_GRAY);
        treePanel.setPreferredSize(new Dimension(250, 600));

        // Настройка правой панели (CardLayout)
        cardPanel.setBackground(Color.ORANGE);

        mainPanel.add(treePanel, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
    }

    public static JPanel createCardPanel() {
        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.setBackground(Color.ORANGE);
        return cardPanel;
    }

    public static void addCard(JPanel cardPanel, JPanel panel, String name) {
        cardPanel.add(panel, name);
    }

    public static void showCard(JPanel cardPanel, String name) {
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, name);
    }

    public static void setNewLayout(JPanel panel, int j) {
        panel.setLayout(new GridLayout(j, 1, 10, 10));
        panel.setPreferredSize(new Dimension(250, j * 60));
    }
}
