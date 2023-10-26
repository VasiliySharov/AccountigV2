package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// this classes use Strategy pattern.
public class FileLoaderContext {
    private FileLoader fileLoader;
    private File selectedFile;
    private String fileFormat;

    public FileLoaderContext(File selectedFile, String fileFormat) {
        this.selectedFile = selectedFile;
        this.fileFormat = fileFormat;
    }

    public List<List<String>> loadFile() {
        List<List<String>> loadedData = new ArrayList<>();
        if (fileFormat.equals("txt")) {
            fileLoader = new TextFileLoader();
            loadedData = fileLoader.loadFile(selectedFile);
            System.out.println("Loading file");
            return loadedData;
        } else if (fileFormat.equals("ods")) {
            fileLoader = new OdsFileLoader();
            loadedData = fileLoader.loadFile(selectedFile);
            System.out.println("Loading file");
            return loadedData;
        } else {
            System.out.println("Choose the right format (.txt or .ods)");
        }
        return loadedData;
    }
}
