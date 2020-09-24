package ru.rsreu.Grechishkin;

import ru.rsreu.Grechishkin.db.dto.User;

import java.util.HashSet;
import java.util.Set;

public class OnlineUsersManager {
    private static final Set<User> loggedInUsers = new HashSet<User>();
    private static final Object lockObject = new Object();

    private OnlineUsersManager() {
    }

    public static void markUserAsLoggedIn(User user) {
        synchronized (lockObject) {
            loggedInUsers.add(user);
        }
    }

    public static void markUserAsLoggedOut(User user) {
        synchronized (lockObject) {
            loggedInUsers.remove(user);
        }
    }
}
