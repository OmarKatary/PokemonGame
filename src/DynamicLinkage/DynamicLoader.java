/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicLinkage;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ahmed
 */
public class DynamicLoader {

    String JarPath;

    public DynamicLoader(String JarPath) {
        this.JarPath = JarPath;

    }

    public void start() throws IOException {

        JarFile jarFile = null;
        jarFile = new JarFile(JarPath);

        Enumeration<JarEntry> e = jarFile.entries();
        //System.out.println(e.nextElement().toString());
        URL[] urls = {new URL("jar:file:" + JarPath + "!/")};
        //System.out.println(urls.toString());
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().contains("Pikachu")) {
                //System.out.println(je.getName());
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            //System.out.println("CN: "+className);
            Class<? extends LoadableCharacters> c = null;
            try {
                c = (Class<? extends LoadableCharacters>) cl.loadClass(className);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DynamicLoader.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

}
