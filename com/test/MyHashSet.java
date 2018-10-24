package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyHashSet {
    private static final int NB = 1000;
    private List<List<Integer>> buckets = new ArrayList<>(Collections.nCopies(NB, null));

    public MyHashSet() {

    }

    public void add(int key) {
        int b = getBucket(key);
        List<Integer> l = buckets.get(b);
        if(l == null) {
            l = new ArrayList<>();
            buckets.set(b, l);
        }

        if(!l.contains(key)) {
            l.add(key);
        }
    }

    public void remove(int key) {
        int b = getBucket(key);
        List<Integer> l = buckets.get(b);
        if(l != null && l.contains(key)) {
            l.remove(l.indexOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int b = getBucket(key);
        List<Integer> l = buckets.get(b);
        return (l!=null && l.contains(key));
    }

    private int getBucket(int key) {
        return Integer.hashCode(key) % NB;
    }
}
