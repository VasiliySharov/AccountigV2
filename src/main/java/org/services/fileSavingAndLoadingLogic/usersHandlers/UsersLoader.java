package org.services.fileSavingAndLoadingLogic.usersHandlers;

import org.services.fileSavingAndLoadingLogic.lodaers.FileLoader;
import org.services.fileSavingAndLoadingLogic.lodaers.TextFileLoader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UsersLoader {

    public List<List<String>> loadUsers() {
        FileLoader fileLoader = new TextFileLoader();
        Path p = Paths.get("C:\\Users\\Vasilii\\Documents\\BoostersList.txt");
        return fileLoader.loadFile(p);
    }
}
