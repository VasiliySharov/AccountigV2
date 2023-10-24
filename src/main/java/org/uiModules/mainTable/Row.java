package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;

public class Row extends JPanel {
    public Row() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel nested = new NestedRow();
        add(nested);


    }
}
