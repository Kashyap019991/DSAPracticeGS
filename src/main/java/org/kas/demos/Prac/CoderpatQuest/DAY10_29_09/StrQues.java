package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StrQues {
    public static void main(String[] args) {

        String abc = "ABC";
        String def = "ABC";

        String efg = "DEF";
        String mno = new String("ABC");
        System.out.println(abc == def);//true
        System.out.println(def == mno);//false
        System.out.println(def.equals(abc));//true
        System.out.println(abc.equals(mno));//true

        String s1= new String("hello");
        String s2= new String("hello");
        System.out.println(s1.equals(s2));//true
        System.out.println(s1==s2);//false
    }
}
