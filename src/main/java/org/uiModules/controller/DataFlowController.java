package org.uiModules.controller;

import org.services.tableDataProcessing.DataProcessing;
import org.services.tableDataProcessing.DataProcessingImpl;
import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.mainTable.v2.MainTable;
import org.uiModules.resultDataPanel.ResultDataPanel;

import java.util.Vector;

public class DataFlowController {
    private final MainTable mainTable;
    private final BottomControlBar bottomControlBar;
    private final ResultDataPanel resultDataPanel;

    public DataFlowController(MainTable mainTable, BottomControlBar bottomControlBar, ResultDataPanel resultDataPanel) {
        this.mainTable = mainTable;
        this.bottomControlBar = bottomControlBar;
        this.resultDataPanel = resultDataPanel;
    }

    public void loadData(Vector<Vector<String>> loadedData) {
        DataProcessing dataProcessing = new DataProcessingImpl();
        dataProcessing.processLoadedFileData(loadedData);

        mainTable.renderRows(loadedData);
    }
}
