
import java.util.ArrayList;
import javax.swing.*;

public class PlayFrame extends JFrame {

    // working variables 
    private int frameWidth = 1000;
    private int frameHeight = 720;
    private int carWidth = 100;
    private int carHeight = 70;
    private int carX = 430;
    private int carY = 230;
    private int carpetWidth = 109;//107+2
    private int carpetHight = 64; //62+2
    private int carpetX, carpetY;
    private int rollWidth = 180;
    private int rollHeight = 50;
    private boolean carLeft = true, carMove = false;
    private int carSpeed = 100;
    private Game myGame;
    private Car car;
    private MySoundEffect sound;
    private int themeNumber;

    // components
    private JLabel contentpane, playerLabel;
    private JLabel CarImg;
    private ArrayList<MyImageIcon> backgroundImgs = new ArrayList<>();

    private ArrayList<MyImageIcon> playerblockImgs = new ArrayList<>();

    private ArrayList<MyImageIcon> carpets = new ArrayList<>();
    private ArrayList<JLabel> carpetTable = new ArrayList<>();
    private MyImageIcon leftcar = new MyImageIcon("picture/play/leftcar.png").resize(carWidth, carHeight);
    private MyImageIcon backcar = new MyImageIcon("picture/play/backcar.png").resize(carWidth, carHeight);
    private MyImageIcon rightcar = new MyImageIcon("picture/play/rightcar.png").resize(carWidth, carHeight);
    private MyImageIcon frontcar = new MyImageIcon("picture/play/frontcar.png").resize(carWidth, carHeight);
    private MyImageIcon roll = new MyImageIcon("picture/play/roll.png").resize(rollWidth, rollHeight);
    private MyImageIcon rollclicked = new MyImageIcon("picture/play/rollclicked.png").resize(rollWidth, rollHeight);

    PlayFrame(int t) {
        setTitle("Play");
        setBounds(300, 20, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(contentpane = new JLabel());

        setBackgroundImg();
        themeNumber = t - 1;
        contentpane.setIcon(backgroundImgs.get(themeNumber));
        contentpane.setLayout(null);

        for (int i = 1; i <= 3; i++) {
            carpets.add(new MyImageIcon("picture/play/carpet/" + themeNumber + "/" + i + ".png").resize(carpetWidth, carpetHight));
        }
    }

    void setBackgroundImg() {
        for (int i = 0; i < 6; i++) {
            MyImageIcon buf = new MyImageIcon("picture/play/background/background" + i + ".png").resize(frameWidth, frameHeight);
            backgroundImgs.add(buf);
        }
    }

    public void setGame(Game m) {
        myGame = m;
    }

    public void setCar(Car c) {
        car = c;
    }

    public void updateBackground(int c) {
        playerLabel.setIcon(playerblockImgs.get(c));
    }

    public void AddPlayerBlock() {
        for (int i = 1; i <= 3; i++) {
            playerblockImgs.add(new MyImageIcon("picture/play/playerblock/" + themeNumber + "/" + i + ".png").resize(200, 200));
        }
        playerLabel = new JLabel(playerblockImgs.get(0));
        playerLabel.setBounds(40, 450, 200, 200);
        contentpane.add(playerLabel);
        repaint();
    }

    public void setCarpet() {

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 7; i++) {
                carpetX = (103 + (j + i) * 53) + 3;
                carpetY = (233 + (j - i) * 31) + 1;
                JLabel buf = new JLabel();
                buf.setBounds(carpetX, carpetY, carpetWidth, carpetHight);
                carpetTable.add(buf);
                contentpane.add(buf);
            }
        }
    }

    public void setCarpetPlaced(ArrayList<Integer> t) {
        Thread carpetThread = new Thread() {
            public void run() {
                for (int i = 0; i < 49; i++) {
                    if (t.get(i) != -1) {
                        carpetTable.get(i).setIcon(carpets.get(t.get(i)));
                    }
                }
            }
        };
        carpetThread.start();
    }

    public void AddCar() {
        CarImg = new JLabel(leftcar);
        CarImg.setBounds(430, 230, carWidth, carHeight);
        contentpane.add(CarImg);
        repaint();
    }

    public void RotateCar(int d) {
        if (d == 1) {
            CarImg.setIcon(backcar);
        } else if (d == 2) {
            CarImg.setIcon(rightcar);
        } else if (d == 3) {
            CarImg.setIcon(frontcar);
        } else if (d == 0) {
            CarImg.setIcon(leftcar);
        }
    }

    public void MoveCarLeft() {
        carX -= 55;
        carY -= 30;
        CarImg.setLocation(carX, carY);
    }

    public void MoveCarRight() {
        carX += 55;
        carY += 30;
        CarImg.setLocation(carX, carY);
    }

    public void MoveCarUp() {
        carX += 55;
        carY -= 30;
        CarImg.setLocation(carX, carY);
    }

    public void MoveCarDown() {
        carX -= 55;
        carY += 30;
        CarImg.setLocation(carX, carY);
    }

    public void setCarThread(int x) {
        Thread carThread = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                sound.carmovesound.playOnce();
                int move = x;
                while (move > 0) {
                    move--;
                    car.move();
                    repaint();
                    try {
                        Thread.sleep(carSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } // end while
                myGame.play();
                if (myGame.isEnded()) {
                    myGame.end();
                }
            } // end run
        }; // end thread creation
        carThread.start();
    }
}
