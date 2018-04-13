/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.net.dao;

import chat.net.dbutil.DBConnection;
import chat.net.pojo.ChatLogs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ChatLogsDAO {
    
    private static Connection conn;
    private static PreparedStatement ps;
    
    public static boolean addChatLog(ChatLogs obj) throws SQLException
    {
       conn = DBConnection.getConnection();
       ps = conn.prepareStatement("insert into chatlogs values(?,?,?)");
       ps.setString(1,obj.getUsername());
       ps.setString(2,obj.getMessage());
       ps.setString(3,obj.getTimestamp());
       
       int ans = ps.executeUpdate();
       
      
       return ans!=0;
    }
}
