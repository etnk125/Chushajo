import javax.swing.*;

public class Credit extends JFrame {
    public Credit(){
        setTitle("Credit");
        setBounds(590, 330, 350, 180);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        String data[][] = {{"Natthawee KoengFak", "6213125"}, 
                            {"Phuwit Chantafong", "6213131"}, 
                            {"Nicharee Chalermsuksri", "6213198"}, 
                            {"Norawich Sapagitchanchai", "6213201"}};
        String header[] = {"NAME", "STUDENT ID"}; 
        JTable table = new JTable(data, header);
        table.setBounds(20, 20, 310, 100);
        getContentPane().add(table);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(10, 10, 310, 89);
        getContentPane().add(scrollpane);
        setVisible(true);
    }
}
