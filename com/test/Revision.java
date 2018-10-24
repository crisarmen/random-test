package com.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by carmentano on 13/07/2018.
 */
public class Revision {
    public static void main(String[] args) {
        int i = new Revision().compareVersion("0.11", "1.0");
        int a = 1;
    }


    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = Stream.of(version1.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> v2 = Stream.of(version2.split("\\.")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        int i = 0;
        for(; i < v1.size() && i < v2.size(); i++) {
            if(v1.get(i) > v2.get(i)) {
                return 1;
            } else if (v1.get(i) < v2.get(i)) {
                return -1;
            }
        }

        if(v1.size() == i) {
            for(; i < v2.size(); i++) {
                if(v2.get(i) != 0) {
                    return -1;
                }
            }
        } else {
            for(; i < v1.size(); i++) {
                if(v1.get(i) != 0) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
