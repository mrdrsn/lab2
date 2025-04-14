package com.mycompany.lab2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class OrkGUI extends JFrame {

    private JScrollPane orkTree;

    public OrkGUI() {
        super("Лабораторная работа 2");
        JPanel panel = new JPanel();
        JButton startButton = new JButton("Приступить к созданию армии орков");
        JButton exitButton = new JButton("Выход из программы");

        add(startButton);
        add(exitButton);

        startButton.addActionListener((ActionEvent e) -> {
            addMainFrame();
        });

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        GUIDesign.startFrameDesign(panel, startButton, exitButton);
        getContentPane().add(panel);
        setBounds(400, 150, 800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addMainFrame() {
        JFrame mainFrame = new JFrame("Настройка армии");
        JPanel mainPanel = new JPanel();
        JPanel treePanel = new JPanel();
        JPanel cardPanel = GUIDesign.createCardPanel();

        JPanel buttonPanel = new JPanel();
        JPanel orkInfoPanel = new JPanel(new BorderLayout());
        orkInfoPanel.setBackground(Color.WHITE);

        ArrayList<JComponent> tribeSet = createTribeList();
        ArrayList<JComponent> typeSet = createTypeList();

        JButton createMordorOrk = (JButton) tribeSet.get(1);
        JButton createDolGuldurOrk = (JButton) tribeSet.get(2);
        JButton createMistyMountainsOrk = (JButton) tribeSet.get(3);
        addToPanel(tribeSet, buttonPanel);
        GUIDesign.setNewLayout(buttonPanel, 4);

        createMordorOrk.addActionListener((ActionEvent e)
                -> handleTribeButtonAction(buttonPanel, typeSet, createMordorOrk.getText())
        );
        createDolGuldurOrk.addActionListener((ActionEvent e)
                -> handleTribeButtonAction(buttonPanel, typeSet, createDolGuldurOrk.getText())
        );
        createMistyMountainsOrk.addActionListener((ActionEvent e)
                -> handleTribeButtonAction(buttonPanel, typeSet, createMistyMountainsOrk.getText())
        );

        JButton baseOrkButton = (JButton) typeSet.get(1);
        JButton scoutOrkButton = (JButton) typeSet.get(2);
        JButton leaderOrkButton = (JButton) typeSet.get(3);
        JButton backTribeButton = (JButton) typeSet.get(4);

        baseOrkButton.addActionListener((ActionEvent e) -> {
            handleTypeButtonAction(baseOrkButton);
        });
        scoutOrkButton.addActionListener((ActionEvent e) -> {
            handleTypeButtonAction(scoutOrkButton);
        });
        leaderOrkButton.addActionListener((ActionEvent e) -> {
            handleTypeButtonAction(leaderOrkButton);
        });
        backTribeButton.addActionListener((ActionEvent e) -> {
            Controller.resetOrkStaff();
            clearPanel(buttonPanel);
            addToPanel(tribeSet, buttonPanel);
            GUIDesign.setNewLayout(buttonPanel, 4);
        });

        orkTree = TreeModelCreator.createArmyTree();
        treePanel.add(orkTree);

        cardPanel.add(buttonPanel, "BUTTON_PANEL");
        cardPanel.add(orkInfoPanel, "ORK_INFO_PANEL");

        JPanel flagAndHornPanel = new JPanel(new GridLayout(2, 1)); // 2 строки, 1 колонка
        flagAndHornPanel.setBackground(Color.LIGHT_GRAY);

        JLabel flagLabel = new JLabel("Знамя: ");
        JLabel hornLabel = new JLabel("Горн: ");

        flagAndHornPanel.add(flagLabel);
        flagAndHornPanel.add(hornLabel);
        JButton backButton = new JButton("Вернуться обратно к созданию орка");
        backButton.addActionListener((ActionEvent e) -> {
//            Controller.resetOrkStaff(); // Сброс состояния контроллера
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "BUTTON_PANEL"); // Показываем панель с кнопками
        });

        JTree tree = (JTree) orkTree.getViewport().getView();
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Проверяем двойной клик
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                        Ork selectedOrk = (Ork) selectedNode.getUserObject();
                        displayOrkInfo(cardPanel, selectedOrk, backButton); // Отображаем информацию об орке
                    }
                }
            }
        });

        GUIDesign.setDiviationDesign(mainPanel, treePanel, cardPanel);
        mainFrame.add(mainPanel);
        mainFrame.setBounds(400, 150, 800, 600);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void clearPanel(JPanel panelToClear) {
        panelToClear.removeAll();
        panelToClear.revalidate();
        panelToClear.repaint();
    }


    private ArrayList<JComponent> createTribeList() {
        ArrayList<JComponent> tribeSet = new ArrayList<>();

        JButton createMordorOrk = new JButton("Племя Мордор");
        JButton createDolGuldurOrk = new JButton("Племя Дол Гулдур");
        JButton createMistyMountainsOrk = new JButton("Племя Мглистые Горы");
        JLabel chooseTribe = new JLabel("Выберите племя...");
        chooseTribe.setHorizontalAlignment(SwingConstants.CENTER);

        tribeSet.add(chooseTribe);
        tribeSet.add(createMordorOrk);
        tribeSet.add(createDolGuldurOrk);
        tribeSet.add(createMistyMountainsOrk);

        return tribeSet;
    }

    private ArrayList<JComponent> createTypeList() {
        ArrayList<JComponent> typeSet = new ArrayList<>();

        JButton basikOrkButton = new JButton("Базовый орк");
        JButton scoutOrkButton = new JButton("Орк-разведчик");
        JButton leaderOrkButton = new JButton("Орк-командир");
        JLabel chooseType = new JLabel("Выберите тип орка...");
        JButton backButton = new JButton("Вернуться к выбору племени...");
        backButton.setPreferredSize(new Dimension(50, 25));
        chooseType.setHorizontalAlignment(SwingConstants.CENTER);

        typeSet.add(chooseType);
        typeSet.add(basikOrkButton);
        typeSet.add(scoutOrkButton);
        typeSet.add(leaderOrkButton);
        typeSet.add(backButton);

        return typeSet;
    }

    private void addToPanel(ArrayList<JComponent> list, JPanel panelToAdd) {
        for (JComponent component : list) {
            panelToAdd.add(component);
        }
    }

    private void handleTribeButtonAction(JPanel buttonPanel, ArrayList<JComponent> typeSet, String tribeName) {
        clearPanel(buttonPanel); 
        addToPanel(typeSet, buttonPanel); 
        Controller.tribeButtonPressed(tribeName); 
        TreeModelCreator.addTribeRoot(orkTree, tribeName);
        GUIDesign.setNewLayout(buttonPanel, 5);
    }

    private void handleTypeButtonAction(JButton typeButton) {
        Controller.typeButtonPressed(typeButton.getText());
        String tribeName = Controller.getTribe();
        Ork orkFromController = Controller.getOrk();
        TreeModelCreator.addOrkRoot(orkTree, orkFromController, tribeName);
    }

    private void displayOrkInfo(JPanel cardPanel, Ork ork, JButton backButton) {
        JPanel orkInfoPanel = (JPanel) cardPanel.getComponent(1); // ORK_INFO_PANEL

        orkInfoPanel.removeAll();

        JPanel detailsPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailsPanel.add(new JLabel("Клан: " + ork.getTribe()));
        detailsPanel.add(new JLabel("Тип орка: " + ork.getType()));

        detailsPanel.add(new JLabel("Оружие: " + ork.getWeapon().getName()));
        detailsPanel.add(new JLabel("Броня: " + ork.getArmor().getName()));

        JProgressBar strengthBar = new JProgressBar(0, 100);
        JProgressBar agilityBar = new JProgressBar(0, 100);
        JProgressBar intelligenceBar = new JProgressBar(0, 50);
        JProgressBar healthBar = new JProgressBar(50, 200);

        strengthBar.setValue(ork.getStrength());
        agilityBar.setValue(ork.getAgility());
        intelligenceBar.setValue(ork.getIntelligence());
        healthBar.setValue(ork.getHealth());

        detailsPanel.add(new JLabel("Сила: "));
        detailsPanel.add(strengthBar);
        detailsPanel.add(new JLabel("Ловкость: "));
        detailsPanel.add(agilityBar);
        detailsPanel.add(new JLabel("Интеллект: "));
        detailsPanel.add(intelligenceBar);
        detailsPanel.add(new JLabel("Здоровье: "));
        detailsPanel.add(healthBar);

        orkInfoPanel.add(detailsPanel, BorderLayout.CENTER);

        backButton.addActionListener((ActionEvent e) -> {
            GUIDesign.showCard(cardPanel, "BUTTON_PANEL"); 
        });
        orkInfoPanel.add(backButton, BorderLayout.SOUTH);
        orkInfoPanel.revalidate();
        orkInfoPanel.repaint();

        GUIDesign.showCard(cardPanel, "ORK_INFO_PANEL");
    }

}
