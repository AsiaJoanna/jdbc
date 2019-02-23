package main;

import config.Database;
import dao.UserDao;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        UserDao userDao = new UserDao(db);
        User user = new User ("Joanna", "Jabłonka", "joannajablonka@gmail.com");


        Connection connection = db.getConnection();

        PreparedStatement ps = connection.prepareStatement("INSERT INTO user (first_name, last_name, email) " +
                "VALUES ('Joanna', 'Jabłonka', 'joannajablonka@gmail.com')");

        ps.executeUpdate();

        connection.close();
    }
}
