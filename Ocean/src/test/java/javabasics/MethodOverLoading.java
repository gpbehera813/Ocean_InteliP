package javabasics;

public class MethodOverLoading {

    public static void main(String[] args) {


        MethodOverLoading m = new MethodOverLoading();
        m.m1("aravinth");
    }

    public void m2(){
        System.out.println("overload");
    }

    public void m1(int a){

        System.out.println(a);
    }

    public void m1(String a){
        System.out.println(a);
    }

    public void m1(int a , int b){
        System.out.println(a);
    }
}
