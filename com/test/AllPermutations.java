package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmentano on 05/07/2018.
 */
public class AllPermutations {
    public static void main(String[] aregs) {
//        boolean abcb = new AllPermutations().isPalindrom("abcDb", 1, 3);
        List<List<String>> abc = new AllPermutations().partition("ssbbss");
        int a = 1;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int startIdx, List<String> partialResult, List<List<String>> result) {
        if(s.length() == startIdx) {
            result.add(new ArrayList<>(partialResult));
        } else {
            for (int i = startIdx; i < s.length(); i++) {
                if (isPalindrom(s, startIdx, i)) {
                    partialResult.add(s.substring(startIdx, i + 1));
                    partition(s, i + 1, partialResult, result);
                    partialResult.remove(partialResult.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrom(String s, int startIdx, int endIdx) {

        while (startIdx < endIdx) {
            if(s.charAt(startIdx) != s.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }
}
