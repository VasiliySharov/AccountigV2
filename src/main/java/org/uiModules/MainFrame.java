package org.uiModules;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
//    private final JFrame mainFrame = new JFrame();

    public MainFrame(JMenuBar jMenuBar, JPanel mainTable,
                     JToolBar bottomControlBar, JPanel resultDataPanel) {
        setJMenuBar(jMenuBar);
        getContentPane().add(mainTable, BorderLayout.CENTER);
        getContentPane().add(bottomControlBar, BorderLayout.NORTH);
        getContentPane().add(resultDataPanel, BorderLayout.SOUTH);

        setMinimumSize(new Dimension(500, 500));

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
