package org.uiModules.mainTable.v2;

import org.constants.Currencies;
import org.constants.Extensions;
import org.services.users.UserManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.*;

public class MainTable extends JPanel {
    private final DefaultTableModel tableModel;
    private final JTable table;


    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//                setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.red),
//                getBorder()));
        tableModel = new DefaultTableModel(defineColumnNames(), 0);
        table = defineTable();
        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(table.getPreferredSize());
        RowNumberTable rowTable = new RowNumberTable(table); // Numbers on the left side of the table
        jp.setRowHeaderView(rowTable);
        jp.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
//		jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(jp);

    }

    private String[] defineColumnNames() {
        return new String[]{"Supplier", "Holder", "Name",
                "Fraction", "CR Started", "CR Finished",
                "Time Spent", "Time Limit", "Class",
                "ORDER", "Booster 1", "Booster 2", "Full Price",
                "Price(-Fee)", "B1 Profit", "B2 Profit", "Receiver's profit",
                "Paid to", "Currency", "Status", "PAID", "Add. info.",
                "Paid off", "Received on", "Completed on", "Payout Group"};
    }
    private JTable defineTable() {
        JTable table = new JTable(tableModel);
        table.setCellSelectionEnabled(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Make the TableColumns width correspond with the text inside
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            // Add additional spaces on both sides of the column name
            headerValue = headerValue + " ";
            column.setHeaderValue(headerValue);
            Component headerComponent = headerRenderer.getTableCellRendererComponent(
                    table, headerValue, false, false, 0, i);
            int preferredWidth = headerComponent.getPreferredSize().width;
            column.setPreferredWidth(preferredWidth);
        }
        return table;
    }
    private void defineComboBoxHelper(Vector<String> users, JTable table, int columnIndex) {
//        table.getColumnModel().getColumn(columnIndex).setCellEditor(null);
//        tableModel.fireTableDataChanged();

        JComboBox<String> jComboBox = new JComboBox<>(users);
        DefaultCellEditor cellEditor = new DefaultCellEditor(jComboBox);
        table.getColumnModel().getColumn(columnIndex).setCellEditor(cellEditor);
    }
    private void defineAllComboBoxes() {
        defineComboBoxHelper(UserManager.getSuppliersList(), table, 0);
        defineComboBoxHelper(UserManager.getBoostersList(), table, 1);
        defineComboBoxHelper(new Vector<String>(Currencies.CURRENCIES), table, 18);
        defineComboBoxHelper(UserManager.getBoostersList(), table, 10);
        defineComboBoxHelper(UserManager.getBoostersList(), table, 11);
        defineComboBoxHelper(UserManager.getBoostersList(), table, 17);
    }
    public void renderRows(Vector<Vector<String>> loadedData) {
//        table.removeEditor();
        tableModel.setRowCount(0);
//        table.repaint();
        defineAllComboBoxes(); // this method is called after processing to initialize data in UserManager
        setTableData(loadedData);
    }
    public void setTableData(Vector<Vector<String>> loadedData) {
        for(Vector<String> row : loadedData) {
            tableModel.addRow(row);
        }
    }
}
