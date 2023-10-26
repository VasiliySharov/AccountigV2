package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainTable extends JPanel {
    List<RowWrapper> rows;
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        setPreferredSize(new Dimension());
//        setAlignmentX(LEFT_ALIGNMENT);

    }
    public MainTable() { // constructor for test purposes
        for (int i = 0; i < 5; i++) {
            RowWrapper row = new RowWrapper(15);
            add(row);
        }

    }
    public MainTable(List<List<String>> rowData) {
        // amount of rows to render
        for (List<String> rowDatum : rowData) {
            RowWrapper row = new RowWrapper(rowDatum);
            add(row);
        }
    }

    public void renderRows() {

    }

    public void createNewRow() {

    }
}
