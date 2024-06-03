package application;

import application.BudgetApp;

import javax.swing.SwingUtilities;

public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetApp::new);
    }
}
