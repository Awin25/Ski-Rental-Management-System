/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import ryerson.ca.helper.Ski;
/**
 *
 * @author student
 */
public class SKI_Buy_CRUD {
//     private static Connection getCon(){
//    Connection con=null;
//     try{
//         Class.forName("com.mysql.jdbc.Driver");
//         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SKICART_SMS?autoReconnect=true&useSSL=false", "root", "student");
//         System.out.println("Connection established.");
//     }
//     catch(Exception e){ System.out.println(e);}
//     return con;
//    }
    
      public static Connection getCon() throws ClassNotFoundException, SQLException{
       Connection con=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
        String connection=System.getenv("DB_URL");
        //String connection ="localhost:3306";
         con=DriverManager.getConnection("jdbc:mysql://"+connection+"/SKICART_SMS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student" );
        
         
         System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
     
    }
    
        public static Set<Ski>  getSkis(String query){
         Set<Ski> skis= new HashSet<Ski>();
        try{
            Connection con= getCon();
            
    String q = "select * from SKI WHERE id like " + "'" + query + "'";
                 System.out.println(q);
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				//been= new UserInfo();
                         String skiname = rs.getString("skiname");
                         int price = rs.getInt("price");
                         String skiid = rs.getString("id");
                           
                                Ski ski = new Ski(price,skiname,skiid,true);
                                skis.add(ski);
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            

        return skis;
        
    }
        
        
           public static String buySkis(String username){
       
     
       try{
           Connection con = getCon();
           Statement stmt = con.createStatement();
        String q = "DELETE FROM SKI WHERE id like " + "'" + username + "'";
           //String q = "DELETE FROM SKI WHERE id like " + "'" + "akir" + "'";
           stmt.executeUpdate(q);
           System.out.println("deleted" + username);
 
      	con.close();
                        return "true";

		}catch(Exception e){System.out.println(e);
                return "false";
                }
   }
    
}



