import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by nilesh on 7/3/17.
 */
public class ServerThreads extends Thread {
    Socket client;
    ArrayList brothers;

    ServerThreads(Socket s, ArrayList c){
        client = s;
        brothers = c;
    }
    public void run() {
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
                String line;
                String [][] processes = new String[10][];
                //while((line = brin.readLine()) != null ){
                //header
                String[] head = brin.readLine().trim().replaceAll(" +"," ").split(" ");
                System.out.println(head.length);
//                for(String st : head){
//                    System.out.println(st);
//                }
                for(int i=0;i<10;i++){
                    line = brin.readLine();
                    processes[i] = line.trim().replaceAll(" +"," ").split(" ");
                    if(line == null)
                        flag = false;
                }
                if(flag)
                    for(String[] st1 : processes){
                        for(String st2 : st1)
                            System.out.print(st2+" ");
                        System.out.println();
                    }


            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        brothers.remove(this);

    }
}
