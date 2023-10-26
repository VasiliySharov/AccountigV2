package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.util.List;

public interface FileSaver {
    public void saveFile(File selectedFile, List<List<String>> tableData);
}
