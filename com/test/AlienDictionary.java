package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlienDictionary {

    public static void main(String[] args) {
//        String[] words = {
//            "wrt",
//            "wrf",
//            "er",
//            "ett",
//            "rftt"
//        };

        String[] words = {
            "ab",
            "adc"
        };

        String s = new AlienDictionary().alienOrder(words);
        System.out.println(s);
        int a = 1;
    }

    public String alienOrder(String[] words) {
        boolean[][] letters = new boolean[26][26];
        Set<Character> letterSet = new HashSet<>();

        String w1 = words[0];
        if(words.length == 1) {
            return w1;
        }

        for(int i =0; i < w1.length(); i++){
            letterSet.add(w1.charAt(i));
        }

        for(int i = 1; i < words.length; i++) {
            String w2 = words[i];
            for(int j =0; j < w2.length(); j++){
                letterSet.add(w2.charAt(j));
            }
            adjustLetters(w1, w2, letters);
            w1 = w2;
        }

        StringBuilder sb = new StringBuilder();

        while(!letterSet.isEmpty()) {
            List<Integer> letterindexes = lettersWithNoIncomingEdges(letters, letterSet);
            if(letterindexes.size() == 0) {
                return "";
            } else {
                int idx = letterindexes.get(0);
                sb.append((char)('a'+idx));

                for(int i =0; i < 26; i++) {
                    letters[idx][i] = false;
                }

                letterSet.remove((char)('a'+idx));
            }
        }

        return sb.toString();
    }

    private List<Integer> lettersWithNoIncomingEdges(boolean[][] letters, Set<Character> letterSet){
        List<Integer> possibleFirstLetters = new ArrayList<>();
        for(Character c : letterSet) {
//        for(int i = 0; i < 26; i++) {
            int i = c - 'a';
            boolean foundINcomingedge = false;
            for(int j = 0; j < 26 && !foundINcomingedge; j++) {
                if(letters[j][i]) {
                    foundINcomingedge = true;
                }
            }
            if(!foundINcomingedge) {
                possibleFirstLetters.add(i);
            }
        }
        return possibleFirstLetters;
    }

    private void adjustLetters(String s1, String s2, boolean[][] letters) {
        for(int i=0, j=0; i < s1.length() && j < s2.length(); i++, j++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2) {
                letters[c1-'a'][c2-'a'] = true;
                break;
            }
        }
    }
}
