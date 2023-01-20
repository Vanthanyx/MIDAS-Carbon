package midas.carbon.util;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import midas.carbon.MidasCarbon;
import midas.carbon.func.Install8;
import midas.carbon.func.Install11;
import midas.carbon.func.Install16;

public class InstallManager {
    public static void Params(String password, String selectedVersion) {
        if (password.equals("client")) {
            MidasCarbon.progressBar.setVisible(true);
            Verifier.Run();
            switch (selectedVersion) {
                case "1.19.3-1.8":
                    System.out.println("Selected v8");
                    Install8.Run();
                    break;
                case "1.19.3-1.11":
                    System.out.println("Selected v11");
                    Install11.Run();
                    break;
                case "1.19.3-1.16":
                    System.out.println("Selected v16");
                    Install16.Run();
                    break;
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
                        Color barColor = new Color(75, 181, 67);
                        MidasCarbon.progressBar.setValue(100);
                        MidasCarbon.progressBar.setForeground(barColor);
                        MidasCarbon.installButton.setVisible(false);
                        MidasCarbon.versionDropdown.setVisible(false);
                        MidasCarbon.doneButton.setVisible(true);
                    }
                }
            });
            t.start();
        }
    }
}