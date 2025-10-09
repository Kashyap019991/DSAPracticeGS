package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;
/*
// Reverse words in a string
// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and word order.

// Input 1: s="Test"
// Output 1: "tseT"

// Input 2: s="Hey There!"
// Output 2: "yeH !erehT"

// Input 3: s="Hey! Hi there."
// Output 3: s="!yeH iH .ereht"


 */
public class ReverseWordInStr {
    private static String getReverseStr(String s){
        StringBuilder result = new StringBuilder();
        String[] input = s.split(" ");

        for(int w=0;w<input.length;w++){
            String str=input[w];
            int n=str.length();
            for(int i=n-1;i>=0;i--) {
                result.append(str.charAt(i));
            }
            if(w!=input.length-1)
                result.append(" ");
        }
        return new String(result);
    }
    public static void main(String[] args) {
        boolean passed = true;
        String  s="Test";
        if(!"tseT".equals(getReverseStr(s))){
            passed =false;
        }

        String  s1="Hey! Hi there.";
        if(!"!yeH iH .ereht".equals(getReverseStr(s1))){
            passed =false;
        }

        String  s2="Hey There!";
        if(!"yeH !erehT".equals(getReverseStr(s2))){
            passed =false;
        }

        if(passed)
            System.out.println("All test passed");
        else
            System.out.println("Some test failed");
    }
}
