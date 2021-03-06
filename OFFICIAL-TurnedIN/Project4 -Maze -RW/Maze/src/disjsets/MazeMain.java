package disjsets;
/**
 * 10/6/2015
 * Rio Weber
 */
import javax.swing.*;
public class MazeMain extends JFrame
{
    /* FOR USE OF ONLY NUMBERS IN EARLIER VERSION*/
//    private static char [][] map = {
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'2','1','1','1','0','0','0','0','0','0',},
//                 {'0','0','0','1','0','0','0','1','1','2',},
//                 {'0','0','0','1','0','0','0','1','0','0',},
//                 {'0','0','0','1','0','0','0','1','0','0',},
//                 {'0','0','0','1','1','1','1','1','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',},
//                 {'0','0','0','0','0','0','0','0','0','0',}, };
    /* FOR USE OF STRINGS IN EARLIER VERSION
    private static char [][] map = {
                 {'0','0','0','0','0','0','0','0','0','0',},
                 {"0","0","0","0","0","0","0","0","0","0",},
                 {"2","1","1","1","0","0","0","0","0","0",},
                 {"0","0","0","1","0","0","0","1","1","2",},
                 {"0","0","0","1","0","0","0","1","0","0",},
                 {"0","0","0","1","0","0","0","1","0","0",},
                 {"0","0","0","1","1","1","1","1","0","0",},
                 {"0","0","0","0","0","0","0","0","0","0",},
                 {"0","0","0","0","0","0","0","0","0","0",},
                 {"0","0","0","0","0","0","0","0","0","0",},
                 {"0","0","0","0","0","0","0","0","0","0",},
                 {"0","0","0","0","0","0","0","0","0","0",},
               };*/
    public static void main (String[] args)
    {
        TextFrame tt = new TextFrame();
        
        JFrame frame = new JFrame("Enter your maze");
        frame.setSize(350, 470);
        frame.setLocationRelativeTo(null);
        //Add contents to the window.
        frame.add(tt);
        //Display the window
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Over 800 lines of code
}