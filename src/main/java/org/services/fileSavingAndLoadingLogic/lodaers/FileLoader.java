package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Vector;

public interface FileLoader {
    public Vector<Vector<String>> loadFile(Path selectedFile);
}
