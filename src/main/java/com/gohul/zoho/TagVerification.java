package com.gohul.zoho;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TagVerification {

    public static void main(String[] args) {

        List<String> htmlLines = Arrays.asList(
                "<html>",
                "</html>",
                "<head>",
                "</head>",
                "</html>"
        );
        int n = htmlLines.size();
        System.out.println(findOut(n, htmlLines));

    }

    public static boolean findOut(int n, List<String> list){

        if(list.size() % 2 == 1) return false;

        Stack<String> stack = new Stack<>();

        for(String tag: list){
            if(!tag.startsWith("<") || !tag.endsWith(">")) return false;
            tag = tag.replaceAll("[<>]", "");
            if(!tag.startsWith("/")) stack.push(tag);
            else{
                if(stack.isEmpty()) return false;
                if(stack.peek().equals(tag.substring(1))) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();

    }

}
