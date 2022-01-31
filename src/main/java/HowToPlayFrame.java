
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HowToPlayFrame extends JFrame {

    private JLabel contentpane, button;
    private MyImageIcon background1, background2, background3, mybutton, myButtonClicked;
    private int i = 1;

    public HowToPlayFrame() {
        setTitle("How to play this game?");
        setBounds(300, 20, 1000, 720);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setContentPane(contentpane = new JLabel());
        contentpane.setLayout(null);
        AddComponents();
    }

    public void AddComponents() {
        background1 = new MyImageIcon("picture/howto/1.png").resize(1000, 720);
        background2 = new MyImageIcon("picture/howto/2.png").resize(1000, 720);
        background3 = new MyImageIcon("picture/howto/3.png").resize(1000, 720);
        contentpane.setIcon(background1);

        mybutton = new MyImageIcon("picture/howto/next.png").resize(200, 60);
        myButtonClicked = new MyImageIcon("picture/howto/nextclicked.png").resize(200, 60);

        button = new JLabel(mybutton);
        button.setBounds(400, 572, 200, 60);
        contentpane.add(button);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                button.setIcon(myButtonClicked);
            }

            public void mouseExited(MouseEvent e) {
                button.setIcon(mybutton);
            }

            public void mousePressed(MouseEvent e) {
                button.setIcon(myButtonClicked);
                button.setLocation(402, 574);
            }

            public void mouseReleased(MouseEvent e) {
                button.setIcon(mybutton);
                button.setLocation(400, 572);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                button.setIcon(myButtonClicked);
                i++;
                if (i == 2) {
                    contentpane.setIcon(background2);
                } else if (i == 3) {
                    contentpane.setIcon(background3);
                } else {
                    dispose();
                }
                
            }
        });
        repaint();
    }
    
    public void UpdateHowToFrame(){
        i=1;
        contentpane.setIcon(background1);
        setVisible(true); 
    }

}
