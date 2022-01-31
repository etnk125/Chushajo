
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingDialog extends JDialog {

    private int themebackground = 1, themesong = 1;
    private Container contentpane;
    private MainApplication frame;

    public SettingDialog(MainApplication f) {
        frame = f;
        setTitle("Setting");
        setBounds(450, 300, 600, 200);
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contentpane = getContentPane();
        contentpane.setLayout(new FlowLayout());
        AddComponent();
        setVisible(true);
    }

    private void AddComponent() {
        JPanel setpanel = new JPanel();
        setpanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Setting"));
        JLabel bg = new JLabel("Select Background : ");
        JLabel temp = new JLabel("");
        setpanel.setLayout(new GridLayout(3, 4, 10, 10));
        setpanel.add(bg);

        ButtonGroup bgroup = new ButtonGroup();
        JRadioButton[] radio = new JRadioButton[6];
        radio[0] = new JRadioButton("1. CLASSIC", true);
        radio[1] = new JRadioButton("2. SNOWLAND");
        radio[2] = new JRadioButton("3. CHRISTMAS");
        radio[3] = new JRadioButton("4. OCEAN");
        radio[4] = new JRadioButton("5. FARMER");
        radio[5] = new JRadioButton("6. FOREST");

        for (int i = 0; i < 6; i++) {
            bgroup.add(radio[i]);
            radio[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    JRadioButton temp = (JRadioButton) e.getSource();
                    if (temp.isSelected()) {
                        setThemeBackground(Character.getNumericValue(temp.getText().charAt(0)));
                        frame.setNewBackground(themebackground);
                        //System.out.println(t);
                    }
                }
            });

        }

        setpanel.add(radio[0]);
        setpanel.add(radio[1]);
        setpanel.add(radio[2]);
        setpanel.add(temp);
        setpanel.add(radio[3]);
        setpanel.add(radio[4]);
        setpanel.add(radio[5]);

        setContentPane(setpanel);

        JLabel soundLabel = new JLabel("Select Sound : ");
        setpanel.add(soundLabel);
        String item[] = {"1. CLASSIC SONG", "2. SNOWLAND SONG", "3. CHRISTMAS SONG", "4. OCEAN SONG", "5. FARMER SONG", "6. FOREST SONG"};
        JComboBox combo = new JComboBox(item);
        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                MySoundEffect.clicksound.playOnce();
                setThemeSong(combo.getSelectedIndex() + 1);
                frame.setNewThemesong(themesong);
            }
        });
        setpanel.add(combo);
        validate();
    }

    public void setThemeBackground(int t) {
        themebackground = t;
        System.out.println("ThemeBackground sets" + themebackground);
    }

    public void setThemeSong(int t) {
        themesong = t;
        System.out.println("Themesong sets" + themesong);
    }
}
