package org.services.tableDataProcessing;

import java.util.List;

public interface DataProcessing {

    public List<List<String>> processLoadedFileData(List<List<String>> loadedData);
}
