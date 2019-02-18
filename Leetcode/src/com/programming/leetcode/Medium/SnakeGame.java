package com.programming.leetcode.Medium;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {

    //Failing for some cases....
    class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    LinkedList<Point> snake;
    int width, height;
    int[][] food;
    int score;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.height = height;
        this.width = width;
        this.score = 0;
        this.snake = new LinkedList<>();
        this.snake.offerFirst(new Point(0,0));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Point crtHead = this.snake.getFirst();
        Point tail = this.snake.pollLast();
        Point newHead = new Point(crtHead.x,crtHead.y);
        switch (direction){
            case "U":
                newHead.x--;
                break;
            case "R":
                newHead.y++;
                break;
            case "L":
                newHead.y--;
                break;
            default:
                newHead.x++;
                break;
        }

        if(newHead.x < 0 || newHead.x >= height || newHead.y <0 || newHead.y>=width || this.snake.contains(newHead)) return -1;

        this.snake.addFirst(newHead);

        if(score < food.length && newHead.x == food[score][0] && newHead.y == food[score][1]){
            this.snake.addLast(tail);
            score++;
        }
        return score;
    }


    Queue<Integer> snake_queue;
    int row, col, w, h;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public void SnakeGameV1(int width, int height, int[][] food) {
        this.food = food;
        this.w = width;
        this.h = height;
        this.row = 0;
        this.col = 0;
        this.snake_queue = new LinkedList<>();
        this.snake_queue.offer(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int moveV1(String direction) {
        switch (direction){
            case "U":
                row--;
                break;
            case "R":
                col++;
                break;
            case "L":
                col--;
                break;
            default:
                row++;
                break;
        }
        int newHead = row * width + col;
        if(snake_queue.peek() != newHead && snake_queue.contains(newHead)){
            return -1;
        }

        if(row >= 0 && row < h && col >= 0 && col < w){
            snake_queue.offer(newHead);
            if(score < food.length && food[score][0] == row && food[score][1] == col){
                score++;
            }else{
                snake_queue.poll();
            }
            return score;
        }

        return -1;
    }






    public static void main(String[] args) {
        SnakeGame obj = new SnakeGame(3,2, new int[][]{{1,2},{0,1}});
        System.out.println(obj.move("R"));
        System.out.println(obj.move("D"));
        System.out.println(obj.move("R"));
        System.out.println(obj.move("U"));
    }
}
