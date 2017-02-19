import javax.swing.*;
import java.awt.*;

/**
 * Created by Vadim on 19.02.2017.
 */
public class StartNewGameWindow extends JFrame {
    private final int WINDOW_WIDHT = 350;
    private final int WINDOW_HEIGHT = 230;
    private final String WINDOW_TITLE = "Settings";

    GameWindow gameWindow;

    StartNewGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        Rectangle gameWindowBounce = gameWindow.getBounds();
        int pos_x = (int)gameWindowBounce.getCenterX() - WINDOW_WIDHT / 2;
        int pos_y = (int)gameWindowBounce.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(pos_x,pos_y);
        setSize(WINDOW_WIDHT,WINDOW_HEIGHT);
    }


}
