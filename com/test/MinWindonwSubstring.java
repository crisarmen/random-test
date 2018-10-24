package com.test;

import java.util.HashMap;
import java.util.Map;

public class MinWindonwSubstring {

    public static void main(String[] args) {
        String s = new MinWindonwSubstring().minWindow("AAADBBD", "AABD");
        int a = 1;
    }

    public String minWindow(String s, String t) {
        String result = null;
        Map<Character, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            occurrences.compute(c, (k1, v1) -> v1 == null ? 1 : v1 + 1);
        }

        int b, e;
        b = e = 0;
        Map<Character, Integer> currSubstrOccurrences = new HashMap<>();
        while(e < s.length() && b < s.length()) {
            boolean foundSol = false;
            while(e < s.length() && !foundSol) {
                Character c = s.charAt(e);
                if (occurrences.keySet().contains(c)) {
                    currSubstrOccurrences.compute(c, (k1, v1) -> v1 == null ? 1 : v1 + 1);
                }

                if(containsAtLeast(currSubstrOccurrences, occurrences)) {
                    if (result == null || result.length() > e - b) {
                        result = s.substring(b, e + 1);
                    }
                    foundSol = true;
                } else {
                    e++;
                }
            }

            if(!(e == s.length() && !foundSol)) {
                foundSol = true;
                while (b <= e && foundSol) {
                    Character c = s.charAt(b);
                    if (occurrences.keySet().contains(c)) {
                        currSubstrOccurrences.put(c, currSubstrOccurrences.get(c) - 1);
                    }

                    if (!containsAtLeast(currSubstrOccurrences, occurrences)) {
                        if (result == null || result.length() > e - b) {
                            result = s.substring(b, e + 1);
                        }
                        e++;    //need to consider a new end of string from now (otherwise will add this twice..)
                        foundSol = false;
                    }
                    b++;
                }
            } else {
                e = s.length();
            }
        }

        return result;
    }

    private boolean containsAtLeast(Map<Character, Integer> substr, Map<Character, Integer> occurrences) {
        for(Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            Integer substrVal = substr.get(key);
            if(substrVal == null || substrVal < value) {
                return false;
            }
        }

        return true;
    }
}
