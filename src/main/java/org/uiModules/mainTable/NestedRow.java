package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;

public class NestedRow extends JPanel{
    public NestedRow() {
        JTextField field1 = new JTextField("asd");
        add(field1);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setMaximumSize(new Dimension(200, 30));
    }
//        add(Box.createHorizontalGlue());



}
