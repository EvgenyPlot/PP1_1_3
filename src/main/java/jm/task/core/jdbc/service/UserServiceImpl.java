package jm.task.core.jdbc.service;

import jm.task.core.jdbc.DAO.UserDao;
import jm.task.core.jdbc.DAO.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
   private UserDao userDaoJDBC = new UserDaoJDBCImpl();

    public UserServiceImpl()  {
    }





    /*public UserServiceImpl() throws SQLException, ClassNotFoundException {

    }*/


    public void createUsersTable() {

        try (Connection connection = Util.connection()) {
            userDaoJDBC.createUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {

        try (Connection connection = Util.connection()) {
            userDaoJDBC.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.connection()) {
            userDaoJDBC.saveUser(name, lastName, age);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        try (Connection connection = Util.connection()) {
            userDaoJDBC.removeUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public List<User> getAllUsers () {

        return userDaoJDBC.getAllUsers();

    }

    public void cleanUsersTable () {
        try (Connection connection = Util.connection()) {
            userDaoJDBC.cleanUsersTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
