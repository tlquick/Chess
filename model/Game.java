package model;

import java.util.*;
public class Game extends Updater
{
    private final int SIZE = 2;
    private final String WHITE = "WHITE";
    private final String BLACK = "BLACK";
    private final String CONCEDE = "XX";
    private Player player1;
    private Player player2;
    public Game()
    {
       player1 = new Player("Player1", WHITE);
       player2 = new Player("Player2", BLACK);
    }

    /** private void play()
    {
        if(!finished())
        {
          turn(player1);
          turn(player2);
        }
        else
        {
            gameOver();
        }        
    }**/
    public boolean finished()
    {
        return (player1.finished() || player2.finished());     
    }
    public void turn(Player currentPlayer, Piece piece, String location)
    {
        currentPlayer.move(piece, location);
    }
    public boolean conceded(String location)
    {
        return(location.equalsIgnoreCase(CONCEDE));
    }
    public boolean pieceExists(String location)
    {
        return player1.hasPiece(location) || player2.hasPiece(location);
    }
    public String takePiece(Player player, String location)
    {
        String str = "";
        if (player.equals(player1))
        {
           str += take(player2, location);
        }
         else
        {
           str += take(player1, location);
        }   
        return str;
    }
    public String take(Player player, String location)
    {
        String str = "";
        Piece existing = player.find(location);
        str += existing.toString() +" is DEAD";
        player.remove(existing);//take opponents piece
        return str;
    }
    public String gameOver()
    {
        String str = "Game Over \n";
        if(player1.finished())
            str += player2.getName() + " wins!";
        else
            str += player1.getName() + " wins!";
        return str;
    }
    public Player player1()
    {
        return player1;
    }
    public Player player2()
    {
        return player2;
    }
    public String showBoard()
    {
        Pieces list = new Pieces();
        list.addAll(player2.getPieces());
        list.addAll(player1.getPieces());
        return list.printRows();
    }
    public String toString()
    {
        return "Mini Chess:\n" + player1.toString() + "\n" + player2.toString(); 
    }
}
