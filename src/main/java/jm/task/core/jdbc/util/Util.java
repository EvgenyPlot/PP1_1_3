package jm.task.core.jdbc.util;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static String userName = "root";
    private static String password = "240885aA";
    private static String connectionURL = "jdbc:mysql://localhost:3306/test";
    private static Util instance = null;


    public static Connection connection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("Connection Ok!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection ERROR");
        }
        return connection;

    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }


}