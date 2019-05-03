package wordladder;

import java.util.*;

public class Ladder {
    private String begin, end; //head and tail in the word ladder
    private String result;

    //constructor
    public Ladder(String begin, String end, Dict dict) {
        this.begin = begin;
        this.end = end;
        this.result = parseLadder(dict);
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getResult() {
        return result;
    }

    //get the word ladder, save the ladder in result as a Stack
    Stack<String> getLadder(Dict dict) {
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
        while (!ladders.isEmpty()) {
            //pop the first obj
            part_ladder = ((LinkedList<Stack<String>>) ladders).poll();
            //pop the top obj
            last = part_ladder.peek();
            //get all neighbors of the given word
            getNeighbors(last, neighbors, dict);

            //check each neighbor
            for (String neighbor : neighbors) {
                //if it equals to the end, get the result
                if (neighbor.equals(end)) {
                    part_ladder.push(neighbor);
                    return part_ladder;
                }
                //if it doesn't equal to the end and it isn't in the current ladder, add it
                else if (neighbor != end && !part_ladder.contains(neighbor)) {
                    Stack<String> new_ladder = (Stack<String>) part_ladder.clone(); //shallow copy
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
    void getNeighbors(String word, TreeSet<String> neighbors, Dict dict) {
        int size = word.length();
        //change the word only one letter once
        StringBuffer ngb_replace, origin = new StringBuffer(word);
        String n_replace;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 26; j++) {
                String old_letter = origin.substring(i, i + 1);          //old letter
                String new_letter = Character.toString((char) (97 + j));  //new letter
                ngb_replace = origin.replace(i, i + 1, new_letter); //change
                n_replace = ngb_replace.toString();                   // turn class StringBuffer to class String
                origin.replace(i, i + 1, old_letter);               //back to the original word (before changed)
                //check whether the word is valid and equals to the original one
                if (dict.inDict(n_replace) && !n_replace.equals(word)) {
                    neighbors.add(n_replace);
                }

            }
        }
    }

    // turn result into string
    String parseLadder(Dict dict) {
        Stack<String> ladders = new Stack();
        ladders = getLadder(dict);
        if (ladders.size() == 0) {
            return "no ladder";
        }
        StringBuffer wordladder = new StringBuffer("");
        for (String ladder : ladders) {
            wordladder.append(ladder);
            wordladder.append("  ");
        }
        return wordladder.toString();
    }

}
