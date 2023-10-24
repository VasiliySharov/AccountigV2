package org.uiModules.menu;

import org.fileSavingandLoadingLogic.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Menu extends JMenuBar {
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem loadMenuItem = new JMenuItem("Load");
    private final JMenuItem saveMenuItem = new JMenuItem("Save");

    // filter is used in load and save methods.
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter(
            ".txt, .ods", "txt", "ods");
    private FileLoaderContext fileLoaderContext;
    private FileSaverContext fileSaverContext;
    {
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        add(fileMenu);
    }

    public Menu() {

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

                fileLoaderContext = new FileLoaderContext(selectedFile, fileFormat);
                fileLoaderContext.loadFile();
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

                fileSaverContext = new FileSaverContext(selectedFile, fileFormat);
                fileSaverContext.saveFile();
            } else {
                System.out.println("Unable to determine the file format.");
            }
        }
    }
}
