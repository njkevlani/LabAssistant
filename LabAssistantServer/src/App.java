//http://stackoverflow.com/questions/54686/how-to-get-a-list-of-current-open-windows-process-with-java

import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by nilesh on 7/3/17.
 */
public class App  {
    public static void main(String[] args) throws Exception {
        ArrayList clients = new ArrayList();
        ServerSocket ss = new ServerSocket(7878);
        Socket s = null;

        //Create Frame here, pass to serverThread
        JFrame mainFrame = new JFrame("Lab Assistant Sertver");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setUndecorated(true);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setVisible(true);

        while(true){
            s = ss.accept();
            System.out.println("Client joined.");
            ServerThreads st = new ServerThreads(s,clients,mainFrame);
            clients.add(st);
            st.start();
        }
    }
}
