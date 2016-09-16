package disjsets;
/**
 * 10/6/2015
 * @author rdw77236
 */
import java.awt.*;
import javax.swing.*;

public class Solver
{
    private static int mazeNumber = 1;
    private int height;
    private int width;
    private int var; // determines the scale of the maze
    private int endRow;
    private int endCol;
    private int startRow;
    private int startCol;
    char [][] maze;
    Map map = new Map();
    JFrame mazeFrame = new JFrame();
    
    public Solver(int var, String[] lines)
    {
        /*NEW MAZE FRAME TO PUT THE MAZE's ON*/
        mazeFrame = new JFrame();
        
        this.var = var;
        this.height = lines.length;
        this.width = lines[0].length();
        maze = new char[height][width];
        
        // MAKING THE MAZE ARRAY
        for(int i=0; i < height; i++)
            for(int j=0; j < width; j++)
                maze[i][j] = (lines[i].charAt(j));
        //.-end making Maze Array
        
        
        // MAKING THE MAP
        Map map1 = new Map(height, width);
        for(int i=0; i < height; i++)
            for(int j=0; j < width; j++)
                map1.add(lines[i].charAt(j));
        this.map = map1;
        //.End makeing MAP
        
    /********** Making the ORIGINAL to the Frame *********/
        MazeFrames original = new MazeFrames(height, width, var, lines);
        mazeFrame.add(original);
    /********** Adding the ORIGINAL to the Frame *********/
        
        // Find the start and Finish of the Map
        startRow = map.findStartRow();
        startCol = map.findStartCol();
        endRow = map.findEndRow();
        endCol = map.findEndCol();
        //.end- finding start/finish
        
        System.out.println(startRow + " : " + startCol);
        //obj = new char [number+1][height+1][width+1];
        
        // SOLVING THE MAZE
        putQueen(startRow, startCol);
        // MAZE SOLVED
       
        System.out.println(number);
        
      //Is NOW DONE AT THE END OF THE PUTQUEEN FUNCTION, AFTER SOLUTION FOUND
    /********** Making the SOLVED to the Frame *********/
//MazeFrameSolved solved=new MazeFrameSolved(height, width, var, maze, 10, 10);
//        mazeFrame.add(solved);
    /********** Adding the SOLVED to the Frame *********/
        
        mazeFrame.setLayout(new GridLayout(7,8));
        mazeFrame.setTitle("Maze " + mazeNumber);
        mazeFrame.setSize(800,800);
        mazeFrame.setBackground(Color.WHITE);
        mazeFrame.setVisible(true);
        
        mazeNumber++;     
    }
    
    
    // Solution Number Counter
    private int number = 1;
    /**
     * @param row start position of the Maze
     * @param col start position of the Maze
     */
    public void putQueen(int row, int col)
    {
        //System.out.println(printMaze());
        maze[row][col] = 'p';
        if(isE(row, col))
        {
            if(row - 1 >= 0 && upAvailable(row,col))
                putQueen(row - 1, col);
            if(row + 1 <= height && downAvailable(row,col))
                putQueen(row + 1, col);
            if(col - 1 >= 0 && leftAvailable(row,col))
                putQueen(row, col - 1);
            if(col + 1 <= width && rightAvailable(row,col))
                putQueen(row, col + 1);
        }
        else
        {
            maze[startRow][startCol] = 'S';
            System.out.printf("\n****\nsolution number: " + (number++));
            System.out.println(printMaze());
            if(number > 100) var = 2;
            //ADDING THE NEW PATH TO THE FRAME
            mazeFrame.add(new MazeFrameSolved(height, width, var, maze, 1, 1));
        }
        maze[row][col] = '0';
    }//.-end PutQueen
    
    /**
     * upAvailable
     * @param row current row
     * @param col current col
     * @return true if UP is avaliable or false if not
     */
    public boolean upAvailable(int row, int col)
    {
        if(row - 1 < 0) return false;
        if(maze[row - 1][col]  == '1' || maze[row - 1][col]  == 'p')
        {
            //System.out.println("up NOT Available: row: " + row + " col: " + 
            //col + " Data=" + maze[row-1][col]);
            return false;
        }
        //System.out.println("up IS Available: row: " + row + " col: " + col +
        //"Data=" + maze[row -1][col]);
        return true;
    }//.-end upAvailable
    
    /**
     * downAvailable
     * @param row current row
     * @param col current col
     * @return true if DOWN is avaliable or false if not
     */
    public boolean downAvailable(int row, int col)
    {
        if(row + 1 > height-1) return false;
        if(maze[row + 1][col]  == '1' || maze[row + 1][col]  == 'p')
        {
            //System.out.println("down NOT Available: row: " + row + " col: " +
            //col + " Data=" + maze[row+1][col]);
            return false;
        }
        //System.out.println("down IS Available: row: " + row + " col: " + col+
        //" Data=" + maze[row+1][col]);
        return true;
    }//.-end downAvailable

    /**
     * leftAvailable
     * @param row current row
     * @param col current col
     * @return true if LEFT is avaliable or false if not
     */
    public boolean leftAvailable(int row, int col)
    {
        if(col - 1 < 0) return false;
        if(maze[row][col - 1]  == '1' || maze[row][col - 1]  == 'p')
        {
            //System.out.println("left NOT Available: row: " + row + " col: " +
            //col + " Data=" + maze[row][col-1]);
            return false;
        }
        //System.out.println("left IS Available: row: " + row + " col: " + col+
        //" Data=" + maze[row][col-1]);
        return true;
    }//.-end leftAvailable
    
    /**
     * rightAvailable
     * @param row current row
     * @param col current col
     * @return true if RIGHT is avaliable or false if not
     */
    public boolean rightAvailable(int row, int col)
    {
        if(col + 1 > width-1) return false;
        if(maze[row][col + 1]  == '1' || maze[row][col + 1]  == 'p')
        {
            //System.out.println("right NOT Available: row: " + row + " col: "+
            //col + " Data=" + maze[row][col+1]);
            return false;
        }
        //System.out.println("right IS Available: row: " + row + " col: " + col
        //+ " Data=" + maze[row][col+1]);
        return true;
    }//.-end rightAvailable
    
    /**
     * isE - checks if the next spot in any direction is the end of the maze
     * @param row
     * @param col
     * @return true if E is NOT close else return true
     */
    public boolean isE(int row, int col)
    {
        if(col + 1 > width-1) return true;
        if(row + 1 > height-1) return true;
        if(col - 1 < 0) return true;
        if(row - 1 < 0) return true;
        
        if(maze[row][col + 1]  == 'e')
            return false;
        if(maze[row][col - 1]  == 'e')
            return false;
        if(maze[row - 1][col]  == 'e')
            return false;
        if(maze[row + 1][col]  == 'e')
            return false;

        return true;
    }
    
    /**
     * printMaze - turns the maze into a string
     * @return the entire maze as one string
     */
    public String printMaze()
    {
        String s = "\n";
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                s += maze[i][j] + "  ";
            s += "\n";
        }
        return s;
    }
}
// Maze 1 - 
/*
11111
b0101
1010e
00001
11111
*/
// Maze 2 - 340
/*
11111111111
10000010001
10100010101
e0100000101
10111110101
10101000101
10001010001
11111010001
101b1010001
10000010001
11111111111
*/