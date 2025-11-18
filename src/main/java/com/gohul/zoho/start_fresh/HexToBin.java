package com.gohul.zoho.start_fresh;

public class HexToBin {

    public static void main(String[] args) {

        String num = "1AC5";

        String[] hexList = {
                "0000", "0001", "0010", "0011",
                "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"
        };

        String res = "";

        for(char i: num.toCharArray()){
            res += hexList[Character.digit(i, 16)];
        }

        System.out.println(res);

    }
}
