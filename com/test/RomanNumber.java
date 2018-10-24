package com.test;

public class RomanNumber {

    public static void main(String[] args) {
        String s = new RomanNumber().intToRoman(2767);
        int a = 1;
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = num / 1000;
        num = num % 1000;
        appendN(sb, "M", m);
        if(num >= 100)
            convertHundreds(num / 100, sb);
        num = num % 100;

        if(num >= 10)
            convertTens(num / 10, sb);
        num = num % 10;

        if(num > 0)
            convertUnits(num, sb);
        return sb.toString();
    }

    private void convertHundreds(int n, StringBuilder sb){
        convertHundreds(n, "C", "D", "M", sb);
    }

    private void convertTens(int n, StringBuilder sb){
        convertHundreds(n, "X", "L", "C", sb);
    }

    private void convertUnits(int n, StringBuilder sb){
        convertHundreds(n, "I", "V", "X", sb);
    }

    private void convertHundreds(int n, String below, String mid, String upper, StringBuilder sb){
        if(n > 0 && n <=3) {
            appendN(sb, below, n);
        } else if (n <=5) {
            if(n ==4) {
                appendN(sb, below, 1);
            }
            appendN(sb, mid, 1);
        } else if(n <= 8) {
            appendN(sb, mid, 1);
            appendN(sb, below, n - 5);
        } else {
            appendN(sb, below, 1);
            appendN(sb, upper, 1);
        }
    }

    private void appendN(StringBuilder sb, String d, int n){
        for(int i =0; i < n; i++){
            sb.append(d);
        }
    }
}
