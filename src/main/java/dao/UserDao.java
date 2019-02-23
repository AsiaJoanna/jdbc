package dao;

import config.Database;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
String sql = "UPDATE user SET first_name=?, last_name=?, email=?" + "WHERE id=?";
PreparedStatement ps = connection.prepareStatement (sql);
ps.setString(1, user.getFirstName());
ps.setString(2, user.getLastName());
ps.setString(3, user.getEmail());




    }
    //delete
    public void delete (int id){

    }
    //findAll
    public List<User> findAll() {
        return null;
    }
    //findById
    public User findById (int id){
        return null;
    }
}
