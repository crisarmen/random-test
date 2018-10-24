package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<Interval> mergedIntervals = new ArrayList<>();
            intervals = intervals.stream().sorted(Comparator.comparingInt(o -> o.start)).collect(Collectors.toList());
            Interval currentInterval = new Interval(intervals.get(0).start, intervals.get(0).end);

            for(int i = 1; i < intervals.size(); i++) {
                Interval c = intervals.get(i);
                if(c.start > currentInterval.end) {
                    mergedIntervals.add(currentInterval);
                    currentInterval = c;
                } else {
                    if(currentInterval.end < c.end) {
                        currentInterval.end = c.end;
                    }
                }
            }
            mergedIntervals.add(currentInterval);
            return mergedIntervals;
        }
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
