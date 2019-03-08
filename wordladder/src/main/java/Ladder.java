import java.io.*;
import java.util.*;

public class Ladder {
    Dict dictionary;
    String begin,end; //head and tail in the word ladder

    //constructor
    public Ladder(String begin, String end,Dict dict){
        this.begin = begin;
        this.end = end;
        this.dictionary = dict;
    }

    //get the word ladder, save the ladder in result as a Stack
    Stack<String> getLadder(){
        //queue contains the possible ladder
        Queue<Stack<String>> ladders = new LinkedList<Stack<String>>();
        //possible ladder
        Stack<String> part_ladder = new Stack();
        //initial queue and stack
        part_ladder.push(begin);
        ladders.add(part_ladder);
        //the word at the top of each stack of ladder
        String last;
        //contains all neighbors
        //neighbor: the word only has one letter different from the original one
        TreeSet<String> neighbors = new TreeSet();

        //pop possible ladder from queue, and push new possible ladder at the end of the queue
        //until the queue is empty
        while(!ladders.isEmpty()){
            //pop the first obj
            part_ladder = ((LinkedList<Stack<String>>) ladders).poll();
            //pop the top obj
            last = part_ladder.peek();
            //get all neighbors of the given word
            getNeighbors(last,neighbors);

            //check each neighbor
            for(String neighbor : neighbors){
                //if it equals to the end, get the result
                if(neighbor.equals(end)){
                    part_ladder.push(neighbor);
                    return part_ladder;
                }
                //if it doesn't equal to the end and it isn't in the current ladder, add it
                else if(neighbor!=end && !part_ladder.contains(neighbor)){
                    Stack<String> new_ladder = (Stack<String>)part_ladder.clone(); //shallow copy
                    new_ladder.push(neighbor);
                    ((LinkedList<Stack<String>>) ladders).addLast(new_ladder);
                }
            }
        }
        //no result, return empty stack
        Stack<String> fail = new Stack();
        return fail;
    }

    //get all neighbors
    void getNeighbors(String word,TreeSet<String> neighbors){
        int size = word.length();
        //change the word only one letter once
        StringBuffer ngb_replace, origin = new StringBuffer(word);
        String n_replace;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 26; j++){
                String old_letter = origin.substring(i,i+1);          //old letter
                String new_letter= Character.toString((char)(97+j));  //new letter
                ngb_replace = origin.replace(i,i+1,new_letter); //change
                n_replace = ngb_replace.toString();                   // turn class StringBuffer to class String
                origin.replace(i,i+1,old_letter);               //back to the original word (before changed)
                //check whether the word is valid and equals to the original one
                if(dictionary.inDict(n_replace) && !n_replace.equals(word)){
                    neighbors.add(n_replace);
                }

            }
        }
    }

    //print the result
    void print_result(Stack<String> result){
        int size = result.size();
        if(size!=0){
            System.out.println("WordLadder: ");
            for(int i =0; i<size;i++){
                System.out.println(result.elementAt(i));
            }
        }
        else{
            System.out.println("No Ladder from "+ begin + " to " + end);
        }
    }
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String path,begin,end;
            Dict dict;
            System.out.println("-------Word Ladder-------");
            while(true) {
                System.out.println("Dictionary file path: ");
                //create the dictionary with the given path
                path = br.readLine();
                dict = new Dict(path);
                if(!dict.isEmpty()){
                    break;
                }
            }
            while(true) {
                System.out.println("Word #1 (or Enter to quit): ");
                begin = br.readLine();
                begin = begin.toLowerCase();
                //enter to quit
                if(begin.equals("")){
                    System.out.println("Goodbye...");
                    break;
                }
                //check whether the word is valid
                if (!dict.inDict(begin)){
                    System.out.println("Error: " + begin + " is not in the dictionary.");
                    continue;
                }

                System.out.println("Word #2 (or Enter to quit): ");
                end = br.readLine();
                end = end.toLowerCase();
                //enter to quit
                if(begin.equals("")){
                    System.out.println("Goodbye...");
                    break;
                }

                if (!dict.inDict(end)){
                    System.out.println("Error: " + end + " is not in the dictionary.");
                    continue;
                }
                //check length
                if(begin.length()!=end.length()){
                    System.out.println("Error: two words are not the same length.");
                    continue;
                }

                Ladder wordladder = new Ladder(begin,end,dict);
                Stack<String> result;
                result = wordladder.getLadder();
                //print the result
                wordladder.print_result(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
