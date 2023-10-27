package org.services.fileSavingAndLoadingLogic.table_IO;

import java.nio.file.Path;
import java.util.List;

public class FileSaverContext {
    private FileSaver fileSaver;
    private Path selectedFile;
    private String fileFormat;

    public FileSaverContext(Path selectedFile, String fileFormat) {
        this.selectedFile = selectedFile;
        this.fileFormat = fileFormat;
    }

    public void saveFile(List<List<String>> tableData) {

        if (fileFormat.equals("txt")) {
            fileSaver = new TextFileSaver();
            fileSaver.saveFile(selectedFile, tableData);
            System.out.println("Saving file");
        } else if (fileFormat.equals("ods")) {
            fileSaver = new OdsFileSaver();
            fileSaver.saveFile(selectedFile, tableData);
            System.out.println("Saving file");
        } else {
            System.out.println("Choose the right format (.txt or .ods)");
        }
    }
}
