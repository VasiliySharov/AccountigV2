package org.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static final Map<String, User> users = new HashMap<>();
    private static final Map<String, User> boosters = new HashMap<>();
    private static final Map<String, User> suppliers = new HashMap<>();


    public static User createUser(List<String> user) { // parameter: accept dataLoaded from a file to create a user.
        User newUser = new User(user.get(0));
        users.put(newUser.getName(), newUser);
        if(user.get(1) != null) {
            boosters.put(newUser.getName(), newUser);
            newUser.setBooster(true);
        }
        if(user.get(2) != null) {
            suppliers.put(newUser.getName(), newUser);
            newUser.setSupplier(true);
        }
        return newUser;
    }

}
