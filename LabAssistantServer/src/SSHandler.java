import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by nilesh on 19/3/17.
 */
public class SSHandler extends Thread {
    JFrame frame;
    JPanel panel;
    ObjectInputStream in;
    JLabel label;

    SSHandler(ObjectInputStream iis, JFrame fr) {
        in = iis;
        frame = fr;
        panel = new JPanel();
        frame.add(panel);
        //label = new JLabel("Screen loading...");
        start();
    }

    @Override
    public void run() {
        ImageIcon icon = null;

        while (true) {
            try {icon = (ImageIcon) in.readObject();} catch (Exception e){break;}


            System.out.println("test");
            label = new JLabel(icon);

            panel.removeAll();
            panel.add(label);

//            frame.removeAll();
            //frame.add(panel);
            //frame.revalidate();
            //frame.repaint();
            panel.revalidate();

            System.out.println("test2");
            try{    sleep(1000);}
            catch (Exception e) {
                /*************************************************************************/
                /***do something that make this run method exit when SS Window closed.***/
                /***********************************************************************/
                e.printStackTrace();
                break;
            }

        }
    }
}
