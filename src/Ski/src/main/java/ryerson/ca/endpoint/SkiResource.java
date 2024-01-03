/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.endpoint;

import java.io.StringWriter;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ryerson.ca.business.SkiBusiness;
import ryerson.ca.business.Messaging;
import ryerson.ca.helper.*;


/**
 * REST Web Service
 *
 * @author student
 */
@Path("ski/{query}")
public class SkiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SkiResource
     */
    public SkiResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.ca.endpoint.SkiResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
    public String getXml(@PathParam("query") String query) {
        SkiBusiness a= new SkiBusiness();
        SkiXML skis = a.getSkisByQuery(query);
        System.out.println(">>>>>>>>>>>>>>>>>>" + skis);
        
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(SkiXML.class);
        
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     
StringWriter sw = new StringWriter();
    jaxbMarshaller.marshal(skis, sw);
     
    return (sw.toString());
    
      } catch (JAXBException ex) {
            Logger.getLogger(SkiResource.class.getName()).log(Level.SEVERE, null, ex);
            return("error happened");
        }
    }

//    @GET
//    @Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
//    public String getSkisXml(@PathParam("query") String query) {
//
//        
//        SkiBusiness buy = new SkiBusiness();
//        SkiXML skis = buy.getSkisByQuery(query);
//        
//        JAXBContext jaxbContext;
//        try {
//            jaxbContext = JAXBContext.newInstance(SkiXML.class);
//
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            StringWriter sw = new StringWriter();
//            jaxbMarshaller.marshal(skis, sw);
//
//            return (sw.toString());
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(SkiResource.class.getName()).log(Level.SEVERE, null, ex);
//            return ("error happened");
//        }
//
//    }
//    
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    @Path("update")
//    public String updateSkiBuy() {
//
//     
//            SKI_Buy_CRUD.buySkis("123414");
//            return ("Deleted");
//    
//
//
//    } 
    
    
    
//     * PUT method for updating or creating an instance of SearchResource
//     * @param content representation for the resource
//     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}


