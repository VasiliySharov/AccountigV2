package org.uiModules.mainTable;

import javax.swing.*;
import java.awt.*;

public class MainTable extends JPanel {
    Row row;
    public MainTable() {
//        super(new BoxLayout(this,BoxLayout.X_AXIS));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        setLayout(new ScrollPaneLayout());
        row = new Row();
        add(row);
    }
}
