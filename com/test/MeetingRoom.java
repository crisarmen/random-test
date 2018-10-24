package com.test;

import java.util.*;

/**
 * Created by carmentano on 01/08/2018.
 */
public class MeetingRoom {
    public static void main(String[] args) {
        Interval i1 = new Interval(10, 20);
        Interval i2 = new Interval(13, 24);
        Interval i3 = new Interval(19, 30);
        Interval i4 = new Interval(25, 36);
        Interval[] i = {i1,i2,i3,i4};
        int dd = new MeetingRoom().int2(i);
        int a = 1;

    }
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        int numRooms = 0;
        PriorityQueue<Interval> q = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        q.add(intervals[0]);
        numRooms = 1;

        for(int i = 1; i < intervals.length; i++){
            Interval currentInteval = intervals[i];
            while(!q.isEmpty() && q.peek().end <= currentInteval.start) {
                q.poll();
            }
            q.add(currentInteval);

            if(numRooms < q.size()) {
                numRooms = q.size();
            }
        }

        return numRooms;
    }

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

  private int int2(Interval[] intervals) {
      Map<Integer, Integer> m = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            m.put(intervals[i].start, m.getOrDefault(intervals[i].start, 0) + 1);
            m.put(intervals[i].end, m.getOrDefault(intervals[i].end, 0) - 1);
        }
      int cnt = 0, maxCnt = 0;
        for(Map.Entry<Integer, Integer> ent : m.entrySet()) {
            cnt += ent.getValue();
            maxCnt = Math.max(cnt, maxCnt);
        }
        return 0;
    }
}
