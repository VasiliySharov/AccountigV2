package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface FileLoader {
    public List<List<String>> loadFile(Path selectedFile);
}
