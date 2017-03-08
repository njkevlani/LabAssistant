//http://stackoverflow.com/questions/54686/how-to-get-a-list-of-current-open-windows-process-with-java

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
        while(true){
            s = ss.accept();
            System.out.println("Client joined.");
            ServerThreads st = new ServerThreads(s,clients);
            clients.add(st);
            st.start();
        }
    }
}
