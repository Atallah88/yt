import java.io.FileWriter;
import java.io.IOException;

public class reg {
public static String save(String nm, String ps,String age, String tel, String email) throws IOException{
    
FileWriter fw = new FileWriter("e://data.txt", true);

fw.write(nm+" "+ps+" "+age+" "+tel+" "+email+"\n");

fw.close();

FileWriter pas = new FileWriter("e://np.txt", true);

pas.write(nm+" "+ps+"\n");

pas.close();

return "ok";
}   
}
