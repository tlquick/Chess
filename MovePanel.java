import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovePanel extends JPanel implements MyObserver
{
    private Game game;
    private PlayerPanel player1;
    private PlayerPanel player2;
    public MovePanel(Game game)
    {
         this.game = game;  
         game.attach(this);
         setup();
         build();
         setVisible(true);  
    }
    private void setup()
    {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new GridLayout(2, 2));
        player1 = new PlayerPanel(game.player1());
        player2 = new PlayerPanel(game.player2());
        player2.setVisible(false);
        
    }
    private void build()
    {
        add(player2);
        add(player1);
        
    }
    public void update()
    {
        
    }
    public void changePlayer(Player player)
    {
        if(player.equals(game.player1()))
        {
            player1.setVisible(false);
            player2.setVisible(true);
        }
        else
        {
            player2.setVisible(false);
            player1.setVisible(true);
        }
    }
    private class PlayerPanel extends JPanel implements MyObserver
    {
        private Player player;
        private JLabel pieceLabel = new JLabel("\t\tPiece to move:");
        private JLabel name = new JLabel("");
        private JTextField piece = new JTextField(5);
        private JLabel locationLabel = new JLabel("\t\tMoves to:");
        private JTextField location = new JTextField(5);
        private JButton go = new JButton("Go");
        private JLabel confirm = new JLabel("\t\t\t");
        public PlayerPanel(Player player)
        {
            this.player = player;
            player.attach(this);
            setup();
            build();
            setVisible(true);
        }
        private void setup()
        {
            setLayout(new GridLayout(5, 2));
            name.setText(player.getName());
            go.addActionListener(new GoListener());
        }
        private void build()
        {
            add(new JLabel("\t\tPlayer: "));
            add(name);
            add(pieceLabel);
            add(piece);
            add(locationLabel);
            add(location);
            add(confirm);
            add(go);
        }
        public void sayError(String message)
        {
            confirm.setForeground(Color.RED);
            confirm.setText(message);
        }
        public boolean conceded()
        {
            return location.getText().equals("XX");
        }
        public void update()
        {
            name.setText(player.getName());
            piece.setText("");
            location.setText("");
            confirm.setText("");
        }
        private class GoListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(game.finished())
                    new FinishWindow(game);
                else
                {
                    String upperPiece = piece.getText().toUpperCase();
                    String upperLocation = location.getText().toUpperCase();
                    Piece currentPiece = player.find(upperPiece);
                    if(currentPiece == null)
                        sayError("Piece not found");
                    else//piece found
                    {
                        if( conceded() || currentPiece.isValid(upperLocation))
                        {
                            if(conceded())
                            {
                                sayError(player.getName() + " concedes");
                                player.concede();
                            }
                            else
                            {
                                if(!player.validMove(upperLocation))
                                {
                                    sayError("Own piece exists here");
                                }
                                else
                                {
                                    if(game.pieceExists(upperLocation))
                                    {
                                        game.takePiece(player, upperLocation);
                                    }
                                    player.move(currentPiece, upperLocation);  
                                    changePlayer(player);
                                }
                            }
                        }
                        else
                            sayError("Not a valid move");
                    }
                }
            }
        }
    }
}