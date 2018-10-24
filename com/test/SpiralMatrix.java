package com.test;

/**

 Input: 3
 Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */
public class SpiralMatrix {
    public static void main(String[] argd) {
        int[][] ints = new SpiralMatrix().generateMatrix(4);
        int a = 1;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int initCol = 0;
        int initRow = 0;
        int endCol = n-1;
        int endRow = n-1;

        for(int i = 1; i <= n*n;) {
            for(int j = initCol; j <= endCol; j++) {
                res[initRow][j] = i;
                i++;
            }

            for(int j = initRow+1; j < endRow; j++) {
                res[j][endCol] = i;
                i++;
            }

            for(int j = endCol; j > initCol; j--) {
                res[endRow][j] = i;
                i++;
            }

            for(int j = endRow; j > initRow; j--) {
                res[j][initCol] = i;
                i++;
            }

            initCol++;
            initRow++;
            endCol--;
            endRow--;
        }

        return res;
    }
}
