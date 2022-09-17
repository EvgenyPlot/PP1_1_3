package jm.task.core.jdbc.DAO;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao{



    public UserDaoJDBCImpl()  {

    }

    public void createUsersTable() {
        Connection connection = Util.connection();

        try (Statement statement = connection.createStatement())  {
            statement.executeUpdate("create table if not exists test.users (id int not null auto_increment," +
                    " name VARCHAR(255) not null,  lastName VARCHAR(255) not null, age int not null, " +
                    "PRIMARY KEY (`id`))");
            System.out.println("Таблица создана!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Таблица создана ранее!");
        }



    }

    public void dropUsersTable() {
        Connection connection = Util.connection();
        try (Statement statement = connection.createStatement())  {
            statement.executeUpdate("Drop table if exists test.users");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.connection();
        String sql = "INSERT INTO test.users(name, lastname, age) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        Connection connection = Util.connection();
        try  (Statement statement = connection.createStatement()){
            String sql = "DELETE FROM test.users where id";
            statement.executeUpdate(sql);
            System.out.println("User удален");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers () {
        List<User> allUser = new ArrayList<>();

        String sql = "SELECT id, name, lastName, age from test.users";
        Connection connection = Util.connection();


        try (Statement statement = connection.createStatement())  {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                System.out.println(user.toString());
                allUser.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
//
        }
        return allUser;

    }

    public void cleanUsersTable () {
        String sql = "DELETE FROM test.users";
        Connection connection = Util.connection();

        try (Statement statement = connection.createStatement())  {
            statement.executeUpdate(sql);
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось очистить");
        }

    }

}
