package mk.webfactory.nm.addressbook.Model;

import java.util.ArrayList;

public class TestMain {

    public static void main(String [] args) {

        ContactsInMemory dataSource = new ContactsInMemory();
        ContactBook contactBook = new ContactBook(dataSource);
        contactBook.addContact(new Person("Nikola","Mirkovski","078258568"));
        contactBook.addListener(new ContactsContract.ContactsDataSourceListener() {
            @Override
            public void didAddContact(Person person) {

            }

            @Override
            public void didDeleteContact(Person person) {

            }

            @Override
            public void didGetContactsWithName(ArrayList<Person> contactsByName, String name) {

            }

            @Override
            public void didGetContactWithId(Person person, String id) {

            }

            @Override
            public void didGetAllContacts(ArrayList<Person> allContacts) {

            }
        });



    }
}
