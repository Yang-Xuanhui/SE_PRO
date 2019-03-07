import java.io.*;
import java.util.Vector;

public class Dict {
    //字典类，包含所有合法单词
    Vector<String> dictionary = new Vector();
    public Dict(String path){
        //读文件
        try{
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String word;
            while ((word = br.readLine()) != null){
                dictionary.addElement(word);
            }
            System.out.println(dictionary.capacity());
        } catch (IOException e){
            //异常输出
            e.printStackTrace();
        }
    }
    //检查单词是否在字典中
    boolean inDict(String word){
        return dictionary.contains(word);
    }
}
