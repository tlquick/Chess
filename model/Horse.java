package model;

public class Horse extends Piece
{
    
    public Horse(String colour, String location)
    {
        super(colour, location);
        name = "HORSE";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && lShape(location));
    }
    private boolean lShape(String location)
    {
        return (rowStep(2, location) && columnStep(1, location)) ||(rowStep(1, location) && columnStep(2, location));
    }
    
   
}