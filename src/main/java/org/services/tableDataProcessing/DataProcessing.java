package org.services.tableDataProcessing;

import java.util.Vector;

public interface DataProcessing {

    public void processLoadedFileData(Vector<Vector<String>> loadedData);
    public Vector<Vector<String>> getTableData();
}
