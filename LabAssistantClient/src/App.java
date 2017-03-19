import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by nilesh on 7/3/17.
 */
public class App {
    public static void main(String[] args) throws Exception {
        String serverIP = JOptionPane.showInputDialog(null,"Server Address","127.0.0.1");

        if(!FunctionNJK.checkIP(serverIP)){
            JOptionPane.showMessageDialog(null,"Not a valid IP, Exiting");
            return ;
        }

        boolean running = true;

        //Process Thread
        ClientProcessThread t1 = new ClientProcessThread(serverIP);

        //One thread to be made for screen casting remaining
        ClientScreenShotThread t2 = new ClientScreenShotThread();


        //Client window.
        JFrame frame = new JFrame("Lab Assistant Client");
        frame.add(new JLabel("Close this window to exit."));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setVisible(true);


        t1.join();
        t2.join();
    }
}
