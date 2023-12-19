package javabasics;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    int a = 90;

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(56);
        l1.add(78);
        l1.add(100);

        System.out.println(l1);

        for(int o:l1){
            System.out.println(o);
        }
    }
}
