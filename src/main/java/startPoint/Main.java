package startPoint;

import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.MainFrame;
import org.uiModules.controller.DataFlowController;
import org.uiModules.mainTable.v2.MainTable;
import org.uiModules.menu.Menu;
import org.uiModules.resultDataPanel.ResultDataPanel;

public class Main {
    public static void main(String[] args) {
        MainTable mainTable = new MainTable();
        BottomControlBar bottomControlBar = new BottomControlBar();
        ResultDataPanel resultDataPanel = new ResultDataPanel();

        DataFlowController dataFlowController = new DataFlowController(mainTable, bottomControlBar, resultDataPanel);




        Menu menu = new Menu(dataFlowController); // pass table to be able to call loadFile().


        MainFrame mainFrame = new MainFrame(menu, mainTable, bottomControlBar, resultDataPanel);

    }
}
