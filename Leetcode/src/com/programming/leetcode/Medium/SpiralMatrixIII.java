package com.programming.leetcode.Medium;

public class SpiralMatrixIII {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {


        int totalPoints = R * C;

        int[][] resultMatrix = new int[totalPoints][2];

        int index = 0;
        int step = 0;

        resultMatrix[index++] = new int[]{r0,c0};

        while(totalPoints > 1){

            step++;
            int moves = step;
            while (moves > 0 && totalPoints > 1){
                c0++;
                if(r0 < R && r0 >= 0 && c0 < C && c0 >= 0) {
                    resultMatrix[index++] = new int[]{r0, c0};
                    totalPoints--;
                }
                moves--;
            }

            moves = step;
            while (moves > 0 && totalPoints > 1){
                r0++;
                if(r0 < R && r0 >= 0 && c0 < C && c0 >= 0 ) {
                    resultMatrix[index++] = new int[]{r0, c0};
                    totalPoints--;
                }
                moves--;
            }

            step++;
            moves = step;
            while (moves > 0 && totalPoints > 1){
                c0--;
                if(r0 < R && r0 >= 0 && c0 < C && c0 >= 0 ) {
                    resultMatrix[index++] = new int[]{r0, c0};
                    totalPoints--;
                }
                moves--;
            }

            moves = step;
            while (moves > 0 && totalPoints > 1){
                r0--;
                if(r0 < R && r0 >= 0 && c0 < C && c0 >= 0 ) {
                    resultMatrix[index++] = new int[]{r0, c0};
                    totalPoints--;
                }
                moves--;
            }
        }

        return resultMatrix;

    }

    private void printMatrix(int[][] matrix){
        for(int i =0 ; i < matrix.length; i++){
            System.out.print("[ ");
            for(int j =0 ;j < matrix[i].length ; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("], ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralMatrixIII obj = new SpiralMatrixIII();
        //obj.printMatrix(obj.spiralMatrixIII(1,  4,  0,  0));
        //obj.printMatrix(obj.spiralMatrixIII(5,  6,  1,  4));
        obj.printMatrix(obj.spiralMatrixIII(3,4,2,3));
    }

}
