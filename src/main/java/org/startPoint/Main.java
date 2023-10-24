package org.startPoint;

import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.MainFrame;
import org.uiModules.mainTable.MainTable;
import org.uiModules.menu.Menu;
import org.uiModules.resultDataPanel.ResultDataPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(new Menu(), new MainTable(), new BottomControlBar(), new ResultDataPanel());

    }
}
