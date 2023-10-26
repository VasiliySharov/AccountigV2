package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedRow extends JPanel{
    private int height = 0;
    private int width = 0;
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        setMinimumSize(new Dimension(250, 40));
//        setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.red),
//                getBorder()));
    }

    public NestedRow(int numberOfColumns) { // constructor for creating empty rows for test purposes
        List<JTextField> columns = new ArrayList<>();
        JComboBox<String> stringJComboBox = new JComboBox<>(new String[]{"USD", "EUR", "RUB"});

        add(stringJComboBox);
        for (int i = 0; i <= numberOfColumns; i++) {
            JTextField field = new JTextField("field N"+i);
            field.setFont(field.getFont().deriveFont(0,18));
            int width = field.getPreferredSize().width;
            int height = field.getPreferredSize().height;
            if  (height>this.height) this.height = height;

            this.width += width;

            field.setPreferredSize(new Dimension(width, height));
            columns.add(field);
            add(field);
        }

    }
    public NestedRow(List<String> rowData) {  // constructor for creating rows filled with data

    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
