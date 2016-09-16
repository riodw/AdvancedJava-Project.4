package disjsets;
/**
 * 10/6/2015
 * @author rdw77236
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MazeFrameSolved extends JComponent
{ 
    //private char [][] map;
    public int height;
    public int width;
    public int var; // determines the scale of the maze
    public int starterX;
    public int starterY;
    Map map = new Map();
    
    /**
    * This method initializes our GraphicsMazeBuilder 
    * @param height: The height of the maze
    * @param width: The width of the maze
    * @param var
    * @param maze
    * @param mazeNumber
    * @param starterY
    */
    public MazeFrameSolved(int height, int width, int var, 
            char[][] maze, int mazeNumber, int starterY)
    {
        this.starterX = 1;
        this.starterY = 1;
        this.var = var;
        this.height = height * var;
        this.width = width * var;
        mazeNumber++;
        //System.out.println("width" + lines[0].length());
        //              map(     width,          height  )
        Map map1 = new Map(height, width);

        for(int i=0; i < height; i++)
            for(int j=0; j < width; j++)
                map1.add(maze[i][j]);

        this.map = map1;
        //System.out.println("\nmap-MazeFrameSolved:\n" + map1);
    }
    
    // Draws our maze to our java graphics panel
    @Override
    public void paint(Graphics g)
    {
        // determines the starting location for your maze
        // int starter = 50 * mazeNumber;
        int square = var * var - var;
        g.drawLine(starterX, starterY, starterX + width * var + var, starterY);
       g.drawLine(starterX, starterY, starterX, starterY + height * var + var);
        g.drawLine(starterX, starterY + height * var + var, starterX 
                + width*var + var, starterY + height*var + var);
        g.drawLine(starterX + width*var + var, starterY, starterX 
                + width*var + var, starterY + height * var + var);
        //g.fillRect (starter, starter, var, var);
        
        for(int i=0; i <= map.getHeight() -1; i++)
        {
            for(int j=0; j <= map.getWidth() -1; j++)
            {
                int yi = i * (var*var) + starterY +var;
                int xi = j * (var*var) + starterX +var;
                //System.out.println("THIS: " + map);
                switch( map.getData(i, j))
                {
                    case '1':
                        g.setColor(Color.blue);
                        g.fillRect(xi, yi, square, square);
                        break;
                    case '0':
                        g.setColor(Color.white);
                        g.fillRect(xi, yi, square, square);
                        break;
                    case 'S':
                        g.setColor(Color.green);
                        g.fillRect(xi, yi, square, square);
                        break;
                    case 'e':
                        g.setColor(Color.red);
                        g.fillRect(xi, yi, square, square);
                        break;
                    case 'p':
                        g.setColor(Color.black);
                        g.fillRect(xi, yi, square, square);
                        break;
                    default:
                        g.setColor(Color.white);
                        g.fillRect(xi, yi, square, square);
                }
            }  
        }
    }
}