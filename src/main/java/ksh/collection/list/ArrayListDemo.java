package ksh.collection.list;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        List ls = new ArrayList(2);
        ls.add(1);
        ls.add(2);
        ls.add("String");
        ls.add(1.5);
        System.out.println(ls);

        Set se = new HashSet();
        se.add(1);
        se.add(2);
        se.add("String");
        se.add(1.5);
        System.out.println(se);

        System.out.println("Reverse List is "+reverseList(ls));

        System.out.println("Shuffle List is "+shuffleList(ls));
        System.out.println("Shuffle List is "+shuffleList(ls));
        System.out.println("Swap List is "+swapList(ls));
    }

    public static List reverseList(List ll){
         Collections.reverse(ll);
         return ll;
    }

    /**
     * By calling Collections.shuffle() method you can shuffle the content of the ArrayList. Everytime you call shuffle() method, it generates different order of output.
     * @param ll
     * @return
     */
    public static List shuffleList(List ll){
        Collections.shuffle(ll);
        return ll;
    }

    public static List swapList(List ll){
        Collections.swap(ll, 2,1);
        return ll;
    }
}
