package javabasics;

public class ArrayExample {

    public static void main(String[] args) {

        int [] a = {56,78,90,100} ; //0,1,2,3

        for (int s:a){

            System.out.println(s);
        }

        String [] b ={"aravinth","learnmore"}; //0,1

        for(String l:b){
            System.out.println(l);
        }


        for(int k =0 ; k < a.length ; k++){

            System.out.println(a[k]);
        }

        for(int j=0; j < b.length; j++){
            System.out.println(b[j]);
        }

        int [] h = {56,78,90};

        for(int j:h){
            System.out.println(j);
        }

    }
}
