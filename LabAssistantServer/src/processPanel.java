import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by nilesh on 8/3/17.
 */
public class processPanel extends JPanel {
    JLabel label;
    JButton btn;
    JTable table;
    JScrollPane sp;
    String clientIP;

    processPanel(String ip,String[] head, String[][] data){
        clientIP = ip;
        //this.setSize(new Dimension(40,170));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        btn = new JButton("ScreenCast");    //ActionListener remaining
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("hello!");
                JFrame frame = new JFrame("ScreeCast from "+ip);
                Dimension d = frame.getToolkit().getScreenSize();
                frame.setSize(300*d.width/d.height,300);
                frame.setLayout(new FlowLayout());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JLabel sslabel = new JLabel("Screen Loading");
                frame.setVisible(true);

                Socket s = null;
                ObjectInputStream in = null;
                ImageIcon icon = null;
                try{
                    s = new Socket(ip,7879);
                    in = new ObjectInputStream(s.getInputStream());
                    //icon = (ImageIcon) in.readObject();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                SSHandler ssh = new SSHandler(in,frame);
//                sslabel.setIcon(icon);
//                frame.add(sslabel);
//                frame.revalidate();



//                try {
//                    Thread.sleep(6000);
//                    icon = (ImageIcon) in.readObject();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println("woke up..");
//                sslabel.setIcon(icon);
//                frame.removeAll();
//                frame.add(label);

            }
        });

        createProcessPanel(ip,head,data);
    }
    public void createProcessPanel(String ip,String[] head, String[][] data){
        this.removeAll();
        label = new JLabel(ip);
        table = new JTable(data, head);
        sp = new JScrollPane(table);
        this.add(label);
        this.add(btn);
        this.add(sp);
    }
}
