import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BoardPanel extends JPanel implements MyObserver
{
    private Game game;
    private NamePanel player1;
    private NamePanel player2;
    private JTextArea board = new JTextArea("");
    public BoardPanel(Game game)
    {   
        this.game = game;
        game.attach(this);
        game.player1().attach(this);
        game.player2().attach(this);
        setup();
        build();
        setVisible(true);
    }
    private void setup()
    {
        setBorder(BorderFactory.createLineBorder(Color.blue));
        player1 = new NamePanel(game.player1(), 1);
        player2 = new NamePanel(game.player2(), 2);
        board.setFont(new Font("Courier New", Font.TRUETYPE_FONT, 40));
        board.setRows(10);
        update();
    }
    private void build()
    {
        add(player2);
        add(board);
        add(player1);

    }
    public void update()
    {
        board.setText(game.showBoard());
    }
 
    private class NamePanel extends JPanel implements MyObserver
    {
        private Player player;
        private JLabel playerLabel = new JLabel("");
        private JTextField name = new JTextField(10);
        private JButton changePlayer = new JButton("Change Name");
        private JLabel playerConfirm = new JLabel("     ");
        public NamePanel(Player player, int number)
        {
            this.player = player;
            player.attach(this);
            setup(number);
            build();
            setVisible(true);
        }
        private void setup(int number)
        {
            playerLabel.setText("Player " + number);
            name.setText(player.getName());
            changePlayer.addActionListener(new PlayerListener());
            setLayout(new BorderLayout());
        }
        private void build()
        {
            add(playerLabel, BorderLayout.NORTH);
            add(name, BorderLayout.WEST);
            add(changePlayer);
            add(playerConfirm, BorderLayout.SOUTH);
        }
        public void update()
        {
            name.setText(player.getName());
        }
        private class PlayerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                player.setName(name.getText());
                playerConfirm.setForeground(Color.BLUE);
                playerConfirm.setText("Name has Changed");
            }
        }
    }
}