package model;

import java.util.*;
public class Pieces
{
    private LinkedList<Piece> pieces = new LinkedList<Piece>();
    private final String WHITE = "WHITE";
    private final String BLACK = "BLACK";
    public Pieces()
    {
    }
    public Pieces(String colour)
    {
        setup(colour);
    }
    private void setup(String colour)
    {
        if(colour.equals(BLACK))
        {
            pieces = Layout.getBlackPieces();
        }
        else
        {
            pieces = Layout.getWhitePieces();
        }
    }
    public Piece find(String location)
    {
        for (Piece piece : pieces)
        {
            if(piece.getLocation().equals(location))
                return piece;
        }
        return null;
    }
    public void remove(Piece piece)
    {
        pieces.remove(piece);
    }
    public void addAll(LinkedList<Piece> list)
    {
        pieces.addAll(list); 
    }
    public String printRows()
    {
        String str = "   ABCDEFGH\n  __________\n";
        boolean found = false;
        for(int i = 8; i >= 1; i--)
        {
            str += i + "| ";
            for(char ch = 'A'; ch <= 'H'; ch++)
            {
                found = false;
                for (Piece piece : pieces)
                {
                    if (piece.getLocation().equals(""+ch+i))
                    {
                        str += piece.print();
                        found = true;
                    }
                }
                if(!found)
                    str += " ";
            }
            str +=" |" + i + "\n";
        }
        str += "  __________\n   ABCDEFGH";
        return str;
    }
    public LinkedList<Piece> getPieces()
    {
        return pieces;
    }
    public int size()
    {
        return pieces.size();
    }
    public String toString()
    {
        String str = "";
        for (Piece piece : pieces)
            str += piece.toString() + ", ";
        return str;
    }
}
