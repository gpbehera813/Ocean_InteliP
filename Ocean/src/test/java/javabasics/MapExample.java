package javabasics;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {


        Map<Integer,String> m = new HashMap<Integer,String>();

        m.put(5678,"aravinth");
        m.put(788,"uyy");

        System.out.println(m);

        System.out.println(m.get(788));
    }
}
