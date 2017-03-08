import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by nilesh on 7/3/17.
 */
public class test {
    public static void main(String[] args) throws Exception {
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                for(int i=0;;i++){
//                    System.out.println(i);
//                    try{sleep(500);}catch (Exception e){}
//                }
//            }
//        };
//
//        Thread t2 = new Thread(){
//            @Override
//            public void run() {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                try{
//                    while(true){
//                        if(br.readLine().equals("hi")){
//                            System.out.println("done");
//                            return;
//                        }
//
//                    }
//                }
//                catch (Exception e){
//
//                }
//            }
//        };
//
//       t1.start();
//       t2.start();
//

        JFrame frame = new JFrame("Test");
        frame.setSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String str1 = "NJK";
        String str = str1;
        JLabel label = new JLabel(str);
        frame.add(label);
        frame.setVisible(true);
        for(int i = 0; i<10; i++){
            System.out.println("doing it");
            str = str1+i;
            Thread.sleep(2000);
            frame.remove(label);
            label = new JLabel(str);
            frame.add(label);

            frame.revalidate();
            //frame.repaint();
            //label.revalidate();

        }
    }
}
