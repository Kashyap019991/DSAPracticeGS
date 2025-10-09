package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: There are n people standing in a circle waiting to be executed.
The counting out begins at some point in the circle and proceeds around the circle in a
fixed direction. In each step, a certain number of people are skipped and the next person
 is executed. The elimination proceeds around the circle (which is becoming
 smaller and smaller as the executed people are removed), until only the last person remains,
 who is given freedom. Given the total number of person n and a number k which indicates
 that k-1 persons are skipped and the kth person is killed in a circle.
 The task is to choose the place in the initial circle so that you are the last one
 remaining and so survive.
 */
public class JosepheusProblem {


    static void jos(List<Integer> person, int k, int index)
    {   //base case
        if(person.size()==1){
            System.out.println(person.get(0));
            return;
        }
        //find index tobe removed
        index = (index+k)%person.size();
        person.remove(index);
        jos(person,k,index);

    }

    // Driver code
    public static void main(String [] args)
    {
        int n = 5; // specific n and k values for original
        // josephus problem
        int k = 2;
        List<Integer> personList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            personList.add(i);
        }

        int index =0;
        jos(personList,k-1,index);
    }
}