import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] filedata = getMaze("src/input");
        int row = filedata.length;
        int col = filedata[0].length;
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(filedata[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<int[]> visited = new ArrayList<>();
        Maze m = new Maze(filedata);

        int[] arrPoints = new int[2];
        int[] temp = new int[2];
        arrPoints[0] = 0;
        arrPoints[1] = 0;
        int xPosition = 0;
        int yPosition = 0;
        visited.add(arrPoints);

        while(arrPoints[0] != row - 1 || arrPoints[1] != col - 1){
            xPosition = arrPoints[0];
            yPosition = arrPoints[1];
            System.out.print("(" + xPosition + "," + yPosition + ")" + "-->");
            // top
            if (m.canMoveTop(xPosition, yPosition)){
                System.out.println("Top");
                temp = m.moveTop(xPosition, yPosition);
                if (visited.contains(temp)) {
                    continue;
                }
                else{
                    arrPoints = m.moveTop(xPosition, yPosition);
                    visited.add(arrPoints);
                }
            }
            // left
            if (m.canMoveLeft(xPosition, yPosition)){
                System.out.println("Left");
                temp = m.moveLeft(xPosition, yPosition);
                if (visited.contains(temp)) {
                    System.out.println("True");
                    continue;
                }
                else{
                    arrPoints = m.moveLeft(xPosition, yPosition);
                    visited.add(arrPoints);
                }
            }
            //right
            if (m.canMoveRight(xPosition, yPosition)){
                System.out.println("Right");
                temp = m.moveRight(xPosition, yPosition);
                if (visited.contains(temp)) {
                    continue;
                }
                else{
                    arrPoints = m.moveRight(xPosition, yPosition);
                    visited.add(arrPoints);
                }
            }

            //bottom
            if (m.canMoveBottom(xPosition, yPosition)){
                System.out.println("Bottom");
                temp = m.moveBottom(xPosition, yPosition);
                if (visited.contains(temp)) {
                    continue;
                }
                else{
                    arrPoints = m.moveBottom(xPosition, yPosition);
                    visited.add(arrPoints);
                }
            }


        }
    }


    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

}