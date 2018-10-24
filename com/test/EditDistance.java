package com.test;

public class EditDistance {

    public static void main(String[] args) {
        int i = new EditDistance().minDistanceDelete("seass", "eatssd");
        int a = 1;
    }

    public int minDistance(String word1, String word2) {
        int d1 = word1.length();
        int d2 = word2.length();

        int[][] sol = new int[d1+1][d2+1];
        for(int i = 0; i <= d1; i++) {
            sol[i][0] = i;
        }
        for(int i = 0; i <= d2; i++) {
            sol[0][i] = i;
        }

        for(int i = 1; i <= d1; i ++) {
            for(int j = 1; j <= d2; j ++) {
                int diagonalRes = word1.charAt(i-1) == word2.charAt(j-1) ? sol[i-1][j-1] : sol[i-1][j-1] + 1;
                sol[i][j] = Math.min(diagonalRes, Math.min(sol[i-1][j] + 1, sol[i][j-1] + 1));
            }
        }

        return sol[d1][d2];
    }

    public int minDistanceDelete(String word1, String word2) {
        int d1 = word1.length();
        int d2 = word2.length();

        int[][] sol = new int[d1+1][d2+1];
        for(int i = 0; i <= d1; i++) {
            sol[i][0] = i;
        }
        for(int i = 0; i <= d2; i++) {
            sol[0][i] = i;
        }

        for(int i = 1; i <= d1; i ++) {
            for(int j = 1; j <= d2; j ++) {
                sol[i][j] = Math.min(sol[i-1][j], sol[i][j-1]) + 1;
                if(word1.charAt(i-1) == word2.charAt(j-1) && sol[i][j] > sol[i-1][j-1]) {
                    sol[i][j] = sol[i-1][j-1];
                }
            }
        }

        return sol[d1][d2];
    }
}
