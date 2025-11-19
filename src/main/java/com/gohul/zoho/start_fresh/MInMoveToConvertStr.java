package com.gohul.zoho.start_fresh;

public class MInMoveToConvertStr {

    public static void main(String[] args)  {

        String s1 = "XXX";
        String s2 = "XXOX";
        String s3 = "OOOO";

//        System.out.println(findOut(0, s1));
//        System.out.println(findOut(0, s2));
//        System.out.println(findOut(0, s3));

        System.out.println(optimal(s1));
        System.out.println(optimal(s2));
        System.out.println(optimal(s3));
    }

    public static int findOut(int index, String str){
        if (index >= str.length())
            return 0;

        if (str.charAt(index) == 'O')
            return findOut(index + 1, str);
        else
            return 1 + findOut(index + 3, str);
    }


    public static int optimal(String str){
        int move = 0;
        int i = 0;

        while (i < str.length()){
            if(str.charAt(i) == 'O') i++;
            else{
                move++;
                i+=3;
            }
        }

        return move;
    }

}
