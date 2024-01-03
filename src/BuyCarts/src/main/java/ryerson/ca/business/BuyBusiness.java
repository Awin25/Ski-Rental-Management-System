/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.business;

/**
 *
 * @author student
 */
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import ryerson.ca.helper.*;
import ryerson.ca.persistence.*;

/**
 *
 * @author student
 */
public class BuyBusiness {

   



//    public BookHold getBooks(String isbn) {
//        BookHold bs = BOOK_Hold_CRUD.getHoldBook(isbn);
//
//        return (bs);
//    }

public boolean buy(String userid) throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException{ {
       boolean success = false;
       success = BUY_CRUD.delete(userid);
        if (success){
            Messaging.sendmessage("Buy: "+userid);
        }
        return success;
    }

}
}
