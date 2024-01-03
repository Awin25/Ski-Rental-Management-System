/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.endpoint;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ryerson.ca.business.*;
import ryerson.ca.helper.*;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("buy")
public class BuyResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public BuyResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ryerson.ca.searchbook.endpoint.SearchResource
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Path("isOnHold/{isbn}")
//    public String getXml(@PathParam("isbn") String isbn) {
//        System.out.println(isbn);
//        HoldBusiness hold = new HoldBusiness();
//        BookHold book = hold.getBooks(isbn);
//        if (book == null) {
//            return("");
//        }
//        JAXBContext jaxbContext;
//        try {
//            jaxbContext = JAXBContext.newInstance(BookHold.class);
//
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            StringWriter sw = new StringWriter();
//            jaxbMarshaller.marshal(book, sw);
//
//            return (sw.toString());
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(HoldResource.class.getName()).log(Level.SEVERE, null, ex);
//            return ("error happened");
//        }
//    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String  updateBuy(@FormParam("userid") String userid) throws InterruptedException
    {
          BuyBusiness buy = new BuyBusiness();
          boolean bs;
          try{
             bs=buy.buy(userid); 
        
              return("Deleted");
 } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuyResource.class.getName()).log(Level.SEVERE, null, ex);
            return (ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(BuyResource.class.getName()).log(Level.SEVERE, null, ex);
               return (ex.getMessage());
        } catch (ServerAddressNotSuppliedException ex) {
            Logger.getLogger(BuyResource.class.getName()).log(Level.SEVERE, null, ex);
               return (ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(BuyResource.class.getName()).log(Level.SEVERE, null, ex);
               return (ex.getMessage());
        }
        

    }
          
    }


    

