package javabasics;

public class OverRding extends MethodOverLoading {


    public static void main(String[] args) {

        MethodOverLoading s = new MethodOverLoading();
        s.m2();

    }

    public void m2(){

        System.out.println("hello");
    }
}
