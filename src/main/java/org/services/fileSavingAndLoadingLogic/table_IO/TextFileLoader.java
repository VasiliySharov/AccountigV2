package org.services.fileSavingAndLoadingLogic.table_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;

public class TextFileLoader implements FileLoader {
    @Override
    public Vector<Vector<String>> loadFile(Path selectedFile) {
        Vector<Vector<String>> loadedData = new Vector<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(selectedFile);){
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Vector<String> lineRead = new Vector<>(Arrays.asList(line.split(Pattern.quote("|"))));
                loadedData.add(lineRead);
//                System.out.println(loadedData);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return loadedData;
    }
}
