package com.patterrn;

public class PyramidPatterOne {
    public static void main(String[] args) {
        printPyramidTypeTwo(5);
    }

    /*
             1
            1 2
           1 2 3
          1 2 3 4
         1 2 3 4 5
     */
    public static void printPyramidOne(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /*
                1
              1 2 1
            1 2 3 2 1
          1 2 3 4 3 2 1
        1 2 3 4 5 4 3 2 1
     */
    public static void printPyramidTypeTwo(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            int j = 1;
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            j -= 2;
            for (int k = j; k >= 1; k--) {
                System.out.print(k + " ");
            }
            System.out.println();

        }
    }

    /*  *****
         ***
          *
         ***
        *****

            **********
             ********
              ******
               ****
                **
               ****
              ******
             ********
            **********

            *
           ***
          *****
         *******
        *********
         *******
          *****
           ***
            *

        A
       ABA
      ABCBA
     ABCDCBA
    ABCDEDCBA


    *****
    *   *
    *****
    **
    *  *
    *   *
    *    *

     */
    public static void printPyramidTypeThree(int n) {

    }
}
