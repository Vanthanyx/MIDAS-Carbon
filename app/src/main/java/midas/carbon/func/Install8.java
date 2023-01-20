package midas.carbon.func;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import midas.carbon.MidasCarbon;

public class Install8 {
    public static void Run() {
        try {
            URL url = new URL("https://github.com/Vanthanyx/MIDAS-Carbon/blob/master/FINALS/Version8.jar?raw=true");
            InputStream in = url.openStream();
            File mdFile = new File(System.getenv("APPDATA"), "\\.minecraft\\mods\\Verison8.jar");
            FileOutputStream fos = new FileOutputStream(mdFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            in.close();
            fos.close();
            MidasCarbon.progressBar.setValue(30);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to download version 8.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}