package org.services.tableDataProcessing;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public interface DataProcessing {

    public void processLoadedFileData(Vector<Vector<String>> loadedData);
    public Vector<Vector<String>> getTableData();
    public List<HashMap<String, Double>> getResultPanelData();
}
