package org.services.fileSavingAndLoadingLogic.lodaers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TextFileLoader implements FileLoader {
    @Override
    public List<List<String>> loadFile(File selectedFile) {
        List<List<String>> loadedData = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(selectedFile.toPath());){
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> lineRead = new ArrayList<>(Arrays.asList(line.split(Pattern.quote("|"))));
                loadedData.add(lineRead);
                System.out.println(loadedData);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return loadedData;
    }
}
