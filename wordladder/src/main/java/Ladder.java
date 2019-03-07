import java.io.*;
import java.util.*;
public class Ladder {
    Dict dictionary;
    Stack<String> result;
    String begin,end;
    public Ladder(String begin, String end,Dict dict){
        this.begin = begin;
        this.end = end;
        this.dictionary = dict;
        result = getLadder();
    }
    Stack<String> getLadder(){
        Queue<Stack<String>> ladders = new LinkedList<Stack<String>>();
        Stack<String> part_ladder = new Stack();
        part_ladder.push(begin);
        ladders.add(part_ladder);
        String last;
        TreeSet<String> neighbors = new TreeSet();
        while(!ladders.isEmpty()){
            part_ladder = ((LinkedList<Stack<String>>) ladders).poll();
            last = part_ladder.peek();
            getNeighbors(last,neighbors);
            for(String neighbor : neighbors){
                if(neighbor == end){
                    part_ladder.push(neighbor);
                    return  part_ladder;
                }
                else if(neighbor!=end && !part_ladder.contains(neighbor)){
                    Stack<String> new_ladder = part_ladder;
                    new_ladder.push(neighbor);
                    ((LinkedList<Stack<String>>) ladders).addLast(new_ladder);
                }
            }
        }
        return null;
    }

    void getNeighbors(String word,TreeSet<String> neighbors){
        int size = word.length();
        StringBuffer origin = new StringBuffer(word),ngb_replace, ngb_insert, ngb_delete;
        String n_replace, n_insert,n_delete;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 26; j++){
                String letter = String.valueOf(97+j);
                ngb_insert = origin.insert(i,(char)97+j);
                ngb_replace = origin.replace(i,i+2,letter);
                n_insert = ngb_insert.toString();
                n_replace = ngb_replace.toString();
                if(dictionary.inDict(n_insert)){
                    neighbors.add(n_insert);
                }
                if(dictionary.inDict(n_replace)){
                    neighbors.add(n_replace);
                }
            }
            ngb_delete = origin.delete(i,i+1);
            n_delete = ngb_delete.toString();
            if(dictionary.inDict(n_delete)){
                neighbors.add(n_delete);
            }
        }
    }

    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String path,begin,end;
            System.out.println("-------Word Ladder-------");
            System.out.println("Dictionary file path: ");
            path = br.readLine();
            Dict dict = new Dict(path);
            while(true) {
                System.out.println("Word #1 (or Enter to quit): ");
                begin = br.readLine();
                System.out.println("Word #2 (or Enter to quit): ");
                end = br.readLine();
                //ignore case
                // check word
                Ladder result = new Ladder(begin,end,dict);
                //print ladder
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
