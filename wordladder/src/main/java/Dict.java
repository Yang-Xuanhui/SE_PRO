import java.io.*;
import java.util.Vector;

public class Dict {
    //contains all valid words
    Vector<String> dictionary = new Vector();
    public Dict(String path){
        //read file
        try{
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String word;
            while ((word = br.readLine()) != null){
                dictionary.addElement(word);
            }
        } catch (IOException e){
            System.out.println("Error: Can't get the dictionary with the given path.");
            //e.printStackTrace();
        }
    }
    //check whether the word is valid
    boolean inDict(String word){
        return dictionary.contains(word);
    }
    boolean isEmpty(){
        if(dictionary.size()==0){
            return true;
        }
        else return false;
    }
}
