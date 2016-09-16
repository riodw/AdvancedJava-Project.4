package disjsets;
/**
 * 10/6/2015
 * @author rdw77236
 */
public class Map
{
    public char[][] board;
    public int rowW;
    public int colH;
    public int width;
    public int height;
    
    /**
     * Default Constructor = makes empty Map
     */
    public Map()
    {
        height = 0;
        width = 0;
        rowW = 0;
        colH = 0;
        board = new char[height][width];
        //System.out.println("map-default: " + width);
    }
    
    /**
     * Explicit Constructor - Makes Map
     * @param h height of the Map
     * @param w weight of the Map
     */
    public Map(int h, int w)
    {
        height = h;
        width = w;
        rowW = 0;
        colH = 0;
        board = new char[height][width];
        //System.out.println("map-2parm: " + width);
    }
    
    public void setData(int row, int col, char d)
    {
        //System.out.println("getData: " + board[col][row]);
        board[col][row] = d;
    }
    
    /**
     * @param row to get Data from
     * @param col to get Data from
     * @return the Data at that Row and Col
     */
    public char getData(int row, int col)
    {
        //System.out.println("getData: " + board[col][row]);
        if(col < 0) col = 0;
        if(row < 0) row = 0;
        return board[row][col];
    }
    
    /**
     * @return the height (Rows) of the Map
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * @return the width (Cols) of the Map
     */
    public int getWidth()
    {
        return width;
    }
    
    public void add(char nextChar)
    {        
        if(colH == width)
        {
            rowW++;
            colH = 1;
        }
        else colH++;
        
        // - For Debugging
        //System.out.println("colH:" + colH);
        //System.out.println("rowW:" + (rowW-1));
        
        board[rowW][colH-1] = nextChar;
        //System.out.println("DATA:" + board[colH][rowW-1] + "\n");
    }
    
    /**
     * @return the Row that 'b' (Start of maze) is in
     */
    public int findStartRow()
    {
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                if(board[i][j] == 'b')
                    return i;
        }
        return 0;
    }
    
    /**
     * @return the Col that 'b' (Start of maze) is in
     */
    public int findStartCol()
    {
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                if(board[i][j] == 'b')
                    return j;
        }
        return 0;
    }
    
    /**
     * @return the Row that 'e' (end of maze) is in
     */
    public int findEndRow()
    {
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                if(board[i][j] == 'e')
                    return i;
        }
        return 0;
    }
    
    /**
     * @return the Col that 'e' (end of maze) is in
     */
    public int findEndCol()
    {
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                if(board[i][j] == 'e')
                    return j;
        }
        return 0;
    }
    
    @Override
    public String toString()
    {
        System.out.println("Map-Height: " + height);
        System.out.println("Map-Width: " + width);
        String s = "";
        for(int i = 0; i < height; i++)
        {
            for(int j=0; j < width; j++)
                s += board[i][j] + "  ";
            s += "\n";
        }
        return s;
    }
}