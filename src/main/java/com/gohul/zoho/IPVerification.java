package com.gohul.zoho;

public class IPVerification {

    public static void main(String[] args) {
        String ip = "192.168.0.5";
        String[] ss = {
                "192.168.0.1",
                "192.168.0.10",
                "192.168.0.1-192.168.0.9"
        };
        System.out.println(findOut(ip, ss));
    }

    public static boolean findOut(String given, String[] list){

        long givenIpVal = ipToNumeric(given);

        for(String ith: list){
            String[] p = ith.split("-");
            if(p.length == 1 && givenIpVal == ipToNumeric(ith)) return true;
            else{
                long start = ipToNumeric(p[0]);
                long end = ipToNumeric(p[p.length - 1]);
                if (givenIpVal >= start && givenIpVal <= end) return true;
            }
        }
        return false;

    }

    public static long ipToNumeric(String ip){
        String[] list = ip.split("\\.");
        long sum = 0;
        int pow = 3;
        for(String ith: list){
            long curr = Long.parseLong(ith) * (long) Math.pow(256, pow);
            sum+=curr;
            pow --;
        }
        return sum;
    }
}
