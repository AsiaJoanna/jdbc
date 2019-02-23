package dao;

import config.Database;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Database db;

    public UserDao (Database database)  {
        this.db = database;
    }
    //insert
        public void save(User user) throws SQLException {
        Connection connection = db.getConnection();
        //;DROP DATABASE users;
        PreparedStatement ps = connection.prepareStatement("INSERT INTO user (first_name, last_name, email) " +
                "VALUES (?, ?, ?)");
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());

        ps.executeUpdate();

    }
    //update
    public void update (User user) throws SQLException{
        Connection connection = db.getConnection();
String sql = "UPDATE user SET first_name=?, last_name=?, email=?" + "WHERE id=?";
PreparedStatement ps = connection.prepareStatement (sql);
ps.setString(1, user.getFirstName());
ps.setString(2, user.getLastName());
ps.setString(3, user.getEmail());
ps.setInt(4, user.getId());




    }
    //delete
    public void delete (int id) throws SQLException{
Connection connection = db.getConnection();

String sql = "DELETE  FROM user WHERE id = ?";
PreparedStatement ps connection.prepareStatement(sql);
ps.setInt(1, id);
ps.executeUpdate();
    }
    //findAll
    public List<User> findAll() throws SQLException{

        Connection connection = db.getConnection();
        String sql = "SELECT id, firt_name, last_name, email FROM user";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<User> users = new ArrayList<User>();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firt_name");

        }

        return users;
    }
    //findById
    public User findById (int id){
        return null;
    }
}
