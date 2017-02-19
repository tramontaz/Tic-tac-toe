import javax.swing.*;
import java.awt.*;

/**
 * Created by Vadim on 19.02.2017.
 */
public class Map extends JFrame{

    static final int MODE_HUMAN_VS_AI = 0;
    static final int MODE_HUMAN_VS_HUMAN = 1;

    Map(){
        setBackground(Color.BLACK);
    }

    void startNewGameWindow(int mode, int fieldSizeX, int fieldSizeY, int winLen){
        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLen);
    }
}
