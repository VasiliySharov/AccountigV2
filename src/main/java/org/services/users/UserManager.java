package org.services.users;

import lombok.Getter;

import java.util.*;

public class UserManager {
    @Getter
    private  static final Map<String, User> users = new HashMap<>();
    @Getter
    private  static final Map<String, User> boosters = new HashMap<>();
    @Getter
    private  static final Map<String, User> suppliers = new HashMap<>();
    @Getter
    private  static final Vector<String> boostersList = new Vector<>();
    @Getter
    private  static final Vector<String> suppliersList = new Vector<>();


    public static void createUser(Vector<String> user) { // parameter: accept dataLoaded from a file to create a user.
        User newUser = new User(user.get(0));
        users.put(newUser.getName(), newUser);
        if(user.size() > 1) {
            boosters.put(newUser.getName(), newUser);
            boostersList.add(newUser.getName());
            newUser.setBooster(true);
        }
        if(user.size() > 2) {
            suppliers.put(newUser.getName(), newUser);
            suppliersList.add(newUser.getName());
            newUser.setSupplier(true);
        }
    }

}
