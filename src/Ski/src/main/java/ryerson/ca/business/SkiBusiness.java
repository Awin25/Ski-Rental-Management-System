/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package ryerson.ca.business;
import ryerson.ca.helper.SkiXML;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import ryerson.ca.helper.Ski;
import ryerson.ca.persistence.*;

/**
 *
 * @author student
 */
public class SkiBusiness {
    public  SkiXML getSkisByQuery(String query){
       Set<Ski> skis = SKI_CRUD.searchForSkis(query);
       Map<String ,Ski> allSkis= new HashMap ();
        //   System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+ skis.size());
        for(Ski ski : skis){
            if(allSkis.containsKey(ski.getUserID())){

            }
            else{
               
                allSkis.put(ski.getUserID(),ski );
            }
        }
    //    System.out.println("**********************"+ allAuthorsBooks.size());
        SkiXML bs;
        bs = new SkiXML();
        bs.setSki(new ArrayList(allSkis.values()));
        return (bs);
    }
    
      
}