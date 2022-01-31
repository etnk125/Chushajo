
import java.util.ArrayList;

public class Player extends Thread implements Comparable<Player> {

    private int number;
    private int point;
    ArrayList<Integer> table;

    Player(int n, ArrayList<Integer> t) {
        number = n;
        table = t;
        point = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getPoint() {
        return point;
    }

    public void run() {
        point = 0;
        for (var i : table) {
            if (i == number) {
                point++;
            }
        }

        System.out.println(number + " hello " + point);
    }

    public int compareTo(Player o) {
        return point == o.point ? o.number - number : o.point - point;
    }

}
