package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carmentano on 23/05/2018.
 */
public class TextJustification {
    public static void main(String[] args) {
        String[] d = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = new TextJustification().fullJustify(d, 16);
        int a = 1;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> nextLineList = new ArrayList<>();
        int totNextLine = 0;

        for(int i =0; i < words.length; i++) {
            if(nextLineList.isEmpty()) {
                nextLineList.add(words[i]); //I am sure of this because of problem constraints
                totNextLine += words[i].length();
            } else {
                if(totNextLine + 1 + words[i].length() <= maxWidth) {       //I need at least one space
                    nextLineList.add(words[i]);
                    totNextLine += 1 + words[i].length();
                } else {
                    //time to generate the new row
                    result.add(centerJustified(nextLineList, maxWidth));

                    nextLineList.clear();
                    totNextLine = 0;
                    i--;
                }
            }
        }

        if(!nextLineList.isEmpty()) {
            result.add(leftJustified(nextLineList, maxWidth));
        }
        return result;
    }

    String centerJustified(List<String> words, int maxWitdth) {
        StringBuilder sb = new StringBuilder();
        int totSpaces = maxWitdth - words.stream().map(s -> s.length()).reduce((a, b) -> a + b).get();

        if(words.size() == 1) {
            sb.append(words.get(0));
            appendSpaces(sb, totSpaces);
        } else {
            int numSpaceSlots = words.size() - 1;
            int ordinarySpaces = totSpaces / numSpaceSlots;
            int extraSpaces = totSpaces % numSpaceSlots;

            for(int i = 0; i < words.size(); i ++) {
                sb.append(words.get(i));
                if(i != words.size() - 1) {
                    if (i < extraSpaces) {
                        appendSpaces(sb, ordinarySpaces + 1);
                    } else {
                        appendSpaces(sb, ordinarySpaces);
                    }
                }
            }
        }

        return sb.toString();
    }

    String leftJustified(List<String> words, int maxWitdth) {
        //left justf
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        for(int i = 1; i < words.size(); i++) {
            sb.append(' ');
            sb.append(words.get(i));
        }
        appendSpaces(sb, maxWitdth - sb.length());
        return sb.toString();
    }

    void appendSpaces(StringBuilder sb, int nspaces) {
        for(int i =0; i < nspaces; i++) {
            sb.append(' ');
        }
    }
}
