package org.uiModules.menu;

import javax.swing.*;

public class Menu extends JMenuBar {
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem newMenuItem = new JMenuItem("Load");
    private final JMenuItem saveMenuItem = new JMenuItem("Save");
    {
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        add(fileMenu);
    }
}
