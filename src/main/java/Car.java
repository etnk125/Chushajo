
import java.util.*;

public class Car extends Pair<Integer, Integer> {

    private int dir = 0, opposite = 2;
    private int currentPlayerNumber = 0;
    private boolean alive = true;
    private PlayFrame frame;
    private Game myGame;
    private Utility util = new Utility();
    //  up      = 0
    //  right   = 1
    //  down    = 2
    //  left    = 3

    Car(int i, int j, Game g, PlayFrame pf) {
        super(i, j);
        myGame = g;
        frame = pf;
    }

    int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    int getDirection() {
        return dir;
    }

    void nextPlayer() {
        currentPlayerNumber = util.scopeCal(currentPlayerNumber, 1, myGame.getNumberOfPlayer());
    }

    void nextDir(int n) {// change Dir
        int temp = util.scopeCal(dir, n, 4);
        dir = (temp != opposite) ? temp : util.scopeCal(dir, n + 1, 4);
    }

    synchronized void move() {
        System.out.println("moving");
        myGame.paint();
        if (dir == 0 && second == 0) {//top leftcar
            if (first == 0) {
                dir = 1; //backcar
                frame.RotateCar(dir);
            } else {
                dir = 2; //rightcar
                frame.RotateCar(dir);
                if (first % 2 == 1) {
                    frame.MoveCarUp();
                    first++;
                } else {
                    frame.MoveCarDown();
                    first--;
                }
            }
        } else if (dir == 2 && second == myGame.getSize() - 1) {//down rightcar
            if (first == myGame.getSize() - 1) {
                dir = 3; //frontcar
                frame.RotateCar(dir);
            } else {
                dir = 0; //leftcar
                frame.RotateCar(dir);
                if (first % 2 == 0) {
                    frame.MoveCarUp();
                    first++;
                } else {
                    frame.MoveCarDown();
                    first--;
                }

            }
        } else if (dir == 1 && first == myGame.getSize() - 1) {//right backcar
            if (second == myGame.getSize() - 1) {
                dir = 0; //leftcar
                frame.RotateCar(dir);
            } else {
                dir = 3; //frontcar
                frame.RotateCar(dir);
                if (second % 2 == 0) {
                    frame.MoveCarRight();
                    second++;
                } else {
                    frame.MoveCarLeft();
                    second--;
                }
            }
        } else if (dir == 3 && first == 0) {//left frontcar
            if (second == 0) {
                dir = 2; //rightcar
                frame.RotateCar(dir);
            } else {
                dir = 1;
                frame.RotateCar(dir);
                //second += (second % 2 == 1) ? 1 : -1;
                if (second % 2 == 1) {
                    frame.MoveCarRight();
                    second++;
                } else {
                    frame.MoveCarLeft();
                    second--;
                }
            }
        } else {
            step();
        }
        frame.validate();

        System.out.printf("moved to %d %d\n", first, second);
        opposite = util.scopeCal(dir, 2, 4);
    }

    void step()//make abang walk 1 step
    {
        switch (dir) {
            case 0: {
                --second;
                frame.MoveCarLeft();
                break;
            }
            case 1: {
                ++first;
                frame.MoveCarUp();
                break;
            }
            case 2: {
                ++second;
                frame.MoveCarRight();
                break;
            }
            case 3: {
                --first;
                frame.MoveCarDown();
                break;
            }
        }
    }
}
