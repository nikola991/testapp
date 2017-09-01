package mk.webfactory.nm.addressbook.FamilyTree;

import java.util.Scanner;
import mk.webfactory.nm.addressbook.Util.EmailValidator;
public class Main {

    private FamilyTree familyTree;


    public static void main(String [] args) {
        Main  mainMethod = new Main();
        mainMethod.testFamilyTree();
    }


    public void testFamilyTree() {

        familyTree = new FamilyTree();
        FamilyMember parent = new FamilyMember("Orce", "Mirkovski", "078258568");
        FamilyMember parent2 = new FamilyMember("Zorica", "Mirkovska", "070939439");
        FamilyMember child = new FamilyMember("Nikola", "Mirkovski","078258568");
        FamilyMember child2 = new FamilyMember("Filip","Mirkovski","075834834");
        FamilyMember child3 = new FamilyMember("Marko", "Mirkovski","078258568");
        FamilyMember child4 = new FamilyMember("Sashe","Mirkovski","075834834");
        FamilyMember child5 = new FamilyMember("Ace","Mirkovski","075834834");
        FamilyMember child6 = new FamilyMember("Kate","Mirkovski","075834834");
        FamilyMember child7 = new FamilyMember("Ana","Mirkovski","075834834");


        familyTree.addPartner(parent,parent2);
        familyTree.addChild(parent,child);    //nikola
        familyTree.addChild(parent,child2);   //filip
        familyTree.addChild(parent2,child);
        familyTree.addChild(parent2,child2);
        familyTree.addChild(child,child3);
        familyTree.addChild(child,child4);
        familyTree.addChild(child3,child5);
        familyTree.addChild(child3,child6);
        familyTree.addChild(child6,child7);


        familyTree.printFamilyTreeOfMember(parent2);


    }

}
