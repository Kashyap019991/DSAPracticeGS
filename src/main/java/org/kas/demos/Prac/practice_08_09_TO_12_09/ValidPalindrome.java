package org.kas.demos.Prac.practice_08_09_TO_12_09;

class ValidPalindrome {//lc 125
    public static boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;

        while(start <= end){
            if(!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if(!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else{
                if(Character.toLowerCase(s.charAt(start)) != 
                    Character.toLowerCase(s.charAt(end)))
                    return false;
            start++;
            end--;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}