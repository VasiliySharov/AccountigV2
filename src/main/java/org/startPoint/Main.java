package org.startPoint;

import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.MainFrame;
import org.uiModules.mainTable.v2.MainTable;
import org.uiModules.menu.Menu;
import org.uiModules.resultDataPanel.ResultDataPanel;

public class Main {
    public static void main(String[] args) {
        MainTable mainTable = new MainTable();
        Menu menu = new Menu(mainTable); // pass table to be able to call loadFile().
        MainFrame mainFrame = new MainFrame(menu, mainTable, new BottomControlBar(), new ResultDataPanel());

    }
}
