import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChessWindow extends JFrame
{
    private Game game;
    public ChessWindow(Game game)
    {
        this.game = game;
        setup();
        build();
        setVisible(true);   
    }
    private void setup()
    {   
        setSize(750, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new GridLayout(1, 2));
    } 
    private void build()
    {   
        add(new BoardPanel(game));
        add(new MovePanel(game));
    }
    
 
}
