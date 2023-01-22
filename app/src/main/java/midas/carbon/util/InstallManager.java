package midas.carbon.util;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import midas.carbon.MidasCarbon;
import midas.carbon.func.Install8;
import midas.carbon.func.Install11;
import midas.carbon.func.Install16;

public class InstallManager {

    public static Color greenColor = new Color(75, 181, 67);
    public static Color redColor = new Color(255, 148, 148);
    public static Color whiteColor = new Color(255, 255, 255);
    public static void Params(String password, String selectedVersion) {
        if (password.equals("lunar")) {
            MidasCarbon.passwordField.setBackground(greenColor);
            MidasCarbon.passwordField.setForeground(whiteColor);
            MidasCarbon.progressBar.setVisible(true);
            Verifier.Run();
            switch (selectedVersion) {
                case "1.19.2-0.8":
                    System.out.println("Selected v8");
                    Install8.Run();
                    break;
                case "1.19.2-0.11":
                    System.out.println("Selected v11");
                    Install11.Run();
                    break;
                case "1.19.2-0.16":
                    System.out.println("Selected v16");
                    Install16.Run();
                    break;
                default:
                    System.out.println("Selected v8, by default");
                    Install8.Run();
            }
            MidasCarbon.progressBar.setValue(40);
            Thread t = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i <= 40; i++) {
                        final int currentValue = i;
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                MidasCarbon.progressBar.setValue(currentValue);
                            }
                        });
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(null, "Progress bar increment failed.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                    for (int i = 40; i <= 80; i++) {
                        final int currentValue = i;
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                MidasCarbon.progressBar.setValue(currentValue);
                            }
                        });
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(null, "Progress bar increment failed.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                    for (int i = 80; i <= 99; i++) {
                        final int currentValue = i;
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                MidasCarbon.progressBar.setValue(currentValue);
                            }
                        });
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(null, "Progress bar increment failed.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    }
                    for (int i = 99; i <= 100; i++) {
                        MidasCarbon.progressBar.setValue(100);
                        MidasCarbon.progressBar.setForeground(greenColor);
                        MidasCarbon.installButton.setVisible(false);
                        MidasCarbon.versionDropdown.setVisible(false);
                        MidasCarbon.doneButton.setVisible(true);
                    }
                }
            });
            t.start();
        } else {
            MidasCarbon.passwordField.setBackground(redColor);
            MidasCarbon.passwordField.setForeground(whiteColor);
        }
    }
}