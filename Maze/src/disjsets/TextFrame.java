package disjsets;
/**
 * 10/6/2015
 * @author rdw77236
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFrame extends JPanel implements ActionListener
{
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
//                 {'0','0','0','0','0','0','0','0','0','0',},
//               };
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
    private static int mazeNumber = 1;
    private int var = 4; // determines the scale of the maze

    public TextFrame()
    {
        super(new GridBagLayout());

        textField = new JTextField(30);
        textField.addActionListener(this);

        textArea = new JTextArea(20, 20);
        textArea.setEditable(true);
        textArea.setText(
            "11111111111\n" +
            "10000010001\n" +
            "10100010101\n" +
            "e0100000101\n" +
            "10111110101\n" +
            "10101000101\n" +
            "10001010001\n" +
            "11111010001\n" +
            "101b1010001\n" +
            "10000010001\n" +
            "11111111111");
       
        textArea.setText(
            "b1111\n" +
            "000e1\n" +
            "10001\n" +
            "10001\n" +
            "11111");
                
        JScrollPane scrollPane = new JScrollPane(textArea);
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        JButton button = new JButton("Show Maze");
        button.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(textArea.getText().equals("") ||
                        textArea.getText().contains("q"))
                {
                    textArea.setText(
            "\n    \tYou Must Enter Valid Input\n"
            + "          Hit the Clear button to dismiss this message");
                }
                else // start of making the mazes and solve them
                {
                    String[] lines = textArea.getText().split("\\n");
                    
                    int height = lines.length;
                    int width  = lines[0].length();

                    if     ( width  > 9 || height  > 9) var = 1;
                    else if(width  == 8 || height == 8) var = 2;
                    else if(width  == 7 || height == 7) var = 3;
                    else if(width  == 6 || height == 6) var = 4;
                    else if( width  < 5 || height  < 5) var = 5;
                    
                    Solver jj = new Solver(var, lines);
                    //System.out.println(mapText);
                    //System.out.println(textArea);
                }
            }
        });
        add(button, c); 

        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textArea.setText("");
            }
        });
        add(buttonClear, c);
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
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