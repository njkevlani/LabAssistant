import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by nilesh on 7/3/17.
 */


//Process table + btn here
public class ServerThreads extends Thread {
    Socket client;
    ArrayList brothers;
    JFrame mainFrame;
    processPanel panel;

    ServerThreads(Socket s, ArrayList c, JFrame frame){
        client = s;
        brothers = c;
        mainFrame = frame;
    }
    public void run() {
        //sync mainFrame here
        System.out.println("Thread started.");
        InputStream in = null;
        BufferedReader brin = null;
        boolean flag = true;
        //DataOutputStream out = null;
        while(flag){
            try {
                in = client.getInputStream();
                brin = new BufferedReader(new InputStreamReader(in));
                //out = new DataOutputStream(client.getOutputStream());
                String line=null;
                String [][] processes = new String[9][];
                //while((line = brin.readLine()) != null ){
                //header
                String[] head = null;
                if(brin != null)
                    line = brin.readLine();
                if(line != null)
                    head = line.trim().replaceAll(" +"," ").split(" ");
                //System.out.println(head.length);
//                for(String st : head){
//                    System.out.println(st);
//                }
                for(int i=0;i<9 && brin != null;i++){
                    line = brin.readLine();
                    if(line != null)
                    processes[i] = line.trim().replaceAll(" +"," ").split(" ");
                    else
                        flag = false;
                }
                if(brin == null)
                    flag = false;
                if(flag){
//                    for(String[] st1 : processes){
//                        for(String st2 : st1)
//                            System.out.print(st2+" ");
//                        System.out.println();
//                    }


//                    synchronized (mainFrame){
//                        mainFrame.wait();
//                        if(panel != null)
//                            mainFrame.remove(panel);
//                        panel = new processPanel(client.getInetAddress().getHostAddress(),head,processes);
//                        mainFrame.add(panel);
//                        mainFrame.revalidate();
//                        mainFrame.notifyAll();
//                    }
                    if(panel != null)
                        mainFrame.remove(panel);
                    panel = new processPanel(client.getInetAddress().getHostAddress() + this.getName(),head,processes);
                    mainFrame.add(panel);
                    mainFrame.revalidate();
                    System.out.println(this.getName());
                }
                Thread.sleep(4000);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        brothers.remove(this);
        mainFrame.remove(panel);
        mainFrame.revalidate();
    }
}
