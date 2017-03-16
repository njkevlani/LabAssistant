import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by nilesh on 14/3/17.
 */
public class ClientScreenShotThread extends Thread {
    Socket s;
    BufferedReader br;
    ClientScreenShotThread(Socket s){
        this.s = s;
        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }
        catch (Exception e){

        }
    }

    @Override
    public void run() {
        while(true){
            try{
                if(br.readLine().equals("send")){
                    sendSS();
                }
                else if(br.readLine().equals("END"))
                    break;

            }
            catch (Exception e){

            }
        }
        this.stop();
    }

    private void sendSS(){

    }
}
