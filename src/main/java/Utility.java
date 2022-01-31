
public class Utility {

    int scopeCal(int num, int shift, int max) {
        return (num + shift) % max;
    }
    
    int coorToNum(int i, int j, int g) {
        return i + j * g;
    }
    
    int coorToNum(Pair<Integer,Integer> p, int g) {
        return p.first + p.second * g;
    }
}
