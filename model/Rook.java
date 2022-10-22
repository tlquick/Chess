package model;


public class Rook extends Piece
{
    
    public Rook(String colour, String location)
    {
        super(colour, location);
        name = "ROOK";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && (sameRow(location) || sameColumn(location)));
    }
   
}
