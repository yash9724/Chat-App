/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.net.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DBConnection
{
     private static Connection conn;
    
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Yash:1521/XE","chatdata","chatapp");
            // JOptionPane.showMessageDialog(null, "Connected to database successfully", "Success!!", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        catch (ClassNotFoundException ex) {
            
            String str = String.format("%s%n%s","Error in connecting to database","Click OK to exit");
            JOptionPane.showMessageDialog(null, str, "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "SQL Exception " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Connection getConnection()
    {
        
               return conn;
    }
    
    public static void closeConnection()
    {
        if(conn != null)
        {
            try
            {
                conn.close();
                //JOptionPane.showMessageDialog(null, "Connection closed successfully"  ,"Success!!", JOptionPane.INFORMATION_MESSAGE);
                
            }
            catch(SQLException e)
            {
                System.out.println("Error in closing connection");
                e.printStackTrace();
            }
        }
    }
    
    /*public static void main(String[] args)
    {
        Connection conn = getConnection();
        System.out.println("Connected Successfully to the database");
    }*/
}
