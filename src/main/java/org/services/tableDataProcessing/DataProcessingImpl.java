package org.services.tableDataProcessing;

import org.services.fileSavingAndLoadingLogic.users_IO.UsersLoader;
import org.services.users.UserManager;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class DataProcessingImpl implements DataProcessing {
    Vector<Vector<String>> loadedData;
    @Override
    public void processLoadedFileData(Vector<Vector<String>> loadedData) {
        new UsersLoader().loadUsers(); // load Users from a separate file.

        // some logic to calculate table rows
        this.loadedData = loadedData;

    }

    @Override
    public Vector<Vector<String>> getTableData() {
        return loadedData;
    }

    @Override
    public List<HashMap<String, Double>> getResultPanelData() {
        return null;
    }
}
