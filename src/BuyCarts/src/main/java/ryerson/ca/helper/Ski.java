package ryerson.ca.helper;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
    @XmlRootElement(name = "ski")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ski {

  private  boolean available;
     private int skiPrice;
    private String skiName;
    private String UserID;
 
 
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
   




    public Ski(){
        
    }
    public Ski(int skiPrice,String skiName,String UserID, boolean available) {
        this.skiName = skiName;
        this.available=available;
        this.skiPrice = skiPrice;
        this.UserID = UserID;
    }

     public int getPrice(){
        return skiPrice;
    }

    public String getSkiName() {
        return skiName;
    }
    
         public String getUserID(){
        return UserID;
    }

}

