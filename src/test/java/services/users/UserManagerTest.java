package services.users;

import org.junit.jupiter.api.*;
import org.services.fileSavingAndLoadingLogic.table_IO.FileLoader;
import org.services.fileSavingAndLoadingLogic.users_IO.UsersLoader;
import org.services.users.User;
import org.services.users.UserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Tag("UnitTest")
class UserManagerTest {
    UsersLoader usersLoader;
    @Test
    @DisplayName("no repeated User keys if loading a file called twice")
    void no_repeated_keys() {
        usersLoader = new UsersLoader();
        usersLoader.loadUsers();
        usersLoader.loadUsers();
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, User> user:UserManager.getUsers().entrySet()) {
            names.add(user.getKey());
        }

        List<String> list = names.stream().distinct().toList();
        Assertions.assertEquals(names.size(), list.size());
    }
}
