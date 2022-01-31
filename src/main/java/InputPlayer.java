
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputPlayer {

    private Container contentpane, contentpane2;
    private String text1 = "Input name for Player1";
    private String text2 = "Input name for Player2";
    private String text3 = "Input name for Player3";

    public InputPlayer() {
        JDialog dialog1 = new JDialog();
        dialog1.setTitle("SetPlayerName");
        dialog1.setBounds(600, 300, 250, 190);
        dialog1.setResizable(false);
        dialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog1.setModal(true);
        contentpane = dialog1.getContentPane();
        contentpane.setLayout(new FlowLayout());
        JLabel input = new JLabel("INPUT PLAYERS NAME (3 players)");
        JLabel p1 = new JLabel("Player1 : ");
        JLabel p2 = new JLabel("Player2 : ");
        JLabel p3 = new JLabel("Player3 : ");
        JTextField player1 = new JTextField(text1);
        JTextField player2 = new JTextField(text2);
        JTextField player3 = new JTextField(text3);
        contentpane.add(input);
        contentpane.add(p1);
        contentpane.add(player1);
        contentpane.add(p2);
        contentpane.add(player2);
        contentpane.add(p3);
        contentpane.add(player3);
        JButton button = new JButton("OK");
        contentpane.add(button);
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                text1 = player1.getText();
                text2 = player2.getText();
                text3 = player3.getText();
                ConfirmPlayerDialog(dialog1);
            }
        });
        dialog1.setVisible(true);
    }

    public void ConfirmPlayerDialog(JDialog dialog1) {
        JDialog dialog2 = new JDialog(dialog1);
        dialog2.setTitle("ConfirmPlayerName");
        dialog2.setBounds(600, 300, 250, 190);
        dialog2.setResizable(false);
        dialog2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog2.setModal(true);
        contentpane2 = dialog2.getContentPane();
        contentpane2.setLayout(new FlowLayout());
        JLabel input = new JLabel("CONFIRM PLAYERS NAME (3 players)");
        JLabel player1confirm = new JLabel("Player1 : " + text1);
        JLabel player2confirm = new JLabel("Player2 : " + text2);
        JLabel player3confirm = new JLabel("Player3 : " + text3);
        JButton button2 = new JButton("CONFIRM");
        button2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                dialog1.dispose();
                dialog2.dispose();
            }
        });
        JButton button3 = new JButton("EDIT");
        button3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                dialog2.dispose();
            }
        });
        contentpane2.add(input);
        contentpane2.add(player1confirm);
        contentpane2.add(player2confirm);
        contentpane2.add(player3confirm);
        contentpane2.add(button3);
        contentpane2.add(button2);
        dialog2.setVisible(true);
    }
}
