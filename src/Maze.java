import java.util.ArrayList;

public class Maze {
    private String[][] maze;
    private int row = 0;
    private int col = 0;
    private int xPoint = 0;
    private int yPoint = 0;

    public Maze(String[][] maze){
        this.maze = maze;
    }

    public boolean inBounds(int row, int col){
        if(row < 0 || col < 0 || row >= maze.length || col >= maze.length){
            return false;
        }
        return true;
    }

    public boolean canMoveTop(int row, int col) {
        //top
        if(inBounds(row - 1, col)) {
            if (maze[row - 1][col].equals(".")) {
                return true;
            }
        }
        return false;
    }
    public boolean canMoveRight(int row, int col) {
        //right
        if(inBounds(row, col + 1)) {
            if (maze[row][col + 1].equals(".")) {
                return true;
            }
        }
        return false;
    }
    public boolean canMoveBottom(int row, int col) {
        //bottom
        if (inBounds(row + 1, col)) {
            if (maze[row + 1][col].equals(".")) {
                return true;
            }
        }
        return false;
    }
    public boolean canMoveLeft(int row, int col) {
        //left
        if(inBounds(row, col - 1)) {
            if (maze[row][col - 1].equals(".")) {
                return true;
            }
        }
        return false;
    }

    public int[] moveTop(int row, int col){
        int[] movePoints = new int[2];
        //top
        if(inBounds(row - 1, col)) {
            if (maze[row - 1][col].equals(".")) {
                movePoints[0] = row - 1;
                movePoints[1] = col;
            }
        }

        return movePoints;
    }

    public int[] moveRight(int row, int col){
        int[] movePoints = new int[2];

        //right
        if(maze[row][col + 1].equals(".")){
            movePoints[0] = row;
            movePoints[1] = col + 1;
        }

        return movePoints;
    }

    public int[] moveLeft(int row, int col){
        int[] movePoints = new int[2];
        //left
        if(maze[row][col - 1].equals(".")){
            movePoints[0] =  row;
            movePoints[1] = col-1;
        }
        return movePoints;
    }

    public int[] moveBottom(int row, int col){
        int[] movePoints = new int[2];
        //bottom
        if(maze[row + 1][col].equals( ".")){
            movePoints[0] =  row+1;
            movePoints[1] = col;
        }
        return movePoints;
    }

}
