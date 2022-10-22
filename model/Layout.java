package model;

import java.util.*;
public class Layout
{
   
    public static LinkedList<Piece> getBlackPieces()
    {
        String BLACK = "BLACK";
        LinkedList<Piece> pieces = new LinkedList<Piece>();
        pieces.add(new Rook(BLACK, "A8"));
        pieces.add(new Horse(BLACK, "B8"));
        pieces.add(new Bishop(BLACK, "C8"));
        pieces.add(new King(BLACK, "D8"));
        pieces.add(new Queen(BLACK, "E8"));
        pieces.add(new Bishop(BLACK, "F8"));
        pieces.add(new Horse(BLACK, "G8"));
        pieces.add(new Rook(BLACK, "H8"));
        
        pieces.add(new Pawn(BLACK, "A7"));
        pieces.add(new Pawn(BLACK, "B7"));
        pieces.add(new Pawn(BLACK, "C7"));
        pieces.add(new Pawn(BLACK, "D7"));
        pieces.add(new Pawn(BLACK, "E7"));
        pieces.add(new Pawn(BLACK, "F7"));
        pieces.add(new Pawn(BLACK, "G7"));
        pieces.add(new Pawn(BLACK, "H7"));  
        return pieces;
    }
    public static LinkedList<Piece> getWhitePieces()
    {
        String WHITE = "WHITE";
        LinkedList<Piece> pieces = new LinkedList<Piece>();
        pieces.add(new Rook(WHITE, "A1"));
        pieces.add(new Horse(WHITE, "B1"));
        pieces.add(new Bishop(WHITE, "C1"));
        pieces.add(new King(WHITE, "D1"));
        pieces.add(new Queen(WHITE, "E1"));
        pieces.add(new Bishop(WHITE, "F1"));
        pieces.add(new Horse(WHITE, "G1"));
        pieces.add(new Rook(WHITE, "H1"));
        
        pieces.add(new Pawn(WHITE, "A2"));
        pieces.add(new Pawn(WHITE, "B2"));
        pieces.add(new Pawn(WHITE, "C2"));
        pieces.add(new Pawn(WHITE, "D2"));
        pieces.add(new Pawn(WHITE, "E2"));
        pieces.add(new Pawn(WHITE, "F2"));
        pieces.add(new Pawn(WHITE, "G2"));
        pieces.add(new Pawn(WHITE, "H2"));
        return pieces;
    }
}
