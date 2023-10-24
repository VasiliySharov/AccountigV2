package org.fileSavingandLoadingLogic;

import java.io.File;

public class FileSaverContext {
    private FileSaver fileSaver;
    private File selectedFile;
    private String fileFormat;

    public FileSaverContext(File selectedFile, String fileFormat) {
        this.selectedFile = selectedFile;
        this.fileFormat = fileFormat;
    }

    public void saveFile() {

        if (fileFormat.equals("txt")) {
            fileSaver = new TextFileSaver();
            fileSaver.saveFile(selectedFile);
            System.out.println("Saving file");
        } else if (fileFormat.equals("ods")) {
            fileSaver = new OdsFileSaver();
            fileSaver.saveFile(selectedFile);
            System.out.println("Saving file");
        } else {
            System.out.println("Choose the right format (.txt or .ods)");
        }
    }
}
