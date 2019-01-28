package com.programming.leetcode.Easy;
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

public class ConstructQuadTree {

    public Node construct(int[][] grid) {
        return buildHelper(0,grid.length-1,0,grid[0].length-1,grid);
    }

    Node buildHelper(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid){
        if(rowStart > rowEnd || colStart > colEnd ) return null;
        boolean isLeaf = true;
        int val = grid[rowStart][colStart];
        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd ; j ++){
                if(grid[i][j] != val){
                    isLeaf = false;
                    break;
                }
            }
        }
        if(isLeaf) return  new Node(val == 1, isLeaf, null,null,null,null );
        else{
            int rowMid = (rowStart + rowEnd)/2;
            int colMid = (colStart + colEnd)/2;
            Node topLeft = buildHelper(rowStart, rowMid,colStart,colMid,grid);
            Node topRight = buildHelper(rowStart, rowMid, colMid+1, colEnd,grid);
            Node bottomLeft = buildHelper(rowMid+1, rowEnd,colStart,colMid,grid);
            Node bottomRight = buildHelper(rowMid+1, rowEnd, colMid+1, colEnd,grid);
            return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
        }

    }


}
