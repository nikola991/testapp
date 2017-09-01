package mk.webfactory.nm.addressbook.Model;
import java.util.*;
public class ContactsContract {


    interface ContactsDataSource {

        void addContact(Person person);
        void deleteContact(Person person);
        ArrayList<Person>  getContactsByName(String name);
        Person getContactByID(String id);
        ArrayList<Person> allContacts ();
    }

    interface ContactsDataSourceListener {

        void didAddContact(Person person);
        void didDeleteContact(Person person);
        void didGetContactsWithName(ArrayList<Person> contactsByName, String name);
        void didGetContactWithId(Person person, String id);
        void didGetAllContacts(ArrayList<Person> allContacts);

    }

    interface ContactsView {
         void showContactDetails(Person person);
         void showAllContacts(ArrayList<Person> allContacts);
    }



}
