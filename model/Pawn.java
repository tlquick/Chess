package model;

public class Pawn extends Piece
{
    
    public Pawn(String colour, String location)
    {
        super(colour, location);
        name = "PAWN";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && (oneStepForward(location)));
    }
    protected boolean oneStepForward(String location)
    {
        if(colour.equals(BLACK))
        {
            return sameColumn(location) && (getRow(location) == getRow(this.location) - 1);
        }
        else //white pawn
        {
            return sameColumn(location) && (getRow(location) == getRow(this.location) + 1);
        }
    }
    
    
   
}