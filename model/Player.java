package model;

import java.util.*;
public class Player extends Updater
{
    private final int END = 13;
    private String name;
    private Pieces pieces;
    private boolean conceded = false;
    
    public Player(String name, String colour)
    {
        this.name = name;
        pieces = new Pieces(colour);
    }
    public void remove(Piece piece)
    {
        pieces.remove(piece);
        updateViews();
    }
    public void move(Piece piece, String newLocation)
    {
        piece.move(newLocation);   
        updateViews();
    }
    public Piece find(String location)
    {
        return pieces.find(location);
    }
    public LinkedList<Piece> getPieces()
    {
        return pieces.getPieces();
    }
    public boolean hasPiece(String location)
    {
        return (find(location) != null);
    }
    public boolean validMove(String location)
    {
        if(hasPiece(location))
        {
            System.out.println("Piece already at location");
            return false;
        }  
        return true;
    }
    public void concede()
    {
        conceded = true;
        updateViews();
    }
    public boolean finished()
    {
        return (conceded || pieces.size() <= END);
    }
    public void setName(String name)
    {
        this.name = name;
        updateViews();
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return name + " has " + pieces.size() + " pieces:\n" + pieces.toString();
    }
}
