package org.fileSavingandLoadingLogic;

import java.io.File;

// this classes use Strategy pattern.
public class FileLoaderContext {
    private FileLoader fileLoader;
    private File selectedFile;
    private String fileFormat;

    public FileLoaderContext(File selectedFile, String fileFormat) {
        this.selectedFile = selectedFile;
        this.fileFormat = fileFormat;
    }

    public void loadFile() {

        if (fileFormat.equals("txt")) {
            fileLoader = new TextFileLoader();
            fileLoader.loadFile(selectedFile);
            System.out.println("Loading file");
        } else if (fileFormat.equals("ods")) {
            fileLoader = new OdsFileLoader();
            fileLoader.loadFile(selectedFile);
            System.out.println("Loading file");
        } else {
            System.out.println("Choose the right format (.txt or .ods)");
        }
    }
}
