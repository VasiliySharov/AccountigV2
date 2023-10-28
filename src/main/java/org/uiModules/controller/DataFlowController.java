package org.uiModules.controller;

import org.services.fileSavingAndLoadingLogic.table_IO.FileLoaderContext;
import org.services.tableDataProcessing.DataProcessing;
import org.services.tableDataProcessing.DataProcessingImpl;
import org.uiModules.bottomControlBar.BottomControlBar;
import org.uiModules.mainTable.v2.MainTable;
import org.uiModules.resultDataPanel.ResultDataPanel;

import java.io.File;
import java.nio.file.Path;
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

    public void loadData(Path selectedFile, String fileFormat) {
        Vector<Vector<String>> loadedData = new FileLoaderContext(selectedFile, fileFormat).loadFile();

        DataProcessing dataProcessing = new DataProcessingImpl();

        // loading Users from a separate file and make calculations on loadedData
        dataProcessing.processLoadedFileData(loadedData);

        mainTable.renderRows(dataProcessing.getTableData());
        resultDataPanel.renderData(dataProcessing.getResultPanelData());
    }
}
