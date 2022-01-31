
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SummaryFrame extends JFrame {

    private int numberHeight = 60, theme;
    private MyImageIcon background, playagainbuttonImg, playagainbuttonclickedImg;
    private JLabel contentpane, playagainbutton;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<JLabel> numberLabels = new ArrayList<>();
    private MainApplication menu;

    public SummaryFrame(int t, ArrayList<Player> p, MainApplication m) {
        setTitle("Summary");
        setBounds(300, 20, 1000, 720);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(contentpane = new JLabel());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MySoundEffect.endgamesound.stop();
            }
        });
        
        menu = m;
        MySoundEffect.endgamesound.playLoop();
        theme = t - 1;
        background = new MyImageIcon("picture/play/score/" + theme + ".png").resize(1000, 720);
        players = p;
        contentpane.setIcon(background);
        contentpane.setLayout(null);
        sortPlayer();
        addNumber();
        addPlayerBlock();
        addPlayAgainButton();
        repaint();
    }

    void addPlayerBlock() {
        for (int i = 0; i < 3; i++) {
            JLabel buf = new JLabel(new MyImageIcon("picture/play/playerblock/" + theme + "/" + (players.get(i).getNumber() + 1) + ".png").resize(95, 95));
            buf.setBounds(630, 216 + i * 113, 95, 95);
            contentpane.add(buf);
            numberLabels.add(buf);
        }
    }

    void addNumber() {
        for (int i = 0; i < 3; i++) {
            JLabel buf = new MyNumber().getNumber(players.get(i).getPoint(), 50);
            buf.setBounds(530, 237 + i * 113, 50 * buf.getIcon().getIconWidth() / buf.getIcon().getIconHeight(), 50);
            contentpane.add(buf);
            numberLabels.add(buf);
        }
    }

    void sortPlayer() {
        Collections.sort(players);
    }

    void addPlayAgainButton() {
        if (theme == 0) {
            playagainbuttonImg = new MyImageIcon("picture/play/playerblock/playagain.png").resize(85, 130);
            playagainbuttonclickedImg = new MyImageIcon("picture/play/playerblock/playagainclicked.png").resize(85, 130);
        } else {
            playagainbuttonImg = new MyImageIcon("picture/play/playerblock/playagain2.png").resize(85, 130);
            playagainbuttonclickedImg = new MyImageIcon("picture/play/playerblock/playagain2clicked.png").resize(85, 130);
        }
        playagainbutton = new JLabel(playagainbuttonImg);
        playagainbutton.setBounds(800, 500, 85, 130);
        contentpane.add(playagainbutton);
        playagainbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playagainbutton.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                playagainbutton.setIcon(playagainbuttonclickedImg);
            }

            public void mouseExited(MouseEvent e) {
                playagainbutton.setIcon(playagainbuttonImg);
            }

            public void mousePressed(MouseEvent e) {
                playagainbutton.setIcon(playagainbuttonclickedImg);
                playagainbutton.setLocation(802, 502);
            }

            public void mouseReleased(MouseEvent e) {
                playagainbutton.setIcon(playagainbuttonImg);
                playagainbutton.setLocation(800, 500);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                playagainbutton.setIcon(playagainbuttonclickedImg);
                dispose();
                MySoundEffect.endgamesound.stop();
                menu.setVisible(true);
            }
        });
        repaint();
    }
}
