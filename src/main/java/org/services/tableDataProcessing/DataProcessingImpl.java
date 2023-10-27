package org.services.tableDataProcessing;

import org.services.fileSavingAndLoadingLogic.users_IO.UsersLoader;
import org.services.users.UserManager;

import java.util.Vector;

public class DataProcessingImpl implements DataProcessing {
    @Override
    public void processLoadedFileData(Vector<Vector<String>> loadedData) {
        new UsersLoader().loadUsers();


    }

    @Override
    public Vector<Vector<String>> getTableData() {
        return null;
    }
}
