package org.services.users;

import java.util.*;

public class UserManager {
    private  static final Map<String, User> users = new HashMap<>();
    private  static final Map<String, User> boosters = new HashMap<>();
    private  static final Map<String, User> suppliers = new HashMap<>();
    private  static final Vector<String> boostersList = new Vector<>();
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

    public static Map<String, User> getUsers() {
        return users;
    }

    public static Map<String, User> getBoosters() {
        return boosters;
    }

    public static Map<String, User> getSuppliers() {
        return suppliers;
    }

    public static Vector<String> getBoostersList() {
        return boostersList;
    }

    public static Vector<String> getSuppliersList() {
        return suppliersList;
    }
}
