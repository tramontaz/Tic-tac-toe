import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vadim on 19.02.2017.
 */
public class GameWindow extends JFrame {

    private final int WINDOW_WIDHT = 507;
    private final int WINDOW_HEIGHT = 555;
    private final int WINDOW_POS_X = 700;
    private final int WINDOW_POS_Y = 150;
    private final String WINDOW_TITLE = "Tic-tac-toe";

    StartNewGameWindow startNewGameWindow;


    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDHT,WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLocation(WINDOW_POS_X,WINDOW_POS_Y);
        setVisible(true);
        setResizable(false);
        JButton btnNewGame = new JButton("New Game");
        JButton btnExit = new JButton("Exit");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
        startNewGameWindow = new StartNewGameWindow(this);

        JPanel panelForBottoms = new JPanel();
        panelForBottoms.setLayout(new GridLayout(1,2));
        panelForBottoms.add(btnNewGame);
        panelForBottoms.add(btnExit);
        add(panelForBottoms, BorderLayout.SOUTH);







    }

}
