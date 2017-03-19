import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by nilesh on 19/3/17.
 */
public class SSHandler extends Thread {
    JFrame frame;
    ObjectInputStream in;
    JLabel label;

    SSHandler(ObjectInputStream iis, JFrame fr) {
        in = iis;
        frame = fr;
        //label = new JLabel("Screen loading...");
        start();
    }

    @Override
    public void run() {
        ImageIcon icon = null;

        while (true) {
            try {icon = (ImageIcon) in.readObject();} catch (Exception e){break;}


            System.out.println("test");
            label = new JLabel("Screen loading...");
            label.setIcon(icon);
            //frame.removeAll();
            frame.add(label);
            frame.revalidate();
            //frame.repaint();

            System.out.println("test2");
            try{    sleep(6000);}
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
