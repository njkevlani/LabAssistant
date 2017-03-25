import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by nilesh on 7/3/17.
 */
public class ClientProcessThread extends Thread {
    String ip, port="7878";
    Socket s;
    PrintStream out;
    ClientProcessThread(String ip){
        this.ip = ip;
        System.out.println("Connecting to for processes" + ip + ":" + port);
        try{
            s = new Socket(ip,7878);
            out = new PrintStream(s.getOutputStream());
        }
        catch (Exception ce){
            ce.printStackTrace();
        }
        start();
    }

    @Override
    public void run() {
        System.out.println("Process Thread started.");
        try{
            Process p;
            BufferedReader br;

            while(true){
                //decide wheather windows or linux
                if(System.getProperty("os.name").toLowerCase().indexOf("win")>= 0)
                    p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\"+"tasklist.exe"); //Windows BS
                else
                    p = Runtime.getRuntime().exec("ps -el --sort=-pcpu"); //ps -e for linux systems //ps -el --sort=-pcpu | head -n 10
                br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                //while((line = br.readLine()) != null){
                for(int i=0;i<10;i++){
                    out.println(br.readLine());
                }
                Thread.sleep(1000);
                //System.out.println("
                // again");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
