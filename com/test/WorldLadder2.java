package com.test;

import java.util.*;

/**
 * Created by carmentano on 30/07/2018.
 */
public class WorldLadder2 {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> ladders = new WorldLadder2().findLadders("hit", "cog", dict);
        boolean b = new WorldLadder2().oneCharDistance("aaa", "aaa");
        int a = 1;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> neig = buildNeigh(beginWord, wordList);

        Set<String> visited = new HashSet<>();

        List<List<String>> result = new ArrayList<>();
        List<String> currSol = new ArrayList<>();

        Queue<String> q = new ArrayDeque<>();

        q.add(beginWord);
        visited.add(beginWord);
        // BSF to find the min path
        Map<String, Integer> distances = new HashMap<>();
        distances.put(beginWord, 0);

        while(!q.isEmpty()) {
            String currNode = q.poll();
            int currDist = distances.get(currNode) + 1;

            //extract all the 1 char neightbours
            for (String neight : neig.get(currNode)) {
                if (!visited.contains(neight)) {
                    distances.put(neight, currDist);
                    visited.add(neight);
                    q.add(neight);
                }
            }
        }


        visited = new HashSet<>();
        currSol = new ArrayList<>();

        visited.add(beginWord);

        dfs(beginWord, endWord, visited, neig, currSol, result, distances);

        return result;
    }

    private void dfs(String currNode, String endNode,
                        Set<String> visited,  Map<String, List<String>> neig ,
                        List<String> currSol, List<List<String>>result, Map<String, Integer> dist){
        currSol.add(currNode);

        if(currNode.equals(endNode)) {
            result.add(new ArrayList<>(currSol));
        } else {
            //extract all the 1 char neightbours
            for (String neight : neig.get(currNode)) {
                if (!visited.contains(neight) && dist.get(currNode) + 1 == dist.get(neight)) {
                    visited.add(neight);
                    dfs(neight, endNode, visited, neig, currSol, result, dist);
                    visited.remove(neight);
                }
            }
        }

        currSol.remove(currNode);
    }

    private Map<String, List<String>> buildNeigh(String begin, List<String> words){
        Map<String, List<String>> m = new HashMap<>();
        List<String> w1 = new ArrayList<>(words);
        w1.add(begin);
        for(String s : w1) {
            List<String> n = new ArrayList<>();
            m.put(s, n);

            for(String s1 : words) {
                if(oneCharDistance(s, s1)) {
                    n.add(s1);
                }
            }
        }
        return m;
    }

    boolean oneCharDistance(String s1, String s2) {
        int dist = 0;
        if(s1.length() != s2.length()) {
            return false;
        } else {
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    if(dist == 0) {
                        dist ++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return dist == 1;
    }
}
