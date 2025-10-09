package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;
// There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
// Given a string text of words separated by a single space (no leading or trailing spaces) and a string
// brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.


// Example 1:
// Input: text = "hello world", brokenLetters = "ad"
// Output: 1
// Explanation: We cannot type "world" because the 'd' key is broken.
// Example 2:
// Input: text = "leet code", brokenLetters = "lt"
// Output: 1
// Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
// Example 3:
// Input: text = "leet code", brokenLetters = "e"
// Output: 0
// Explanation: We cannot type either word because the 'e' key is broken.
public class CanBeTypedWords {
    public static void main(String[] args) {
        String s = "hello world";
        String k = "ad";
        CanBeTypedWords sl = new CanBeTypedWords();
        System.out.println("test ans: " + sl.countMailfunctionWord(s, k));//1
        System.out.println("test ans: " + sl.countMailfunctionWord("leet code", "e"));//0
        System.out.println("test ans: " + sl.countMailfunctionWord("leet code", "lt"));//1
        System.out.println("test ans: " + sl.countMailfunctionWord("hello world", "z"));//2
        System.out.println("test ans: " + sl.countMailfunctionWord("What is the time", "s"));//3
    }

    public int countMailfunctionWord(String s, String k) {
        int result=0;

        String[] words = s.split(" ");
        for(String word:words){
            boolean isContains=false;
            for(Character ch:k.toCharArray()) {
                if (word.contains(String.valueOf(ch))){
                    isContains=true;
                    break;
                }

            }
            if(isContains ==false)
                result++;
        }
        return result;
    }
}
