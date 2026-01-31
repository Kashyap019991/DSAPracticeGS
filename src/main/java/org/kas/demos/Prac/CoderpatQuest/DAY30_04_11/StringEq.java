package org.kas.demos.Prac.CoderpatQuest.DAY30_04_11;

public class StringEq {

    public static void main(String[] args) {
        String s1= new String("hello");
        String s2= new String("hello");
        String s3 = "abc",s4 = "abc";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s3==s4);
    }
}
