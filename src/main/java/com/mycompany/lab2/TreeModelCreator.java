package com.mycompany.lab2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class TreeModelCreator {

    public static JScrollPane createArmyTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Армия Мордора");
        JTree myOrkTree = new JTree(root);
        myOrkTree.setPreferredSize(new Dimension(250, 600));
        myOrkTree.setBackground(Color.LIGHT_GRAY);
        myOrkTree.setCellRenderer(new CustomTreeCellRenderer());
        JScrollPane scrollPane = new JScrollPane(myOrkTree);
        scrollPane.setPreferredSize(new Dimension(250, 600)); 

        return scrollPane;
    }

    public static void addTribeRoot(JScrollPane orkScroll, String tribe) {
        JTree orkTree = (JTree) orkScroll.getViewport().getView();
        if (isNodeExists(orkTree, tribe)) {
            return;
        }
        DefaultMutableTreeNode newTribe = new DefaultMutableTreeNode(tribe);
        DefaultTreeModel model = (DefaultTreeModel) orkTree.getModel();
        DefaultMutableTreeNode mainRoot = (DefaultMutableTreeNode) model.getRoot();
        model.insertNodeInto(newTribe, mainRoot, mainRoot.getChildCount());
        model.reload(mainRoot);
    }

    public static void addOrkRoot(JScrollPane orkScroll, Ork orkFromController, String tribeName) {
        JTree orkTree = (JTree) orkScroll.getViewport().getView();

        DefaultMutableTreeNode newOrk = new DefaultMutableTreeNode(orkFromController);

        DefaultTreeModel model = (DefaultTreeModel) orkTree.getModel();

        DefaultMutableTreeNode mainRoot = (DefaultMutableTreeNode) model.getRoot();

        DefaultMutableTreeNode tribeNode = null;
        for (int i = 0; i < mainRoot.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) mainRoot.getChildAt(i);
            if (child.getUserObject().toString().equals(tribeName)) {
                tribeNode = child;
                break;
            }
        }

        if (tribeNode != null) {
            model.insertNodeInto(newOrk, tribeNode, tribeNode.getChildCount());
            model.reload(tribeNode); // Обновляем отображение
        } else {
            System.out.println("Племя '" + tribeName + "' не найдено!");
        }
    }

    private static boolean isNodeExists(JTree tree, String nodeName) {
        TreeModel model = tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        return searchNode(root, nodeName);
    }

    private static boolean searchNode(DefaultMutableTreeNode node, String nodeName) {
        if (node.getUserObject().toString().equals(nodeName)) {
            return true;
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            if (searchNode(child, nodeName)) {
                return true;
            }
        }
        return false;
    }

    private static class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);

            setBackgroundNonSelectionColor(Color.LIGHT_GRAY);
            setForeground(Color.WHITE); // Цвет текста для неактивных узлов

            setBackgroundSelectionColor(Color.DARK_GRAY);
            setTextSelectionColor(Color.WHITE);

            return this;
        }
    }
}
