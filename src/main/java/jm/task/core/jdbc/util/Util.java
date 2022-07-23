package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Property;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/test";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Admin";
    private final static String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static SessionFactory sessionFactory;

    static {
        try {
            //Свойства
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.driver_class", DRIVER);
            properties.setProperty("hibernate.connection.url", URL);
            properties.setProperty("hibernate.connection.username", USERNAME);
            properties.setProperty("hibernate.connection.password", PASSWORD);
            properties.setProperty("hibernate.dialect", DIALECT);
            //Конфигурация и класс
            Configuration config = new Configuration();
            config.setProperties(properties);
            config.addAnnotatedClass(User.class);
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
