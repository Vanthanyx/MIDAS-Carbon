package midas.carbon;

import javax.swing.*;
import java.awt.event.*;
import midas.carbon.util.*;

public class MidasCarbon extends JFrame {
    public static JPasswordField passwordField;
    public static JComboBox<String> versionDropdown;
    public static JButton installButton;
    public static JButton doneButton;
    public static JProgressBar progressBar;

    public MidasCarbon() {
        setTitle("MIDAS Installer");
        setSize(300, 175);
        setLayout(null);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        passwordField = new JPasswordField(20);
        add(passwordField);

        versionDropdown = new JComboBox<>(new String[] { "VERSION", "1.19.2-0.8", "1.19.2-0.11", "1.19.2-0.16" });
        add(versionDropdown);

        progressBar = new JProgressBar();
        add(progressBar);
        progressBar.setVisible(false);

        installButton = new JButton("Install");
        doneButton = new JButton("Done!");
        installButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                String selectedVersion = (String) versionDropdown.getSelectedItem();
                InstallManager.Params(password, selectedVersion);
            }
        });
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        add(installButton);
        add(doneButton);
        doneButton.setVisible(false);

        passwordField.setBounds(40, 10, 200, 25);

        versionDropdown.setBounds(40, 50, 95, 25);

        installButton.setBounds(145, 50, 95, 25);
        doneButton.setBounds(40, 50, 200, 25);

        progressBar.setBounds(40, 90, 200, 25);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MidasCarbon();
    }
}
