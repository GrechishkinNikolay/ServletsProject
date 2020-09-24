package ru.rsreu.Grechishkin.db.dao.oracle;

import ru.rsreu.Grechishkin.Resourcer;
import ru.rsreu.Grechishkin.db.dto.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OracleManager {
    private OracleManager() {
    }

    private static void closeStatementAndConnection(Connection cn, Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<User> getAllUsers() {
        Context envCtx = null;
        DataSource ds = null;
        Statement st = null;
        Connection cn = null;
        List<User> users = new ArrayList<User>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(Resourcer.getProperty("query.getAllUsers"));
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                users.add(new User(id, firstname, lastname, password, login, getUserTasksById(id)));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, st);
        }
        return users;
    }

    public static List<UserGroup> getAllUserGroup() {
        Context envCtx = null;
        DataSource ds = null;
        Statement st = null;
        Connection cn = null;
        List<UserGroup> userGroup = new ArrayList<UserGroup>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(Resourcer.getProperty("query.getAllUserGroup"));
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                userGroup.add(new UserGroup(id, name));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, st);
        }
        return userGroup;
    }

    public static List<Task> getUserTasksById(int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<Task> tasks = new ArrayList<Task>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getUserTasksById"));
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int numberOfPerformers = resultSet.getInt("numberofperformers");
                String text = resultSet.getString("text");
                tasks.add(new Task(id, text, numberOfPerformers));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return tasks;
    }

    public static List<Community> getCommunitiesByUserId(int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<Community> communities = new ArrayList<Community>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getCommunitiesByUserId"));
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                communities.add(new Community(id, name, getProjectsByCommunityId(id), getUsersByCommunityId(id)));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return communities;
    }

    public static Community getCommunityById(int communityId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        Community communitiy = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getCommunityById"));
            ps.setInt(1, communityId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                communitiy = new Community(id, name, getProjectsByCommunityId(id), getUsersByCommunityId(id));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return communitiy;
    }

    public static Task getTaskById(int taskId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        Task task = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getTaskById"));
            ps.setInt(1, taskId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int numberofperformers = resultSet.getInt("numberofperformers");
                String text = resultSet.getString("text");
                task = new Task(id, text, numberofperformers);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return task;
    }

    public static int findUserGroupByCommunityAndUserId(int communityId, int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        int groupCode = 0;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.findUserGroupByCommunityAndUserId"));
            ps.setInt(1, communityId);
            ps.setInt(2, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                groupCode = resultSet.getInt("t_usergroup");
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return groupCode;
    }

    public static User getUserById(int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        User user = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getUserById"));
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                user = new User(id, firstname, lastname, password, login, getUserTasksById(id));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return user;
    }

    public static List<Project> getProjectsByCommunityId(int communityId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<Project> projects = new ArrayList<Project>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getProjectsByCommunityId"));
            ps.setInt(1, communityId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int community = resultSet.getInt("community");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                projects.add(new Project(id, name, description, getTasksByProjectId(id), getCommentsByProjectId(id)));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return projects;
    }

    public static List<Task> getTasksByProjectId(int projectId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<Task> tasks = new ArrayList<Task>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getTasksByProjectId"));
            ps.setInt(1, projectId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int numberofperformers = resultSet.getInt("numberofperformers");
                String text = resultSet.getString("text");
                tasks.add(new Task(id, text, numberofperformers));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return tasks;
    }

    public static List<Comment> getCommentsByProjectId(int projectId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<Comment> comments = new ArrayList<Comment>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getCommentsByProjectId"));
            ps.setInt(1, projectId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int project = resultSet.getInt("project");
                String text = resultSet.getString("text");
                Timestamp datetime = resultSet.getTimestamp("datetime");
                comments.add(new Comment(id, text, datetime));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return comments;
    }

    public static List<User> getUsersByCommunityId(int communityId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<User> users = new ArrayList<User>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getUsersByCommunityId"));
            ps.setInt(1, communityId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                users.add(new User(id, firstname, lastname, password, login, getUserTasksById(id)));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return users;
    }

    public static List<User> getUsersByTaskId(int taskId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        List<User> users = new ArrayList<User>();
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.getUsersByTaskId"));
            ps.setInt(1, taskId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String login = resultSet.getString("login");
                users.add(new User(id, firstname, lastname, password, login, getUserTasksById(id)));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
        return users;
    }

    public static void addTaskToUser(int taskId, int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.addTaskToUser"));
            ps.setInt(1, taskId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void addProject(int communityId, String nameProject, String descriptionProject) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.addProject"));
            ps.setInt(1, communityId);
            ps.setString(2, nameProject);
            ps.setString(3, descriptionProject);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void addTask(int projectId, int performersNumber, String descriptionProject) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.addTask"));
            ps.setInt(1, projectId);
            ps.setInt(2, performersNumber);
            ps.setString(3, descriptionProject);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void addUserToCommunity(int communityId, int userId, int userCodeGroup,int  isBlocked) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.addUserToCommunity"));
            ps.setInt(1, communityId);
            ps.setInt(2, userId);
            ps.setInt(3, userCodeGroup);
            ps.setInt(4, isBlocked);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void deleteUsersTask(int taskId, int userId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.deleteUsersTask"));
            ps.setInt(1, taskId);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void deleteComment(int communityId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.deleteComment"));
            ps.setInt(1, communityId);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void deleteAllCommunityMembers(int communityId) {
        Context envCtx = null;
        DataSource ds = null;
        PreparedStatement ps = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            ps = cn.prepareStatement(Resourcer.getProperty("query.deleteAllCommunityMembers"));
            ps.setInt(1, communityId);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, ps);
        }
    }

    public static void AddCommunity(int userId, String communityName) {
        Context envCtx = null;
        DataSource ds = null;
        CallableStatement callableStatement = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            callableStatement = cn.prepareCall(Resourcer.getProperty("query.addCommunity"));
            callableStatement.setInt(1, userId);
            callableStatement.setString(2, communityName);
            callableStatement.execute();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, callableStatement);
        }
    }

    /*public static void addTask(int projectId, int numberOfPerformers, String text, int userId) {
        Context envCtx = null;
        DataSource ds = null;
        CallableStatement callableStatement = null;
        Connection cn = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/oracle");
            cn = ds.getConnection();
            callableStatement = cn.prepareCall(Resourcer.getProperty("query.addTask"));
            callableStatement.setInt(1, projectId);
            callableStatement.setInt(2, numberOfPerformers);
            callableStatement.setString(3, text);
            callableStatement.setInt(4, userId);
            callableStatement.execute();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(cn, callableStatement);
        }
    }*/
}
