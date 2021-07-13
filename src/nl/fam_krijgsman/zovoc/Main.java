package nl.fam_krijgsman.zovoc;

import nl.fam_krijgsman.zovoc.mvc.UserLogin;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    private static void createAndShowGUI() {
        UserLogin.startUserLogin();
    }
}
