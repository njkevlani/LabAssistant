import javax.swing.*;
import java.awt.*;

/**
 * Created by nilesh on 8/3/17.
 */
public class processPanel extends JPanel {
    JLabel label;
    JButton btn;
    JTable table;
    JScrollPane sp;

    processPanel(String ip,String[] head, String[][] data){
        //this.setSize(new Dimension(40,170));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        createProcessPanel(ip,head,data);
    }
    public void createProcessPanel(String ip,String[] head, String[][] data){
        this.removeAll();
        label = new JLabel(ip);
        btn = new JButton("ScreenCast");    //ActionListener remaining
        table = new JTable(data, head);
        sp = new JScrollPane(table);
        this.add(label);
        this.add(btn);
        this.add(sp);
    }
}
