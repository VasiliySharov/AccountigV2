package org.services.fileSavingAndLoadingLogic.table_IO;

import java.nio.file.Path;
import java.util.Vector;

public class OdsFileLoader implements FileLoader {
    @Override
    public Vector<Vector<String>> loadFile(Path selectedFile) {
        throw new NotImplemented("OdsFileLoader is not implemented");
    }

    private class NotImplemented extends RuntimeException {
        public NotImplemented(String message) {
            super(message);
        }
    }
}
