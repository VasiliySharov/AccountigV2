package org.uiModules.mainTable.v1;

import org.services.tableDataProcessing.DataProcessingImpl;

import javax.swing.*;
import java.util.List;

public class MainTable extends JPanel {
    private List<RowWrapper> rows;
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        setPreferredSize(new Dimension());
//        setAlignmentX(LEFT_ALIGNMENT);

    }
//    public MainTable() { // constructor for test purposes
//        for (int i = 0; i < 5; i++) {
//            RowWrapper row = new RowWrapper(15);
//            add(row);
//        }
//
//    }

    // Implemented
    public void renderRows(List<List<String>> loadedData) {
        DataProcessingImpl dataProcessing = new DataProcessingImpl();
        List<List<String>> processed = dataProcessing.processLoadedFileData(loadedData);

        for (List<String> rowData : processed) {
            RowWrapper rowWrapper = new RowWrapper(rowData); // render logic in NestedRow.
            add(rowWrapper);
        }
    }

    public void createNewRow() {

    }
}
