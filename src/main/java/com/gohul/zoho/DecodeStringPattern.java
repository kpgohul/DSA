package com.gohul.zoho;

import com.gohul.dsa.data_structure.Stack;

public class DecodeStringPattern {

    public static void main(String[] args) {
        String input = "A(B(C){2}){2}D";
        System.out.println(findOut(input));
    }

    public static String findOut(String str){
        Stack<Character> stack = new Stack<>();
        int i =0;

        while(i < str.length()){
            if(str.charAt(i) != '{') stack.push(str.charAt(i++));
            else{
                String temp = "";
                for(char m: stack) temp = m+temp;
                System.out.println("Current stack:: "+temp);
                int j = i;
                while(str.charAt(j) != '}') j++;
                int times = Integer.parseInt(str.substring(i+1, j));
                System.out.println("Current times:: "+times);
                String val = "";
                stack.pop();
                while(stack.peek() != '('){
                    val = stack.pop() + val;
                }
                stack.pop();
                System.out.println("Current val:: "+val);
                String res = "";
                while (times-->0) res = val + res;
                System.out.println("Result val:: "+val);
                System.out.println();
                for(int k=0; k<res.length(); k++) stack.push(res.charAt(k));
                i = j + 1;
            }
        }
        StringBuilder res = new StringBuilder();
        for(char ch: stack){
            res.append(ch);
        }
        return res.reverse().toString();

    }
}
