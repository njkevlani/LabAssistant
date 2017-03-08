/**
 * Created by nilesh on 7/3/17.
 */
public class FunctionNJK {
    public static boolean checkIP(String ip){
        try{
            if(ip == null || ip.isEmpty())
                return false;
            String[] parts = ip.split("\\.");
            if(parts.length != 4)
                return false;
            for(String s : parts){
                int i = Integer.parseInt(s);
                if(i<0 || i>255)
                    return false;
            }
            if(ip.endsWith("."))
                return false;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
