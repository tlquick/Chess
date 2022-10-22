import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FinishWindow extends JFrame
{
    private Game game;
    public FinishWindow(Game game)
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
        //setLayout(new GridLayout(1, 2));
    } 
    private void build()
    {   
        add(new FinishPanel());
    }
    private class FinishPanel extends JPanel implements MyObserver
    {
        private JTextArea message = new JTextArea();
        public FinishPanel()
        {
            setup();
            build();
            setVisible(true);
        }
        private void setup()
        {
            message.setFont(new Font("Courier New", Font.TRUETYPE_FONT, 40));
            message.setText(game.gameOver());
        }
        private void build()
        {
            add(message);
        }
        public void update()
        {
        }
    }
    
}
