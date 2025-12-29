package org.kas.demos.Prac.CoderpatQuest.DAY18_13_10;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

//import org.postgresql.ssl.SingleCertValidatingFactory;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class SingletonClazz{
  private static volatile SingletonClazz instance ;
  private SingletonClazz(){}

  static SingletonClazz getInstace(){
        if(instance == null){
          synchronized(SingletonClazz.class){
            if(instance == null){
              instance = new SingletonClazz();
            }
          }
        }
        return SingletonClazz.instance;
  }
}
class Solution {
  
  public static void main(String [] args)
    {
        //SingletonClazz s = new SingletonClazz();
        System.out.println(SingletonClazz.getInstace().hashCode());
        System.out.println(SingletonClazz.getInstace().hashCode());
    }
}
