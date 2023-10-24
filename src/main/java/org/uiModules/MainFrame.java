package org.uiModules;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private final JFrame mainFrame = new JFrame();

    public MainFrame(JMenuBar jMenuBar, JPanel mainTable,
                     JToolBar bottomControlBar, JPanel resultDataPanel) {
        mainFrame.setJMenuBar(jMenuBar);
        mainFrame.add(mainTable);
        mainFrame.add(bottomControlBar);
        mainFrame.add(resultDataPanel);

        mainFrame.setMinimumSize(new Dimension(0, 500));
//        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
