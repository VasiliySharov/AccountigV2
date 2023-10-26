package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.util.List;

public interface FileLoader {
    public List<List<String>> loadFile(File selectedFile);
}
