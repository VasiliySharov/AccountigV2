package org.uiModules.menu;

import org.constants.Extensions;
import org.services.fileSavingAndLoadingLogic.table_IO.FileLoaderContext;
import org.services.fileSavingAndLoadingLogic.table_IO.FileSaverContext;
import org.uiModules.controller.DataFlowController;

import javax.swing.*;
import java.io.File;
import java.util.Vector;

public class Menu extends JMenuBar {

    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem loadMenuItem = new JMenuItem("Load");
    private final JMenuItem saveMenuItem = new JMenuItem("Save");
    private final DataFlowController dataFlowController;

    // filter is used in load and save methods.

    {
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        add(fileMenu);
    }

    public Menu(DataFlowController dataFlowController) {
        this.dataFlowController = dataFlowController;
        loadMenuItem.addActionListener(e -> loadTableData());
        saveMenuItem.addActionListener(e -> saveTableData());
    }


    private void loadTableData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(Extensions.filter);

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
                Vector<Vector<String>> loadedData = fileLoaderContext.loadFile();
                dataFlowController.loadData(loadedData);
            } else {
                System.out.println("Unable to determine the file format.");
            }
        }
    }








    private void saveTableData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(Extensions.filter);

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
