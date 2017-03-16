import javax.swing.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by nilesh on 7/3/17.
 */
public class App {
    public static void main(String[] args) throws Exception {
        //String serverIP = JOptionPane.showInputDialog("Enter Lab Teacher's IP address");
        String serverIP = "127.0.0.1";

        if(!FunctionNJK.checkIP(serverIP)){
            JOptionPane.showMessageDialog(null,"Not a valid IP, Exiting");
            return ;
        }
        System.out.println("Connecting to " + serverIP + ":7878");
        Socket s = new Socket(serverIP,7878);

        //One thread to be made for screen casting remaining
        ClientScreenShotThread t2 = new ClientScreenShotThread(s);

        //Process Thread
        PrintStream out = new PrintStream(s.getOutputStream());
        boolean running = true;
        ClientProcessThread t1 = new ClientProcessThread(out,running);

//problem when server is closed but client is not.
//        while(true){
//            Thread.sleep(4000);
//            System.out.println("checking connection");
//            InputStream temp = s.getInputStream();
//            if(temp == null){
//                System.out.println("bingo");
//                running = false;
//                break;
//            }
//            temp.close();
//        }
        t1.join();
        t2.join();
    }
}
