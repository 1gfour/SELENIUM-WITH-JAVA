/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBHelper;

/**
 *
 * @author hungp
 */
public class UserDao {

    private static final String LOGIN = "SELECT userID, fullname, roleID, status FROM tblUsers WHERE userID=? AND password =?";
    private static final String SEARCH = "SELECT userID,fullName,roleID FROM tblUsers WHERE fullName like ? ";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserDto checkLogin(String userId, String password) throws SQLException {
        UserDto user = null;
        try {
            connection = DBHelper.makeConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(LOGIN);
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String fullname = resultSet.getString("fullname");
                    String roleID = resultSet.getString("roleID");
                    Boolean status = resultSet.getBoolean("status");
                    user = new UserDto(userId, fullname, roleID, "", status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return user;
    }
}
