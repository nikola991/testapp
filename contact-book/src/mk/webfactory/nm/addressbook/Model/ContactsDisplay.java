package mk.webfactory.nm.addressbook.Model;
import mk.webfactory.nm.addressbook.Model.ContactsContract.*;
import java.util.*;


public class ContactsDisplay implements ContactsView{


     public void showContactDetails(Person person) {
         System.out.println(person.getName());
         System.out.println(person.getLastName());

     }

     public void showAllContacts(ArrayList<Person> allContacts) {
          for(Person contact : allContacts) {
              showContactDetails(contact);
          }
     }




}
