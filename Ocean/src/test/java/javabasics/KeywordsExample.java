package javabasics;

public class KeywordsExample extends ListExample {


     int a = 45;
    final double pie = 3.14;
    public static void main(String[] args) {

        KeywordsExample k = new KeywordsExample();
        k.m1();
    }

    public void m1(){

        int a = 1;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);

        System.out.println(pie);
    }


}
