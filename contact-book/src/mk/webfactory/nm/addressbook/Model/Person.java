package mk.webfactory.nm.addressbook.Model;

import java.util.UUID;
public class Person implements Comparable<Person> {

    private String name;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private String uniqueID;

    public Person() {
        uniqueID = UUID.randomUUID().toString();
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.name = lastName;
    }
    public void setMail(String mail) {
        this.mail=mail;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public Person (String name, String lastName, String mail, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        uniqueID = UUID.randomUUID().toString();

    }

    public Person (String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;

        this.phoneNumber = phoneNumber;
        uniqueID = UUID.randomUUID().toString();

    }
    public String getID() {
        return uniqueID;
    }



    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMail() {
        return mail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Person a) {
        return getName().compareTo(a.getName());
    }
    public boolean equals (Object o) {
        Person x = (Person) o;
        if (x.getID() == getID()) return true;
        return false;
    }



}
