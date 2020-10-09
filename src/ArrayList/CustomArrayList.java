package ArrayList;

import java.util.Arrays;


/**
 * Big' O' values for our ArrayList.CustomArrayList functions are:
 * Get	Add	remove
 * O(1)	O(1)	O(1)
 */
public class CustomArrayList {
    private Object[] arrayPlaceHolder;
    private int actSize = 0;

    public CustomArrayList() {
        arrayPlaceHolder = new Object[10];
    }

    public Object get(int index) {
        if (index < actSize) {
            return arrayPlaceHolder[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object obj) {
        if (arrayPlaceHolder.length - actSize <= 5) {
            increaseListSize();
        }
        arrayPlaceHolder[actSize++] = obj;
    }

    public Object remove(int index) {
        if (index < actSize) {
            Object obj = arrayPlaceHolder[index];
            arrayPlaceHolder[index] = null;
            int tmp = index;
            while (tmp < actSize) {
                arrayPlaceHolder[tmp] = arrayPlaceHolder[tmp + 1];
                arrayPlaceHolder[tmp + 1] = null;
                tmp++;
            }
            actSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public int size() {
        return actSize;
    }

    private void increaseListSize() {
        arrayPlaceHolder = Arrays.copyOf(arrayPlaceHolder, arrayPlaceHolder.length * 2);
        System.out.println("nNew length: " + arrayPlaceHolder.length);
    }
    public static void main(String[]args){
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        for(int i=0;i<customArrayList.size();i++){
            System.out.print(customArrayList.get(i)+" ");
        }
        customArrayList.add(9);
        System.out.println("Element at Index 3:"+customArrayList.get(3));
        System.out.println("Size: "+customArrayList.size());
        System.out.println("Removing element at index 1: "+customArrayList.remove(1));
        for(int i=0;i<customArrayList.size();i++){
            System.out.print(customArrayList.get(i)+" ");
        }
    }
}
