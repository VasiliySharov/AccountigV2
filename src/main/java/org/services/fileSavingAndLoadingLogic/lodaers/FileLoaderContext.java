package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// this classes use Strategy pattern.
public class FileLoaderContext {
    private FileLoader fileLoader;
    private Path selectedFile;
    private String fileFormat;

    public FileLoaderContext(Path selectedFile, String fileFormat) {
        this.selectedFile = selectedFile;
        this.fileFormat = fileFormat;
    }

    public Vector<Vector<String>> loadFile() {
        Vector<Vector<String>> loadedData = new Vector<>();
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
