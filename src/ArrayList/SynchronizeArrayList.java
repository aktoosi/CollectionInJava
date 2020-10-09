package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * By Default ArrayList is not synchronized,
 * but it is possible to create a synchronized arrayList by following two ways
 *
 *     Using Collections.synchronizedList() method
 *     Using thread-safe variant of ArrayList which is : CopyOnWriteArrayList
 */
public class SynchronizeArrayList {
    public static void main(String[] a) {

        /*
        Using Collections.synchronizedList() method for ArrayList.SynchronizeArrayList
         */
        List<String> syncal = Collections.synchronizedList(new ArrayList<String>());

        //Adding elements to synchronized ArrayList
        syncal.add("Pen");
        syncal.add("NoteBook");
        syncal.add("Ink");

        System.out.println("Iterating synchronized ArrayList:");
        synchronized (syncal) {
            Iterator<String> iterator = syncal.iterator();
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }

        /**
         * Using thread-safe variant of ArrayList: CopyOnWriteArrayList for ArrayList.SynchronizeArrayList
         */

        CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();

        //Adding elements to synchronized ArrayList
        al.add("Pen");
        al.add("NoteBook");
        al.add("Ink");

        System.out.println("Displaying synchronized ArrayList Elements:");
        //Synchronized block is not required in this method
        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
