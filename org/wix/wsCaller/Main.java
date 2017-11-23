package org.wix.wsCaller;

import javax.swing.*;
import java.awt.*;

/**
 * java编写WebService本地测试类
 */
public class Main {
    boolean packFrame = false;

    //Construct the application
    public Main() {
        MainFrame frame = new MainFrame();
        //Validate frames that have preset sizes
        //Pack frames that have useful preferred size info, e.g. from their layout
        if (packFrame) {
            frame.pack();
        } else {
            frame.validate();
        }
        //Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    //Main method
    public static void main(String[] args) {
        try {
            String version = System.getProperty("java.vm.version");
            if (version != null) {
                // check jvm version, we need 1.3 or later
                try {
                    int i = version.indexOf('.');
                    int v1 = Integer.parseInt(version.substring(0, i));
                    int j = version.indexOf('.', i + 1);
                    int v2 = Integer.parseInt(version.substring(i + 1, j));
                    if (v1 < 1 || (v1 == 1 && v2 < 3)) {
                        JOptionPane.showMessageDialog(null,
                                "Need Java VM version 1.3 or later.",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.exit(-1);
                    }
                } catch (Exception ex) {
                }
            }
            UIManager.setLookAndFeel(UIManager.
                    getCrossPlatformLookAndFeelClassName());
            new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}