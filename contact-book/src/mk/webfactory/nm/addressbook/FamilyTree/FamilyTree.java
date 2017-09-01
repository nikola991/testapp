package mk.webfactory.nm.addressbook.FamilyTree;

import java.util.*;

public class FamilyTree {

   private HashMap<String,FamilyMember> searchFamily = new HashMap<String,FamilyMember>();
    private int br=0;
    private int generation = 0;

    public void addSibling(FamilyMember member, FamilyMember sibling) {

        String memberID = member.getID();
        String siblingID = sibling.getID();
        if(searchFamily.get(memberID) == null) { addMember(member); }
        if(searchFamily.get(siblingID) == null) { addMember(sibling); }


        if(!member.isRelatedTo(sibling))
            member.setSibling(sibling);
        if(!sibling.isRelatedTo(member))
            sibling.setSibling(member);

    }

    public void addParent(FamilyMember member, FamilyMember parent) {
        String memberID = member.getID();
        String parentID = parent.getID();
        if (searchFamily.get(memberID) == null) {
            addMember(member);
        }
        if (searchFamily.get(parentID) == null) {
            addMember(parent);
        }

        if (!member.isRelatedTo(parent))
            member.setParent(parent);
        if (!parent.isRelatedTo(member))
            parent.setChild(member);

    }

     public void addChild(FamilyMember member, FamilyMember child) {
         String memberID = member.getID();
         String childID = child.getID();

         if (searchFamily.get(memberID) == null) {
             addMember(member);
         }
         if (searchFamily.get(childID) == null) {
             addMember(child);
         }

         if (!member.isRelatedTo(child))
             member.setChild(child);
         if (!child.isRelatedTo(member))
             child.setParent(member);
     }
     public void addPartner(FamilyMember partner, FamilyMember partner2) {
         String  partnerID = partner.getID();
         String  partner2ID = partner2.getID();

         if (searchFamily.get(partnerID) == null) {
             addMember(partner);
         }
         if (searchFamily.get(partner2ID) == null) {
             addMember(partner2);
         }

         if (!partner.isRelatedTo(partner2))
             partner.setPartner(partner2);
         if (!partner2.isRelatedTo(partner))
             partner2.setPartner(partner);

     }

   public void printTree() {

        System.out.println(searchFamily);
   }

   public void printFamilyTreeOfMember(FamilyMember member) {

       for (int i=0; i <= getGenerations(member); i++) {
           printFamilyTreeOfMember(member, i,member);
       }
   }

   private void printFamilyTreeOfMember(FamilyMember nextMember, int generation,FamilyMember parent) {     //dodaden referenten member
       ArrayList<FamilyMember> children = nextMember.getChildrenList();
       if (children.isEmpty()) {
           return;
       }

       for (FamilyMember child : children) {
           printFamilyTreeOfMember(child, generation,parent);

           if(getGeneration(child, parent) == generation) {          //child vo odnos na prviot parent (ne vo odnos na prethodniot)
               System.out.println(child.getName() + " " + generation);
           }
       }
   }
     private int getGenerations(FamilyMember member) {
        int br = 0;
        int max = 0;
        return getGenerations(member,br,max);
     }



     private int getGenerations(FamilyMember member,int br,int maxDepth) {
         ArrayList<FamilyMember> children = member.getChildrenList();
         if (children.isEmpty()) {
              return br-1;
             }
             for (FamilyMember child : children) {

                 maxDepth =  Math.max(maxDepth,getGenerations(child, br+1, maxDepth));



             }


             return maxDepth;



     }

   public int getGeneration(FamilyMember member,FamilyMember relative) {
        int br = 0;
        return getGeneration(br,member, relative);
   }

    private int getGeneration(int br, FamilyMember member,FamilyMember relative) {

        if (member.getID().equals(relative.getID())) {
            return br-1;
        }

        if(member.hasParent1()) {
            return getGeneration(++br, member.getParent1(), relative);
        }

        if(member.hasParent2()) {
            return getGeneration(br++, member.getParent2(), relative);
        }

        return -1;
    }





    public void addMember(FamilyMember member) {
        searchFamily.put(member.getID(), member);
    }




}
