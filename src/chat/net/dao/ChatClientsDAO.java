/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.net.dao;

import chat.net.dbutil.DBConnection;
import chat.net.pojo.ChatClients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ChatClientsDAO {

    private static Connection conn;
    private static PreparedStatement ps;

    public static boolean findClient(String username) throws SQLException // exceptions are never handled in DAO classes . They are alwayshandled in presetation layer
    {                                                                                   // this is because message related to exception are show to user by presentation layer and not DAO 
        System.out.println("In ChatClientsDAO username is: " + username);
        conn = DBConnection.getConnection();
        ps = conn.prepareStatement("Select * from chatclients where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
       

        return rs.next();
    }

    public static boolean addClient(ChatClients obj) throws SQLException {
        conn = DBConnection.getConnection();
        ps = conn.prepareStatement("insert into chatclients values(?,?)");
        ps.setString(1, obj.getUsername());
        ps.setString(2, obj.getPassword());

        int ans = ps.executeUpdate();

       
        return ans != 0;
    }
}
