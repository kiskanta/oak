package ksh.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Param3 - Copy or Clone a LinekdList.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List ll= new  LinkedList();
        ll.add("1");
        ll.add("String");
        ll.add(14);
        listIterator(ll);

        List cll=  llClone(new LinkedList(ll));
        System.out.println("Cloned Linked List"+ cll);

        // Program 4
        ll.addAll(cll);
        System.out.println("AddAll of ll with cll is "+ll);

        // program 5 - delete all elements
        ll.clear();
        System.out.println("After Clear all elements in ll is "+ll);

        // Program 6 - contains all

        // program 7 - toArray
        List<String> lls = new LinkedList<>();
        lls.add("Hello");
        lls.add("Program");
        lls.add("World");

        //String[] strArr = (String) lls.toArray();
    }


    public static void listIterator(List ll){
        Iterator lt =  ll.iterator();

        while(lt.hasNext()){
            System.out.println(lt.next());
        }
    }
    public static List llClone(LinkedList ll){
        return (List) ll.clone();
    }

}
