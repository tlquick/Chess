package model;

public class Bishop extends Piece
{
    
    public Bishop(String colour, String location)
    {
        super(colour, location);
        name = "BISHOP";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && isDiagonal(location));
    }

}