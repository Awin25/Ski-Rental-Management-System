/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import ryerson.ca.helper.*;
import javax.ws.rs.client.Entity;
import java.sql.*;


/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String passwrod) {

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
     



    public static SkiXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        WebTarget searchwebTarget
                = searchclient.target("http://localhost:8080/Ski/webresources/ski");
        InputStream is
                = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        SkiXML skis = skixmltoObjects(xml);
       if (token != null) {
           Client holdclient = ClientBuilder.newClient();
           WebTarget holdwebTarget
                   = holdclient.target("http://localhost:8080/BuyCarts/webresources/buy");
          

               InputStream holddata
                       = holdwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
             
                
                
            
        }

        return (skis);

    }

    private static SkiXML skixmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(SkiXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SkiXML skis = (SkiXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return skis;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Ski skiholdxmltoObjects(String xml) {
        if(xml.isEmpty())
            return null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Ski.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Ski ski = (Ski) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return ski;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
