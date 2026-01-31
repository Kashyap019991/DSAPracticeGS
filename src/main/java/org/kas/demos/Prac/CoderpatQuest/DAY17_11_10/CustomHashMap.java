package org.kas.demos.Prac.CoderpatQuest.DAY17_11_10;/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class CustomHashMap<K,V>{
  class Entry<K,V>{
    K key;
    V value;

    Entry(K key,V value){
      this.key = key;
      this.value= value;
    }
  }
  double Load_Factor = 0.75;
  int capacity= 16;
  List<LinkedList<Entry<K,V>>> buckets;
  int size=0;

  CustomHashMap(){//initialization
    buckets = new ArrayList<>();
    for(int i=0;i<capacity;i++){
      buckets.add(new LinkedList<>());
    }
  }

  void put(K key, V value){
    
    int ind = getIndex(key);
    
    //System.out.println(ind);
    LinkedList<Entry<K,V>> currBucket = buckets.get(ind);

    for(Entry<K,V> entry:currBucket){
      if(Objects.equals(entry.key, key))
      {
        entry.value =value;
        return;  
      }
    }
    currBucket.add(new Entry<K,V>(key,value));
    size++;
    //resize
    
    if(size >= capacity*Load_Factor){
      //System.out.println(key +" "+value);
      resize();
    }
  }

  void resize(){
    List<LinkedList<Entry<K,V>>> currBucket = buckets;

    int oldCapacity = capacity;
    capacity = capacity *2;
    //rehashEntry after increasing size
    buckets = new ArrayList<>();
    for(int i=0;i<capacity;i++){
      buckets.add(new LinkedList());
    }
    for(LinkedList<Entry<K,V>> bucket:currBucket){
      for(Entry<K,V> entry:bucket){
        put(entry.key,entry.value);
        //System.out.println("get val back: "+ entry.value + " " +this.get(entry.key));
      }
    }


  }

  int size(){
    return size;
  }

  V get(K key){
    int ind = getIndex(key);
    LinkedList<Entry<K,V>> bucket = buckets.get(ind);

    for(Entry<K,V> entry: bucket){
      ///System.out.println(entry.key + "  key:"+key);
      if(Objects.equals(entry.key,key))
        return entry.value;
    }
    return null;
  }

   
  int getIndex(K Key){
    if(Key==null) return 0;
    int ind= Math.abs(Key.hashCode())%capacity;
    //System.out.println("Key: "+Key + "   "+ ind+" "+capacity);
    return ind;
  }

  boolean containsKey(K key){
    V val = get(key);
    if(val == null)
      return false;
    else
      return true;
  }

}
class Solution {
  public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.get("two")); // Output: 2

        // Collision scenario: "Aa".hashCode() == "BB".hashCode() in Java
        map.put("Aa", 100);
        map.put("BB", 200);
        System.out.println(map.get("Aa")); // Output: 100
        System.out.println(map.get("BB")); // Output: 200

        // Resizing
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, i);
        }
        System.out.println(map.get("key15")); // Output: 15

        // Null handling
        map.put(null, 999);
        System.out.println(map.get(null)); // Output: 999

        // Contains methods
        System.out.println(map.containsKey("key10")); // true
        //System.out.println(map.containsValue(15));    // true

        // Entry set
        //for (Map.Entry<String, Integer> entry : map.entrySet()) {
          //  System.out.println(entry);
        //}
    }
}
