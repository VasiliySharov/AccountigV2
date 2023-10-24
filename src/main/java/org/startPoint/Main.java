package org.startPoint;

import org.fileSavingandLoadingLogic.TextFileLoader;
import org.fileSavingandLoadingLogic.TextFileSaver;
import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.MainFrame;
import org.uiModules.mainTable.MainTable;
import org.uiModules.menu.Menu;
import org.uiModules.resultDataPanel.ResultDataPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        MainFrame mainFrame = new MainFrame(menu, new MainTable(), new BottomControlBar(), new ResultDataPanel());

    }
}
