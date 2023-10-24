package org.fileSavingandLoadingLogic;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;

public class OdsFileLoader implements FileLoader {
    @Override
    public void loadFile(File selectedFile) {
        throw new NotImplemented("OdsFileLoader is not implemented");
    }

    private class NotImplemented extends RuntimeException {
        public NotImplemented(String message) {
            super(message);
        }
    }
}
