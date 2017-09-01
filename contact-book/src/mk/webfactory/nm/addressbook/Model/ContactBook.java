package mk.webfactory.nm.addressbook.Model;
import mk.webfactory.nm.addressbook.Model.ContactsContract.ContactsDataSource;
import mk.webfactory.nm.addressbook.Model.ContactsContract.ContactsDataSourceListener;

import java.util.*;

public class ContactBook  {

//    private TreeSet<Person> personList = new TreeSet<Person>();
    private  ArrayList<ContactsDataSourceListener>  listenerList  = new ArrayList<ContactsDataSourceListener>();


    private ContactsDataSource  dataSource;

    public ContactBook(ContactsDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addListener(ContactsDataSourceListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ContactsDataSourceListener listener) {
        if(listenerList.contains(listener)) {
            listenerList.remove(listener);
        }
    }

    public void addContact(Person person) {
        dataSource.addContact(person);
        for(ContactsDataSourceListener listener : listenerList) {
            listener.didAddContact(person);
        }
    }



    public void deleteContact(Person person) {
         dataSource.deleteContact(person);
         for(ContactsDataSourceListener listener : listenerList){
             listener.didDeleteContact(person);
         }

    }


    public ArrayList<Person> getContactsByName (String name) {
        ArrayList<Person> contactsByName = dataSource.getContactsByName(name);
        for(ContactsDataSourceListener listener : listenerList) {
            listener.didGetContactsWithName(contactsByName,name);
        }
        return contactsByName;
    }

    public Person getContactByID (String ID) {

        Person person = dataSource.getContactByID(ID);
        for(ContactsDataSourceListener listener : listenerList) {
            listener.didGetContactWithId(person,ID);
        }
        return person;
    }

    public ArrayList<Person> allContacts() {
        ArrayList<Person> allListContacts = dataSource.allContacts();
        for(ContactsDataSourceListener listener : listenerList) {
            listener.didGetAllContacts(allListContacts);
        }
        return allListContacts;
    }




//    private void deletePerson(Person person) {
//        if(personList.contains(person)) {
//            personList.remove(person);
//        }
//    }

//    private void addPerson(Person newPerson) {
//        personList.add(newPerson);
//
//    }
 /*
    public void search(String searchString) {

        for(Person person : personList) {

            if(person.getName().toLowerCase().startsWith(searchString.toLowerCase())) {
                System.out.println(person.getName());
            }
        }
    }

    public void printByName() {
        System.out.println(personList);
    }

    public void printByLastName() {
        TreeSet<Person> sortByLastNameList = new TreeSet<Person>(new lastNameComparator());
        sortByLastNameList.addAll(personList);

        System.out.println(sortByLastNameList);
    }

    public void printByMail() {
        TreeSet<Person> sortByMailList = new TreeSet<Person>(new mailComparator());
        sortByMailList.addAll(personList);
        System.out.println(sortByMailList);
    }

    public void printByPhone() {

        TreeSet<Person> sortByPhoneList = new TreeSet<Person>(new phoneComparator());
        sortByPhoneList.addAll(personList);
        System.out.println(sortByPhoneList);
    }

    public void printByID() {

        TreeSet<Person> sortByID = new TreeSet<Person>(new idComparator());
        sortByID.addAll(personList);
        System.out.println(sortByID);
    }
    */
    private class idComparator implements Comparator<Person>  {
        public int  compare (Person a, Person b) {
            return a.getID().compareTo(b.getID());
        }
    }

    private class lastNameComparator implements Comparator<Person>  {
        public int  compare (Person a, Person b) {
            return a.getLastName().compareTo(b.getLastName());
        }
    }
    private class mailComparator implements Comparator<Person> {
        public int compare(Person a,Person b) {
            return a.getMail().compareTo(b.getMail());
        }
    }
    private class phoneComparator implements Comparator<Person> {
        public int compare(Person a,Person b) {
            return a.getPhoneNumber().compareTo(b.getPhoneNumber());
        }
    }
}
