package org.services.fileSavingAndLoadingLogic.table_IO;

import java.nio.file.Path;
import java.util.Vector;

public interface FileLoader {
    public Vector<Vector<String>> loadFile(Path selectedFile);
}
