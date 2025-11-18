package com.gohul.zoho.start_fresh;

public class BinToHex {

    public static void main(String[] args) {

        System.out.println(findOut("110001110"));
        System.out.println(findOut("1111001010010100001.010110110011011"));
    }

    public static String findOut(String binary){
        String[] hexDict = {
                "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F"
        };

        // Split integer + fraction parts
        int dotIndex = binary.indexOf('.');
        String integerPart;
        String decimalPart = "";

        if(dotIndex == -1){
            integerPart = binary;
        } else {
            integerPart = binary.substring(0, dotIndex);
            decimalPart = binary.substring(dotIndex + 1);
        }

        // ✔ Fix padding for integer part
        int rem = integerPart.length() % 4;
        if(rem != 0){
            int add = 4 - rem;
            String zero = "";
            for(int i = 0; i < add; i++) zero += "0";
            integerPart = zero + integerPart;
        }

        // ✔ Fix padding for decimal part
        rem = decimalPart.length() % 4;
        if(rem != 0){
            int add = 4 - rem;
            for(int i = 0; i < add; i++) decimalPart += "0";
        }

        // ✔ Convert integer part
        String intRes = "";
        for(int i = 0; i <= integerPart.length() - 4; i += 4){
            intRes += hexDict[ Integer.parseInt(integerPart.substring(i, i+4), 2) ];
        }

        // ✔ Convert decimal part
        String decRes = "";
        if(!decimalPart.isEmpty()){
            for(int i = 0; i <= decimalPart.length() - 4; i += 4){
                decRes += hexDict[ Integer.parseInt(decimalPart.substring(i, i+4), 2) ];
            }
        }

        // ✔ Remove leading zeros (keep one digit)
        int idx = 0;
        while(idx < intRes.length() - 1 && intRes.charAt(idx) == '0') idx++;
        intRes = intRes.substring(idx);

        return decRes.isEmpty() ? intRes : intRes + "." + decRes;
    }

}
