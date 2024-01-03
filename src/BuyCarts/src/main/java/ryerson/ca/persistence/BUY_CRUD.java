/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.persistence;

/**
 *
 * @author student
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.sql.SQLException;
import ryerson.ca.helper.*;

/**
 *
 * @author student
 */
public class BUY_CRUD {
//    private static Connection getCon(){
//    Connection con=null;
//     try{
//         
//         Class.forName("com.mysql.cj.jdbc.Driver");
//        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
//       
//       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BUYSKI_SMS?autoReconnect=true&useSSL=false", "root", "student");
//        System.out.println("Connection established.");
//     }
//     catch(Exception e){ System.out.println(e);}
//     return con;
//    }
    
            public static Connection getCon() throws SQLException{
       Connection con=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
        String connection=System.getenv("DB_URL");
        //String connection ="localhost:3306";
         con=DriverManager.getConnection("jdbc:mysql://"+connection+"/BUYSKI_SMS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student" );
        
         
         System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
     
    }
    

     public static boolean delete(String username){
       
     
       try{
           Connection con = getCon();
           Statement stmt = con.createStatement();
        String q = "DELETE FROM SKI WHERE id like " + "'" + username + "'";
           //String q = "DELETE FROM SKI WHERE id like " + "'" + "akir" + "'";
           stmt.executeUpdate(q);
           System.out.println("deleted" + username);
 
      	con.close();
                        return true;

		}catch(Exception e){System.out.println(e);
                return false;
                }
   }
}
