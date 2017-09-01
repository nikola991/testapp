package mk.webfactory.nm.addressbook.Model;

/*

import mk.webfactory.nm.addressbook.Util.EmailValidator;

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
            } while (!valid);

            System.out.println("Vnesi telefonski broj: ");
            phoneNumber = in.nextLine();


        Person newPerson = new Person(name,lastName,mail,phoneNumber);
        contactBook.addPerson(newPerson);
        Person first = new Person("nik","petrovikj","maki@gmail.com","384834");
    Person second = new Person("mark","hoffman","maksi@gmail.com","384834");
       contactBook.addPerson(first);
       contactBook.addPerson(second);
        System.out.println("Vnesi string za prebaruvanje: ");
        String searchString = in.nextLine();
        contactBook.search(searchString);

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
            case 5: contactBook.printByID();
            break;

            default: System.out.println("Invalid Number");
        }





    }
}
*/