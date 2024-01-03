/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.persistence;
import ryerson.ca.helper.*;
import java.sql.*;
/**
 *
 * @author student
 */
public class Account_CRUD{
   
           public boolean user(String username){
                  try{
            Connection con = getCon();
            
            String userid = "";
            String q = "select * from USER WHERE username like " + "'" + username + "'";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            System.out.println("hello");
            if(rs.next()){
                String uname = rs.getString("username");
                String pw = rs.getString("password");
                userid = rs.getString("id");
                
                if( uname.equals(username)){
                     System.out.println("Authenticated");
                   return true;
                }  
                
                System.out.println(uname + pw);
                
                
            }
            
           
            
            con.close();
        }catch(Exception e){
            System.out.println("Not authenticated");
        }
        return false;
    }
    
       private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/USER?autoReconnect=true&useSSL=false","root","student");
            System.out.println("Connection established.");
	}catch(Exception e){System.out.println(e);
        }
        return con;
    }
          
          
}
