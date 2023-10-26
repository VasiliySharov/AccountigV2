package org.services.users;

public class User {
    private String name;
    private boolean booster = false;
    private boolean supplier = false;

    public User(String name) {
        this.name = name;
    }

    //    public User(UserBuilder builder) {
//        this.name = builder.name;
//        this.booster = builder.booster;
//        this.supplier = builder.supplier;
//    }
//    public static class UserBuilder {
//        private String name;
//        private boolean booster = false;
//        private boolean supplier = false;
//
//        public UserBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//        public UserBuilder booster(boolean booster) {
//            this.booster = booster;
//            return this;
//        }
//        public UserBuilder supplier(boolean supplier) {
//            this.supplier = supplier;
//            return this;
//        }
//        public User createUser() {
//            if (name == null) throw new RuntimeException("Can't create a user without a name");
//            return new User(this);
//        }
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBooster() {
        return booster;
    }

    public void setBooster(boolean booster) {
        this.booster = booster;
    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }
}
