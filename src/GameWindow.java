import javax.swing.*;

/**
 * Created by Vadim on 19.02.2017.
 */
public class GameWindow extends JFrame {

    private final int WINDOW_WIDHT = 507;
    private final int WINDOW_HEIGHT = 555;
    private final int WINDOW_POS_X = 700;
    private final int WINDOW_POS_Y = 150;
    private final String WINDOW_TITLE = "Tic-tac-toe";

    GameWindow(){
        setSize(WINDOW_WIDHT,WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLocation(WINDOW_POS_X,WINDOW_POS_Y);
        setVisible(true);
    }

}
