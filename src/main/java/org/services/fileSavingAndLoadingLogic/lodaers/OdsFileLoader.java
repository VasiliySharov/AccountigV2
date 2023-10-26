package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class OdsFileLoader implements FileLoader {
    @Override
    public List<List<String>> loadFile(Path selectedFile) {
        throw new NotImplemented("OdsFileLoader is not implemented");
    }

    private class NotImplemented extends RuntimeException {
        public NotImplemented(String message) {
            super(message);
        }
    }
}
