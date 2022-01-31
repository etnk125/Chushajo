
import javax.swing.*;

public class MyNumber {

    JLabel getNumber(int x, int height) {
        MyImageIcon number = new MyImageIcon("picture/number/N" + x + ".png");
        return new JLabel(number.resize(number.getIconWidth() * height / number.getIconHeight(), height));
    }
}
