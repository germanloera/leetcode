package com.interview;

import java.util.Scanner;

public class Main {

    //0 1 2 3 4 5 6 7  8  9
    //0 1 1 2 3 5 8 13 21 34 55 89

    public static int Fibbonaci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1 || n== 2){
            return 1;

        }
        int f = 1;
        int f1 = 1;
int t = 0;

        for(int i = 1; i <= n-2 ; i++){

            t = f;
            f = f+ f1;
            f1 = t;

        }

        return f;

    }


    public static int Fibbonaci1(int n){
        if(n == 0){
            return 0;
        } else if(n == 1 ){
            return 1;

        }
        return Fibbonaci1(n-1)+Fibbonaci1(n-2);

    }

    public static int Fibbonaci3(int n){
        double sqrt5 = Math.sqrt(5);

        return (int) ((Math.pow(1+sqrt5, n) - Math.pow(1-sqrt5, n)) / (Math.pow(2,n)*sqrt5));
    }

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        //System.out.println("Ingrese el valor de N " );
       // int n = s.nextInt();

        for (int n = 0 ; n < 10 ; n++) {
            int result = Main.Fibbonaci3(n);
            System.out.println("Fibbonaci = " + result);
        }

    }
}
