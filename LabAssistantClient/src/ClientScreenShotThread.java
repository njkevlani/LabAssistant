import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by nilesh on 14/3/17.
 */
public class ClientScreenShotThread extends Thread {
    ServerSocket ss;
    Socket s;
    //Streams
    //DataInputStream in;
    ObjectOutputStream out;
    int port=7879;

    ClientScreenShotThread(){
        start();
    }

    @Override
    public void run() {
        try{
            ss = new ServerSocket(port);
            System.out.println("Waiting for someone to connect for ss");
            s = ss.accept();
            System.out.println("Someone connected for ss");

            out = new ObjectOutputStream(s.getOutputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        BufferedImage image = null;
        Robot r = null;
        try{
            r = new Robot();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rect = new Rectangle(0, 0, size.width, size.height);
        ImageIcon icon = null;

        while(true){
            try{
                System.out.println("Sending ss");

                System.gc();
                image = r.createScreenCapture(rect);
                //ImageIO.write(r.createScreenCapture(rect),"jpg",new File("test"));
                icon = new ImageIcon(image);
                out.writeObject(icon);
                out.flush();

                System.out.println("ss sent");
                sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
    }

}
