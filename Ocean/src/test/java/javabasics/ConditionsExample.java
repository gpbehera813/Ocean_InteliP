package javabasics;

public class ConditionsExample {

    public static void main(String[] args) {

        int firstNumber = 78;
        int secondNumber = 56 ;

        if(firstNumber == secondNumber) {

            System.out.println("Both are equal");
        }
        else if(firstNumber < secondNumber){
            System.out.println("a is lesser");
        }
        else if(firstNumber > secondNumber){
            System.out.println("a is greater");
        }
        else{
            System.out.println("Both are not equal");
        }

    }
}
