package midas.carbon.util;

import java.io.File;
import java.nio.file.*;
import javax.swing.JOptionPane;
import midas.carbon.MidasCarbon;

public class Verifier {
    public static void Run() {

        File mcFolder = new File(System.getenv("APPDATA"), "\\.minecraft");
        File mdFolder = new File(System.getenv("APPDATA"), "\\.minecraft\\mods");
        File instFolder = new File(System.getenv("APPDATA"), "\\.minecraft\\mods\\MIDAS-INSTANCE-STORAGE");

        if (!instFolder.exists()) {
            instFolder.mkdir();
        }

        if (mcFolder.exists() && mcFolder.isDirectory()) {
            if (mdFolder.exists() && mdFolder.isDirectory()) {
                MidasCarbon.progressBar.setValue(10);
                if(mdFolder.exists() && mdFolder.isDirectory() && instFolder.exists() && instFolder.isDirectory()){
                    File[] files = mdFolder.listFiles();
                    for (File file : files) {
                        if (file.isFile()) {
                            File newFile = new File(instFolder, file.getName());
                            if (newFile.exists()) {
                                newFile.delete();
                            }
                            file.renameTo(newFile);
                        }
                    }
                }
                MidasCarbon.progressBar.setValue(20);
            } else {
                mdFolder.mkdir();
                JOptionPane.showMessageDialog(null, "Mods folder not found. Please re-run the installer!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Minecraft folder not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}