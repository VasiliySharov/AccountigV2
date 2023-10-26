package org.services.fileSavingAndLoadingLogic.usersHandlers;

import org.constants.Extensions;
import org.services.fileSavingAndLoadingLogic.lodaers.FileLoader;
import org.services.fileSavingAndLoadingLogic.lodaers.FileLoaderContext;
import org.services.fileSavingAndLoadingLogic.lodaers.TextFileLoader;
import org.services.users.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class UsersLoader implements FileLoader {

    public Vector<Vector<String>> loadUsers() {
        Path p = Paths.get("C:\\Users\\Vasilii\\Documents\\AccountingV2\\BoostersList.txt");
        return this.loadFile(p);
    }

    @Override
    public Vector<Vector<String>> loadFile(Path selectedFile) {
        Vector<Vector<String>> loadedData = new Vector<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(selectedFile);){
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Vector<String> lineRead = new Vector<>(Arrays.asList(line.split(Pattern.quote("|"))));
                loadedData.add(lineRead);
                UserManager.createUser(lineRead);
//                System.out.println(loadedData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return loadedData;
    }
}
