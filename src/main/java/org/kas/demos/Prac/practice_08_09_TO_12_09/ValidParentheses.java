package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch:s.toCharArray()){

            if(ch == '(' || ch == '{' || ch == '[')
            { 
                   st.push(ch);
                    
            }
            else{
                if(st.isEmpty())
                    return false;
                char top= st.pop();
                if(ch == ')' && top != '(') return false;
                if(ch == '}' && top != '{') return false;
                if(ch == ']' && top != '[') return false;
            } 

            
        }
       return st.isEmpty(); 
    }
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        ValidParentheses checker = new ValidParentheses();

        System.out.print("Enter a string with parentheses: ");
        String input = "()";//scanner.nextLine();

        if (checker.isValid(input)) {
            System.out.println("The input string has valid parentheses.");
        } else {
            System.out.println("The input string has invalid parentheses.");
        }

        //scanner.close();
    }
}