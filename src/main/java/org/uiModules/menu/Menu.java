package org.uiModules.menu;

import org.services.fileSavingAndLoadingLogic.lodaers.FileLoaderContext;
import org.services.fileSavingAndLoadingLogic.lodaers.FileSaverContext;
import org.uiModules.mainTable.v2.MainTable;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.List;

public class Menu extends JMenuBar {
    private final MainTable mainTable;
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem loadMenuItem = new JMenuItem("Load");
    private final JMenuItem saveMenuItem = new JMenuItem("Save");

    // filter is used in load and save methods.
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".txt, .ods", "txt", "ods");

    {
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        add(fileMenu);
    }

    public Menu(MainTable mainTable) {
        this.mainTable = mainTable;
        loadMenuItem.addActionListener(e -> loadTableData());
        saveMenuItem.addActionListener(e -> saveTableData());
    }


    private void loadTableData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        File selectedFile;


        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            // Get the file format (extension)
            String fileName = selectedFile.getName();
            int lastIndex = fileName.lastIndexOf('.');

            if (lastIndex > 0 && lastIndex < fileName.length() - 1) { // -1 so the substring is at least 1 symbol.
                String fileFormat = fileName.substring(lastIndex + 1);
                System.out.println("Selected file format: " + fileFormat);

                FileLoaderContext fileLoaderContext = new FileLoaderContext(selectedFile.toPath(), fileFormat);
                List<List<String>> loadedData = fileLoaderContext.loadFile();
                mainTable.renderRows(loadedData);
            } else {
                System.out.println("Unable to determine the file format.");
            }
        }
    }








    private void saveTableData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showSaveDialog(null);
        File selectedFile;


        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            // Get the file format (extension)
            String fileName = selectedFile.getName();
            int lastIndex = fileName.lastIndexOf('.');

            if (lastIndex > 0 && lastIndex < fileName.length() - 1) { // -1 so the substring is at least 1 symbol.
                String fileFormat = fileName.substring(lastIndex + 1);
                System.out.println("Selected file format: " + fileFormat);

                FileSaverContext fileSaverContext = new FileSaverContext(selectedFile.toPath(), fileFormat);
//                fileSaverContext.saveFile();
            } else {
                System.out.println("Unable to determine the file format.");
            }
        }
    }
}
