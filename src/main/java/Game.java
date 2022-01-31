
import java.awt.event.*;
import java.util.*;

public class Game extends Thread {

    private PlayFrame frame;

    private final int size = 7;
    private int numberOfPlayer, themeBackground, themeSong;
    private MySoundEffect song;
    private Scanner key = new Scanner(System.in);
    private Utility util = new Utility();
    private Car car;
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Integer> table = new ArrayList<>();
    private MainApplication menu;

    Game(int t, int s,MainApplication m) {
        menu=m;
        frame = new PlayFrame(t);
        numberOfPlayer = 3;
        themeBackground = t;
        themeSong = s;
        setup();
    }

    int getSize() {
        return size;
    }

    int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    Player getcurrentPlayer() {
        return currentPlayer;
    }

    void setup() {
        setThemesong();
        song.playLoop();
        car = new Car(3, 3, this, frame);
        frame.setGame(this);
        frame.setCar(car);
        for (int i = 0; i < size * size; i++) {
            table.add(-1);
        }

        for (int i = 0; i < numberOfPlayer; i++) {
            players.add(new Player(i, table));
        }
        frame.AddPlayerBlock(); 

        players.forEach(i -> {
            i.start();
        });
        frame.AddCar();
        frame.setCarpet();
    }

    void dicePhase() //change dir before die
    {
        {
            frame.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (KeyEvent.VK_R == e.getKeyCode()) {
                        new MySoundEffect().carrollsound.playOnce();
                        car.nextDir(1);
                        frame.RotateCar(car.getDirection());
                        System.out.println("dir is" + car.getDirection());
                    }
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                        new MySoundEffect().dicerollsound.playOnce();
                        int m = new Random().nextInt(7) + 2;
                        new DiceDialog(m);
                        frame.setCarThread(m);
                        frame.removeKeyListener(this);
                    }
                }
            });
        }
    }

    boolean isEnded() {
        return 0 == table.stream().filter(e -> (e == -1)).mapToInt(e -> e).summaryStatistics().getCount();

    }

    void end() {
        for (var i : frame.getKeyListeners()) {
            frame.removeKeyListener(i);
        }

        players.forEach(e -> e.run());
        players.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        song.stop();
        new SummaryFrame(themeBackground, players,menu);
        frame.dispose();

    }

    void paint() {
        table.set(util.coorToNum(car, size), currentPlayer.getNumber());
        frame.setCarpetPlaced(table);
        table.forEach(i -> {
            System.out.print(i);
        });
    }

    void play() {
        currentPlayer = players.get(car.getCurrentPlayerNumber());
        System.out.println("turn of " + currentPlayer.getNumber());
        frame.updateBackground(currentPlayer.getNumber());
        dicePhase();
        car.nextPlayer();
    }

    @Override
    public void run() {
        play();
    }

    public void setThemesong() {
        switch (themeSong) {
            case 1:
                song = MySoundEffect.classicsound;
                break;
            case 2:
                song = MySoundEffect.snowsound;
                break;
            case 3:
                song = MySoundEffect.christmassound;
                break;
            case 4:
                song = MySoundEffect.oceansound;
                break;
            case 5:
                song = MySoundEffect.farmersound;
                break;
            case 6:
                song = MySoundEffect.forestsound;
                break;
            default:
                break;
        }
    }
}
