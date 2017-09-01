package mk.webfactory.nm.addressbook.FamilyTree;

import mk.webfactory.nm.addressbook.Model.Person;
import java.util.*;


public class FamilyMember extends Person {



    private ArrayList<FamilyMember> siblings = new ArrayList<FamilyMember>();
    private ArrayList<FamilyMember> parents = new ArrayList<FamilyMember>();
    private ArrayList<FamilyMember> children = new ArrayList<FamilyMember>();
    private FamilyMember marriedTo;



     public FamilyMember (String name, String lastName, String phoneNumber) {
         super(name,lastName,phoneNumber);

     }

     public ArrayList<FamilyMember> getChildrenList () {
         return children;
     }

      public  boolean hasParent1() {
         return (!parents.isEmpty());

      }
      public boolean hasParent2() {
         return (parents.size()==1);
      }

      public FamilyMember getParent1() {
         if(parents.isEmpty()) return null;
         return parents.get(0);
      }
      public FamilyMember getParent2() {
         if(parents.size()<1) return null;
         return parents.get(1);
      }

    public boolean equals (Object o) {
        FamilyMember x = (FamilyMember) o;
        if (x.getID() == getID()) return true;
        return false;
    }
     public void setSibling(FamilyMember sibling) {
          siblings.add(sibling);
     }

     public void setParent(FamilyMember parent) {
         parents.add(parent);
     }
     public void setChild(FamilyMember child) {
         children.add(child);
     }
     public void setPartner (FamilyMember partner) {
         marriedTo = partner;
     }


     public boolean isRelatedTo (FamilyMember member) {

             if(siblings.contains(member))
                 return true;
             if(parents.contains(member))
                 return true;
              if(children.contains(member))
                  return true;
              if(marriedTo == member)
             return true;

         return false;
     }





      }



