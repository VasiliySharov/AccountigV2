package org.uiModules.mainTable.v2;

import org.services.fileSavingAndLoadingLogic.usersHandlers.UsersLoader;
import org.services.users.UserManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class MainTable extends JPanel {
    private final DefaultTableModel tableModel;

    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//                setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.red),
//                getBorder()));
        tableModel = new DefaultTableModel(defineColumnNames(), 0);
        JTable table = defineTable();

        JScrollPane jp = new JScrollPane(table);
        jp.setPreferredSize(table.getPreferredSize());
        RowNumberTable rowTable = new RowNumberTable(table); // Numbers on the left side of the table
        jp.setRowHeaderView(rowTable);
        jp.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());
//		jp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(jp);


        new UsersLoader().loadUsers();
        defineComboBox(UserManager.getSuppliersList(), table, 0);
        defineComboBox(UserManager.getBoostersList(), table, 1);
        defineComboBox(new Vector<String>(Arrays.asList(new String[]{"USD", "EUR", "RUB"})), table, 18);
        defineComboBox(UserManager.getBoostersList(), table, 10);
        defineComboBox(UserManager.getBoostersList(), table, 11);
        defineComboBox(UserManager.getBoostersList(), table, 17);


    }

    private String[] defineColumnNames() {
        return new String[]{"Supplier", "Holder", "Name",
                "Fraction", "CR Started", "CR Finished",
                "Time Spent", "Time Limit", "Class",
                "ORDER", "Booster 1", "Booster 2", "Full Price",
                "Price(-Fee)", "B1 Profit", "B2 Profit", "Receiver's profit",
                "Paid to", "Currency", "Status", "PAID", "Add. info.",
                "Paid off", "Recieved on", "Completed on", "Payout Group"};
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
    private void defineComboBox(Vector<String> items, JTable table, int columnIndex) {
        JComboBox<String> jComboBox = new JComboBox<String>(items);
        DefaultCellEditor cellEditor = new DefaultCellEditor(jComboBox);
        table.getColumnModel().getColumn(columnIndex).setCellEditor(cellEditor);
    }
    public void renderRows(Vector<Vector<String>> loadedData) {
    }
}
