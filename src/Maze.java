import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Maze {
    private String[][] maze;
    private int row = 0;
    private int col = 0;

    public Maze(String[][] maze) {
        this.maze = maze;
    }

    public boolean inBounds(int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }
        return true;
    }

    public boolean canMoveTop(int row, int col) {
        //top
        if (inBounds(row - 1, col)) {
            if (maze[row - 1][col].equals(".")) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveRight(int row, int col) {
        //right
        if (inBounds(row, col + 1)) {
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
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canMoveLeft(int row, int col) {
        //left
        if (inBounds(row, col - 1)) {
            if (maze[row][col - 1].equals(".")) {
                return true;
            }
        }
        return false;
    }

    public int[] moveTop(int row, int col) {
        int[] movePoints = new int[2];
        //top
        movePoints[0] = row - 1;
        movePoints[1] = col;
        return movePoints;
    }

    public int[] moveRight(int row, int col) {
        int[] movePoints = new int[2];

        //right
        movePoints[0] = row;
        movePoints[1] = col + 1;

        return movePoints;
    }

    public int[] moveLeft(int row, int col) {
        int[] movePoints = new int[2];
        //left
        movePoints[0] = row;
        movePoints[1] = col - 1;

        return movePoints;
    }

    public int[] moveBottom(int row, int col) {
        int[] movePoints = new int[2];
        //bottom
        movePoints[0] = row + 1;
        movePoints[1] = col;

        return movePoints;
    }

    public boolean containsArray(ArrayList<int[]> list, int[] array) {
        for (int[] element : list) {
            if (Arrays.equals(element, array)) {
                return true;
            }
        }
        return false;
    }

    public void partOne() {

        ArrayList<int[]> visited = new ArrayList<>();
        int row = maze.length;
        int col = maze[0].length;
        int[] arrPoints = new int[2];
        int xPosition = arrPoints[0];
        int yPosition = arrPoints[1];
        while (arrPoints[0] < row - 1 || arrPoints[1] < col - 1) {
            xPosition = arrPoints[0];
            yPosition = arrPoints[1];
            System.out.print("(" + xPosition + "," + yPosition + ")" + "-->");
            // top
            if (canMoveTop(xPosition, yPosition) && !(containsArray(visited, moveTop(xPosition, yPosition)))) {
                arrPoints = moveTop(xPosition, yPosition);
                visited.add(arrPoints);
            }
            //right
            if (canMoveRight(xPosition, yPosition) && !(containsArray(visited, moveRight(xPosition, yPosition)))) {
                arrPoints = moveRight(xPosition, yPosition);
                visited.add(arrPoints);
            }
            // left
            if (canMoveLeft(xPosition, yPosition) && !(containsArray(visited, moveLeft(xPosition, yPosition)))) {
                arrPoints = moveLeft(xPosition, yPosition);
                visited.add(arrPoints);
            }
            //bottom
            if (canMoveBottom(xPosition, yPosition) && !(containsArray(visited, moveBottom(xPosition, yPosition)))) {
                arrPoints = moveBottom(xPosition, yPosition);
                visited.add(arrPoints);
            }
        }
        System.out.println("(" + (row - 1) + "," + (col - 1) + ")");
    }

    public void partTwo() {
        ArrayList<int[]> visited = new ArrayList<>();
        int row = maze.length;
        int col = maze[0].length;
        int[] arrPoints = new int[2];
        arrPoints[0] = 0;
        arrPoints[1] = 0;
        int xPosition = 0;
        int yPosition = 0;
        visited.add(arrPoints);
        // part Two:
        Deque<int[]> availabePoints = new ArrayDeque<int[]>();
        availabePoints.add(arrPoints);

        while (xPosition < row - 1 || yPosition < col - 1) {
            arrPoints = availabePoints.removeFirst();
            xPosition = arrPoints[0];
            yPosition = arrPoints[1];
            System.out.print("(" + xPosition + "," + yPosition + ")" + "-->");
            // top
            if (canMoveTop(xPosition, yPosition) && !(containsArray(visited, moveTop(xPosition, yPosition)))) {
                availabePoints.addFirst(moveTop(xPosition, yPosition));
                visited.addFirst(arrPoints);
            }
            //right
            if (canMoveRight(xPosition, yPosition) && !(containsArray(visited, moveRight(xPosition, yPosition)))) {
                availabePoints.addFirst(moveRight(xPosition, yPosition));
                visited.addFirst(arrPoints);
            }
            // left
            if (canMoveLeft(xPosition, yPosition) && !(containsArray(visited, moveLeft(xPosition, yPosition)))) {
                availabePoints.addFirst(moveLeft(xPosition, yPosition));
                visited.addFirst(arrPoints);
            }
            //bottom
            if (canMoveBottom(xPosition, yPosition) && !(containsArray(visited, moveBottom(xPosition, yPosition)))) {
                availabePoints.addFirst(moveBottom(xPosition, yPosition));
                visited.addFirst(arrPoints);
            }

        }
    }


}
