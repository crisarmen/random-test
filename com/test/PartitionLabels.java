package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by carmentano on 11/06/2018.
 */

/*

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

*/
public class PartitionLabels {

    public static void main (String[] args) {
        List<Integer> ababcbacadefegdehijhklij = new PartitionLabels().partitionLabels("ancdefghi");
        int  a = 1;
    }

    public List<Integer> partitionLabels(String S) {
        if(S.length() == 0) {
            return Arrays.asList(0);
        }

        Interval[] intervals = new Interval[26];
        for(int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            Interval interval = intervals[c.charValue()-'a'];
            if(interval == null) {
                intervals[c.charValue()-'a'] = new Interval(i,i);
            } else {
                interval.end = i;
            }

        }

//        Arrays.sort(intervals);
        List<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i] != null) {
                intervalList.add(intervals[i]);
            }
        }
        Collections.sort(intervalList);
        Interval currInterval = intervalList.get(0);

        List<Interval> mergedIntervals = new ArrayList<>();
        for(int i = 1; i < intervalList.size(); i++){
            Interval c = intervalList.get(i);
            if(currInterval.end > c.start) {
                currInterval.end = Math.max(c.end, currInterval.end);
            } else {
                mergedIntervals.add(currInterval);
                currInterval = c;
            }
        }

        mergedIntervals.add(currInterval);


        return mergedIntervals.stream().map(i -> (i.end - i.start + 1)).collect(Collectors.toList());
    }


    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }
}
