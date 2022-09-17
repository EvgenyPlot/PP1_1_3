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


        userDaoJDBC.createUsersTable();




    }

    public void dropUsersTable() {

        userDaoJDBC.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

     userDaoJDBC.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {

        userDaoJDBC.removeUserById(id);

    }

    public List<User> getAllUsers () {

        return userDaoJDBC.getAllUsers();

    }

    public void cleanUsersTable () {

        userDaoJDBC.cleanUsersTable();

    }

}
