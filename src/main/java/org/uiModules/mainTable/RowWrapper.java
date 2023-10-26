package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// use this wrapper class for proper arrangement layouts
public class RowWrapper extends JPanel {
    {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));


//        setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.red),
//                getBorder()));
    }
    public RowWrapper(int numberOfColumns) { // constructor for creating empty rows for test purposes
        JPanel nested = new NestedRow(numberOfColumns);
        add(nested);
        setMaximumSize(new Dimension(nested.getWidth(), nested.getHeight()));
    }
    public RowWrapper(List<String> rowData) { // constructor for creating rows filled with data. logic for filling is in NestedRow.
        JPanel nested = new NestedRow(rowData);
        add(nested);
        setMaximumSize(new Dimension(nested.getWidth(), nested.getHeight()));
    }
}
