package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface FileSaver {
    public void saveFile(Path selectedFile, List<List<String>> tableData);
}
