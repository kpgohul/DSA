package com.gohul.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Combination {

    public static void combination1(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        String temp = (up.length() == 1)? "": up.substring(1);
        combination1(temp,p+up.charAt(0));
        combination1(temp,p);
    }

    public static void combination2(String up, String p, List<String> result){
        if(up.isEmpty()){
            result.add(p);
            return;
        }
        String temp = (up.length() == 1)? "": up.substring(1);
        combination2(temp,p+up.charAt(0), result);
        combination2(temp,p, result);
    }

    public static void main(String[] args) {

//        combination1("abc", "");

//        List<String> result = new ArrayList<>();
//        combination2("abc", "", result);
//        Collections.sort(result);
//        System.out.println(result);

        optimal("abc");
    }

    public static void optimal(String given){
        List<String> result = new ArrayList<>();
        result.add("");

        for(char c: given.toCharArray()){
            List<String> temp = result.stream().toList();
            temp = temp.stream().map( str -> str+c).toList();
            result.addAll(temp);
        }
        System.out.println(result);

    }
}
