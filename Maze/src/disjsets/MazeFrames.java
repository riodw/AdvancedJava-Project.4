package disjsets;
/**
 * 10/6/2015
 * @author rdw77236
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MazeFrames extends JComponent
{ 
    //private char [][] map;
    public int height;
    public int width;
    public int var; // determines the scale of the maze
    Map map = new Map();
    
    /**
    * CONSTRUCTOR - initializes our GraphicsMazeBuilder 
    * @param height: The height of the maze
    * @param width: The width of the maze
    * @param var
    * @param lines
    */
    public MazeFrames(int height, int width, int var, String[] lines)
    {
        this.var = var;
        this.height = height * var;
        this.width = width * var;
        //System.out.println("width" + lines[0].length());
        //              map(     width,          height  )
        Map map1 = new Map(lines.length, lines[0].length());

        for(int i=0; i < lines.length; i++)
            for(int j=0; j < lines[i].length(); j++)
                map1.add(lines[i].charAt(j));

        this.map = map1;
        //System.out.println("\nmap1:\n" + map1);
        //System.out.println("map1.getData: " + map1.getData(0, 0));
    }
    
    // Draws our maze to our java graphics panel
    @Override
    public void paint(Graphics g)
    {
        int starter = 1; // determines the starting location for your maze
        int square = var * var - var;
        
        g.drawLine(starter, starter, starter + width * var + var, starter);
        g.drawLine(starter, starter, starter, starter + height * var + var);
        g.drawLine(starter, starter + height * var + var, starter + width*var
                + var, starter + height*var + var);
        g.drawLine(starter + width*var + var, starter, starter + width*var
                + var, starter + height * var + var);
        //g.fillRect (starter, starter, var, var);
        
        for(int i=0; i <= map.getHeight() -1; i++)
        {
            for(int j=0; j <= map.getWidth() -1; j++)
            {
                int yi = i * (var*var) + starter +var;
                int xi = j * (var*var) + starter +var;
                //System.out.println("THIS: " + map);
                switch( map.getData(i, j))
                {
                    case '1':
                        g.setColor(Color.blue);
                        g.fillRect(xi, yi, square, square);
                        //g.fillRect (i, j, var, var);
                        break;
                    case '0':
                        g.setColor(Color.white);
                        g.fillRect(xi, yi, square, square);
                        //g.fillRect (i, j, var, var);
                        break;
                    case 'b':
                        g.setColor(Color.green);
                        g.fillRect(xi, yi, square, square);
                        //g.fillRect (i, j, var, var);
                        break;
                    case 'e':
                        g.setColor(Color.red);
                        g.fillRect(xi, yi, square, square);
                        //g.fillRect (i, j, var, var);
                        break;
                    case 'p':
                        g.setColor(Color.black);
                        g.fillRect(xi, yi, square, square);
                        //g.fillRect (i, j, var, var);
                        break;
                    default:
                        g.setColor(Color.white);
                        g.fillRect(xi, yi, square, square);
                }
            }  
        }
    }
}