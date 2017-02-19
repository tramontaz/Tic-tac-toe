import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vadim on 19.02.2017.
 */
public class StartNewGameWindow extends JFrame {
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 230;
    private final String WINDOW_TITLE = "Settings";
    private final int MIN_WIN_LEN = 3;
    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;
    private final String STR_WIN_LEN = "Winning length is: ";
    private final String STR_FIELD_SIZE = "Field size is: ";


    GameWindow gameWindow;
    JRadioButton rbHumanVsHuman;
    JRadioButton rbHumanVsAi;
    JSlider sFieldSize;
    JSlider sWinLen;

    StartNewGameWindow(GameWindow gameWindow){
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        this.gameWindow = gameWindow;
        Rectangle gameWindowBounce = gameWindow.getBounds();
        int pos_x = (int)gameWindowBounce.getCenterX() - WINDOW_WIDTH / 2;
        int pos_y = (int)gameWindowBounce.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(pos_x,pos_y);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLayout(new GridLayout(10, 1));
        addGameControlsMode();
        addGameControlsFieldWinLen();
        JButton btn_start_game = new JButton("Start Game");
        add(btn_start_game);
        btn_start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGameOnClick();
            }
        });
    }

    void btnStartGameOnClick(){
        int mode;
        if (rbHumanVsAi.isSelected()){
            mode = Map.MODE_HUMAN_VS_AI;
        }else if (rbHumanVsHuman.isSelected()){
            mode = Map.MODE_HUMAN_VS_HUMAN;
        }else
            throw new RuntimeException("Unexpected mode selected");

        int fieldSize = sFieldSize.getValue();
        int winLen = sWinLen.getValue();

        gameWindow.startNewGame(mode, fieldSize, fieldSize, winLen);
        setVisible(false);

    }

    void addGameControlsFieldWinLen(){
        add(new JLabel("Choose field size"));
        JLabel lbFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(lbFieldSize);
        sFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = sFieldSize.getValue();
                lbFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                sWinLen.setMaximum(currentFieldSize);
            }
        });
        add(sFieldSize);


        add(new JLabel("Choose winning length"));
        JLabel lbWinLen = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(lbWinLen);
        sWinLen = new JSlider(MIN_WIN_LEN, MAX_FIELD_SIZE, MIN_WIN_LEN);
        sWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLen.setText(STR_WIN_LEN + sWinLen.getValue());
            }
        });
        add(sWinLen);

    }

    void addGameControlsMode(){
        new JLabel("Choose gaming mode");
        rbHumanVsAi = new JRadioButton("Human vs. AI", true);
        rbHumanVsHuman = new JRadioButton("Human vs.Human");
        ButtonGroup mode_group = new ButtonGroup();
        mode_group.add(rbHumanVsAi);
        mode_group.add(rbHumanVsHuman);

        add(rbHumanVsAi);
        add(rbHumanVsHuman);
    }
}



