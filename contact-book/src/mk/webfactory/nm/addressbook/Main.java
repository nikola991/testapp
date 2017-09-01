package mk.webfactory.nm.addressbook;
 import java.util.regex.Matcher;
  import java.util.regex.Pattern;
                                  

import java.util.*;


public class Main {

    private String name;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private ContactBook contactBook = new ContactBook();

    public final static void main(String[] args) {
         Main mainClass = new Main();
         mainClass.go();

    }

    private void go() {

        EmailValidator validator = new EmailValidator();
        Scanner in = new Scanner(System.in);
        System.out.println("Vnesete gi vashite informacii");
        System.out.println("Vnesi ime: ");
        name = in.nextLine();
        System.out.println("Vnesi prezime: ");
        lastName = in.nextLine();
        boolean valid = true;
              do {
                  System.out.println("Vnesi mail");
                  mail = in.nextLine();
                  valid = validator.validate(mail);
                  if (!valid) System.out.println("Email is invalid");
              } while(!valid);
        
        System.out.println("Vnesi telefonski broj: ");
        phoneNumber = in.nextLine();
         

         Person newPerson = new Person(name,lastName,mail,phoneNumber);
          contactBook.addPerson(newPerson);

          System.out.println("Podredena lista spored ime - 1");
          System.out.println("Podredena lista spored prezime - 2");
          System.out.println("Podredena lista spored mail - 3");
          System.out.println("Podredena lista spored telefonski broj - 4");

          int selectOption = in.nextInt();
          switch(selectOption)  {
              case 1 : contactBook.printByName();
              break;
              case 2: contactBook.printByLastName();
              break;
              case 3: contactBook.printByMail();
              break;
              case 4: contactBook.printByPhone();
              break;
              default: System.out.println("Invalid Number");
          }

    }
}

 class ContactBook {

     private TreeSet<Person> personList = new TreeSet<Person>();

     public void addPerson(Person newPerson) {
         personList.add(newPerson);

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



class Person implements Comparable<Person> {

    private String name;
    private String lastName;
    private String mail;
    private String phoneNumber;


    public Person (String name, String lastName, String mail, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;

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



}



 class EmailValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}