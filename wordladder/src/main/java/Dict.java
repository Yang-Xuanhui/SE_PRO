import java.io.*;
import java.util.Vector;

public class Dict {
    Vector<String> dictionary = new Vector();
    public Dict(String path){

        try{
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String word;
            while ((word = br.readLine()) != null){
                dictionary.addElement(word);
            }
            System.out.println(dictionary.capacity());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    boolean inDict(String word){
        return dictionary.contains(word);
    }
}
