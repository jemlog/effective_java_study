package me.whiteship.mytest;

public class StringTest {

    public static void main(String[] args) {

        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");
        System.out.println(str1 == str2); // true
        System.out.println(str1.equals(str2)); // true
        System.out.println(str2 == str3); // false
        System.out.println(str1 == str4); // false


    }
}
