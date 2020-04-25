package com.jetbrains;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter String: ");
        Scanner scan = new Scanner(System.in);


        String st = new String();
        st = scan.nextLine();


        if (Palindrome(st) == true) {
            System.out.println(st + " is a palindrome");
        } else {
            System.out.println(st + " is not a palindrome");
        }

        System.out.println("_________________________");


        boolean flag1 = true;

        System.out.println("Enter String 1: ");
        String stn = scan.nextLine();
        System.out.println("Enter String 2: ");
        String std = scan.nextLine();


        System.out.println(stn);
        System.out.println(std);
        System.out.println();
        System.out.println();

        if ((Anagrams(stn, std) == true)) {
            flag1 = true;
        } else if ((Anagrams(stn, std) == false)) {
            flag1 = false;
        }


        if (flag1 == true) {
            System.out.println("anagrams");
        }

        if (flag1 == false) {
            System.out.println("not anagrams");
        }

        System.out.println("___________________________________");

        System.out.println("Enter number of cities: ");
        int num = scan.nextInt();
        String[] city = new String[num];

        scan.nextLine();

        for (int i = 0; i < city.length; i++) {
            System.out.println("Enter city " + (i + 1) + ":");
            city[i] = scan.nextLine();
        }

        System.out.println(Arrays.toString(sort(city)));

        System.out.println("_____________________________________-");

        System.out.println("Enter matrix 1 rows: ");
        int rows1 = scan.nextInt();
        System.out.println("Enter matrix 1 columns: ");
        int col1 = scan.nextInt();

        System.out.println("Enter matrix 2 rows: ");
        int rows2 = scan.nextInt();
        System.out.println("Enter matrix 2 columns: ");
        int col2 = scan.nextInt();

        double[][] matrix1 = new double[rows1][col1];

        double[][] matrix2 = new double[rows2][col2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.println("Enter Matrix 1, Entry (" + i + " , " + j + ")");
                matrix1[i][j] = scan.nextDouble();
            }

        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.println("Enter Matrix 2, Entry (" + i + " , " + j + ")");
                matrix2[i][j] = scan.nextDouble();
            }

        }


        for (int i = 0; i < rows1; i++) {
            System.out.println(Arrays.toString((multiplyMatrix(matrix1, matrix2))[i]));
        }


    }//main

    public static boolean Palindrome(String st) {
        boolean palindome = true;

        int i = 0;

        int j = st.length() - 1;

        while (i < j) {

            while (st.charAt(i) == ' ') {
                i++;
            }

            while (st.charAt(j) == ' ') {
                j--;
            }

            if (Character.toLowerCase(st.charAt(i)) == Character.toLowerCase(st.charAt(j))) {
                palindome = true;
            } else {
                palindome = false;
                break;
            }
            i++;
            j--;
        }


        return palindome;

    }

    public static String[] sort(String[] a) {
        String dummy = new String();
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (a[i].compareToIgnoreCase(a[j]) > 0) {
                    dummy = a[j];
                    a[j] = a[i];
                    a[i] = dummy;
                }

            }

            dummy = "";

        }

        return a;


    }

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int rows1 = a.length;
        int col1 = a[0].length;

        int rows2 = b.length;
        int col2 = b[0].length;


        double[][] result = new double[rows1][col2];

        double[][] columnsOfb = new double[col2][rows2];


        for (int i = 0; i < col2; i++) {
            for (int j = 0; j < rows2; j++) {
                columnsOfb[i][j] = b[j][i];
            }

        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < col2; j++) {
                result[i][j] = DotProduct(a[i], columnsOfb[j]);
            }


        }

        return result;

    }

    public static double DotProduct(double[] a, double[] b) {

        double[] result = new double[a.length];
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + (a[i] * b[i]);
        }

        return sum;
    }

    public static boolean Anagrams(String a, String b) {
        String a1 = "";
        String b1 = "";
        boolean flag = true;

        for (int i = 0; i < a.length(); i++) {
            if (Character.isLetter(a.charAt(i)) == true) {
                a1 += a.charAt(i);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (Character.isLetter(b.charAt(i)) == true) {
                b1 += b.charAt(i);
            }
        }

        a1 = a1.toLowerCase();
        b1 = b1.toLowerCase();

        char[] string1 = a1.toCharArray();

        char[] string2 = b1.toCharArray();

        Arrays.sort(string1);

        Arrays.sort(string2);

        for (int i = 0; i < string1.length; i++) {
            if (string1[i] != string2[i]) {
                flag = false;
                break;
            }
        }

        return flag;

    }


}//class
