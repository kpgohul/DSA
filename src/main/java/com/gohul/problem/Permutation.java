package com.gohul.problem;

public class Permutation {

    public static void main(String[] args) {

        permutation1("abc", "");

    }

    public static void permutation1(String up, String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char curr = up.charAt(0);

        for(int i=0; i<=p.length(); i++){
            String temp = p.substring(0, i) + curr + p.substring(i);
            permutation1(up.substring(1), temp);
        }
    }
}
