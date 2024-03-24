import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Maze {

    public static ArrayList<Point>pointArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n :");
        int n = scanner.nextInt();

        char[][] maze = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.next().charAt(0);
            }
        }

        //print(maze,n);
        Point source_point = find_source(maze,n);
        Point end_point = find_destination(maze,n,source_point);

        if (source_point != null){
            maze[source_point.x][source_point.y] = '1';
            if(traverse(maze, source_point.x, source_point.y, n,end_point)) {
//                System.out.println("SOLVED maze");
            } else {
//                System.out.println("could NOT SOLVE maze");
            }
            Collections.reverse(pointArrayList);
            for (Point value : pointArrayList) {
                System.out.println("(" + value.x + "," + value.y + ")");
            }
            maze[end_point.x][end_point.y] = '3';
            print(maze,n);
        }

    }

    static Point find_destination(char[][] maze, int n, Point point){

        //up
        for (int i = 0; i < n; i++) {

           if ( maze[0][i] == '1' && maze[1][i] == '1'){
               return new Point(0,i);
           }
        }

        //down
        for (int i = 0; i < n; i++) {
            if (maze[9][i] == '1' && maze[8][i] == '1'){
                return new Point(9,i);
            }
        }

        //left
        for (int i = 0; i < n; i++) {
            if ( maze[i][0] == '1' && maze[i][1] == '1'){
                return new Point(i,0);
            }
        }

        //right
        for (int i = 0; i < n; i++) {
            if (maze[i][9] == '1' && maze[i][8] == '1'){
                return new Point(i,9);
            }
        }

        return null;
    }
    static Point find_source(char[][] maze, int n){
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if (maze[x][y] == '2'){
                    return new Point(x,y);
                }
            }
        }
        return null;
    }

    private static void print(char[][] maze, int n) {
//        System.out.println("-----------------------");
        for(int x = 0; x < n; x++) {
//            System.out.print("| ");
            for(int y = 0; y < n; y++) {
                if (maze[x][y] == '*'){
                    maze[x][y] = '1';
                }
                System.out.print(maze[x][y] + " ");
            }
//            System.out.println("|");
            System.out.println();
        }
//        System.out.println("-----------------------");
    }

    public static boolean isValidSpot(char[][] maze, int r, int c , int n) {
        if(r >= 0 && r < n && c >= 0 && c < n) {
            return maze[r][c] == '1';
        }
        return false;
    }

    public static boolean traverse(char[][] maze, int r, int c,int n,Point point) {

        if(isValidSpot(maze, r, c,n)) {
            //it is a valid spot

            if(r == point.x && c == point.y) {
                return true;
            }

            maze[r][c] = '*';

            //up
            boolean returnValue = traverse(maze, r - 1, c,n,point);


            //right
            if(!returnValue) {
                returnValue = traverse(maze, r, c + 1,n,point);
            }

            //down
            if(!returnValue) {
                returnValue = traverse(maze, r + 1, c,n,point);
            }

            //left
            if(!returnValue) {
                returnValue = traverse(maze, r, c - 1,n,point);
            }

            if(returnValue) {
//                System.out.println(r + ", " + c);
                pointArrayList.add(new Point(r,c));
                maze[r][c] = '3';
            }
            return returnValue;
        }

        return false;
    }
}
