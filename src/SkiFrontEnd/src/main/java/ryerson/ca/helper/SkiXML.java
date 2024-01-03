package ryerson.ca.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement(name = "skis")
@XmlAccessorType (XmlAccessType.FIELD)
       public class SkiXML{
     @XmlElement(name="ski")
           public  ArrayList<Ski> skis;
           
           
           public List<Ski>getSkis(){
               if (skis == null){
               return new ArrayList<>();
               }
               else {
                   return skis;
               }
           }
          public SkiXML(){
               
               
           }
           public void setSki(ArrayList<Ski> bs){
               skis=bs;
           
       }
 }


