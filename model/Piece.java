package model;


public class Piece 
{
    protected final String WHITE = "WHITE";
    protected final String BLACK = "BLACK";
    protected final int ROW_START = 1;
    protected final int ROW_END = 8;
    protected final char COLUMN_START = 'A';
    protected final char COLUMN_END = 'H';
    protected final String END = "XX";
    protected String name;
    protected String colour;
    protected String location;
    public Piece(String colour, String location)
    {
        this.colour = colour;
        this.location = location;
    }
    public boolean isValid(String location)
    {
        if(location.equalsIgnoreCase(END) || onBoard(location)) //escape if there are no valid moves
            return true; 
        return false;
    }
    public void move(String location)
    {
        this.location = location;
        System.out.println(name + " has moved to " + location);
    }
    public int getRow(String location)
    {
        return Integer.parseInt(""+location.charAt(1));
    }
    public char getColumn(String location)
    {
        return location.charAt(0);
    }
    private boolean onBoard(String location)
    {
        return validRow(location) && validColumn(location);
    }
    private boolean validRow(String location)
    {
        return (getRow(location) <= ROW_END && getRow(location) >= ROW_START);
    }
    private boolean validColumn(String location)
    {
        return (getColumn(location) <= COLUMN_END && getColumn(location) >= COLUMN_START);
    }
    protected boolean sameRow(String location)
    {
        return getRow(this.location) == getRow(location);
    }
    protected boolean isDiagonal(String location)
    {
       return (Math.abs(getRow(location) - getRow(this.location))) == (Math.abs(getColumn(location) - getColumn(this.location)));
    }
    protected boolean sameColumn(String location)
    {
        return getColumn(this.location) == getColumn(location);
    }
    protected boolean rowStep(int number, String location)
    {
        return (Math.abs(getRow(location) - getRow(this.location))== number);
    }
    protected boolean columnStep(int number, String location)
    {
        return (Math.abs(getColumn(location) - getColumn(this.location))== number);
    }
    public String getLocation()
    {
        return location;
    }
    public char print()
    {
        char ch;
        if(colour.equals(BLACK))
            ch = name.toLowerCase().charAt(0);
        else
            ch = name.charAt(0);
        return ch;
    }
    public String toString()
    {
        return name + " at " + location;
    }
}
