package mk.webfactory.nm.addressbook.Model;
import mk.webfactory.nm.addressbook.Model.ContactsContract.ContactsDataSource;
import mk.webfactory.nm.addressbook.Model.Person;
import java.util.*;
public class ContactsInMemory implements ContactsDataSource {

    private TreeSet<Person> personList = new TreeSet<Person>();




    public void deleteContact(Person person) {
        if(personList.contains(person)) {
            personList.remove(person);
        }
    }

    public void addContact(Person newPerson) {
       personList.add(newPerson);

   }



    public ArrayList<Person> getContactsByName(String searchString) {
        ArrayList<Person> nameList = new ArrayList<Person>();

        for(Person person : personList) {

            if(person.getName().toLowerCase().startsWith(searchString.toLowerCase())) {
                 nameList.add(person);
            }
        }
        return nameList;

    }

    public Person getContactByID (String id) {
        for (Person person : personList) {
            if (person.getID().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Person> allContacts () {
        ArrayList<Person> all = new ArrayList<Person>();
        all.addAll(personList);
        return all;
    }



}
