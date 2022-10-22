package model;

public class Queen extends Piece
{
    
    public Queen(String colour, String location)
    {
        super(colour, location);
        name = "QUEEN";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && (isDiagonal(location)|| (sameRow(location) || sameColumn(location))));
    }
   
}