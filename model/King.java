package model;


public class King extends Piece
{
    
    public King(String colour, String location)
    {
        super(colour, location);
        name = "KING";
    }
    public boolean isValid(String location)
    {
        return(super.isValid(location) && ((oneStepSideways(location))||oneStepForwardOrBack(location)));
    }
    private boolean oneStepSideways(String location)
    {
        return sameRow(location) && (Math.abs(getColumn(location) - getColumn(this.location))== 1);
    }
    protected boolean oneStepForwardOrBack(String location)
    {
        return sameColumn(location) && (Math.abs(getRow(location) - getRow(this.location))== 1);
    }
}
