package ru.rsreu.Grechishkin.listeners;

import ru.rsreu.Grechishkin.OnlineUsersManager;
import ru.rsreu.Grechishkin.db.dto.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        final User user = (User) session.getAttribute("user");
        if (user != null) {
            OnlineUsersManager.markUserAsLoggedOut(user);
        }
    }
}
