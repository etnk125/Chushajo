
import java.util.*;
import javax.swing.*;

public class DiceDialog {

    // working variables 
    private int dialogWidth = 300;
    private int dialogHeight = 300;
    private int diceWidth = 300;
    private int diceHeight = 3000;

    // components
    private JFrame dialog = new JFrame();
    private JLabel contentpane;
    private MyImageIcon backgroundImg;
    private ArrayList<String> gungging = new ArrayList<>();
    private ArrayList<ArrayList<String>> dice = new ArrayList<>();

    DiceDialog(int m) {
        dialog.setTitle("Rolling the Dice");
        dialog.setBounds(10, 20, dialogWidth, dialogHeight);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setContentPane(contentpane = new JLabel());
        addDice();
        randomDice(m);
    }

    public void addDice() {
        for (int i = 1; i <= 4; i++) {
            gungging.add("picture/dice/11/D" + i + ".jpg");
        }
        for (int i = 0; i <= 8; i++) {
            dice.add(new ArrayList<String>());
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                dice.get(i + j).add("picture/dice/" + Integer.toString(i) + j + "/D5.jpg");
            }
        }
    }

    public void randomDice(int m) {
        Thread diceThread = new Thread() {
            public void run() {
                gungging.forEach(e -> {
                    backgroundImg = new MyImageIcon(e).resize(dialogWidth, dialogHeight);
                    contentpane.setIcon(backgroundImg);
                    contentpane.setLayout(null);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                });
                backgroundImg = new MyImageIcon(dice.get(m).get(new Random().nextInt(dice.get(m).size()))).resize(dialogWidth, dialogHeight);
                contentpane.setIcon(backgroundImg);
                contentpane.setLayout(null);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                dialog.dispose();
            }  
        };
        diceThread.start();
    }
}
