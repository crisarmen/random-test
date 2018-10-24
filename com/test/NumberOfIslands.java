package com.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    public static void main (String[] ars) {
        char[][] sd = {{'1','0'}, {'0','1'}};
        new NumberOfIslands().numIslands(sd);
    }
    public int numIslands(char[][] grid) {

        if(grid.length == 0) {
            return 0;
        } else if(grid[0].length == 0) {
            return 0;
        }

        int N = grid.length;
        int M = grid[0].length;
        int tot = 0;
//        while(visit(grid)) {
//            tot++;
//        }
        for(int i = 0; i < N; i++) {
            for(int j =0; j < M; j++) {
                if(grid[i][j] == '1') {
                    tot ++;
                    visit(grid, i,j, N, M);
                }
            }
        }

        return tot;
    }

    private boolean visit(char[][] grid, int r, int c, int N, int M){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(r * M + c);
        while(!q.isEmpty()) {
            Integer neigh = q.remove();
            int ec = neigh % M;
            int er = neigh / M;

            grid[er][ec] = '2';

            if(er > 0 && grid[er - 1][ec] == '1') {
                q.add((er -1) * M + ec);
                grid[er][ec] = '2';
            }
            if(ec > 0 && grid[er][ec - 1] == '1') {
                q.add((er) * M + ec - 1);
                grid[er][ec] = '2';
            }

            if(er < N-1 && grid[er + 1][ec] == '1') {
                q.add((er +1) * M + ec);
                grid[er][ec] = '2';
            }
            if(ec < M-1 && grid[er][ec + 1] == '1') {
                q.add((er) * M + ec + 1);
                grid[er][ec] = '2';
            }
        }
        return true;
    }

    static class Pair {
        int r;
        int c;

        Pair (int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
