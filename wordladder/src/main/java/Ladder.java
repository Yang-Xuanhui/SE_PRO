import java.io.*;
import java.util.*;

public class Ladder {
    Dict dictionary;
    Stack<String> result; //保存最终结果
    String begin,end; //wordladder开始和结尾的单词

    //构造函数
    public Ladder(String begin, String end,Dict dict){
        this.begin = begin;
        this.end = end;
        this.dictionary = dict;
        //result = getLadder();
    }

    //得到 wordladder
    Stack<String> getLadder(){
        //存储中间可能的ladder的队列
        Queue<Stack<String>> ladders = new LinkedList<Stack<String>>();
        //存储可能的ladder
        Stack<String> part_ladder = new Stack();
        //初始化
        part_ladder.push(begin);
        ladders.add(part_ladder);
        //用来存每个可能ladder中的尾部(栈顶)的单词
        String last;
        //储存某单词的所有相邻的单词
        //相邻：只有一个字母不同，只多一个字母，只少一个字母
        TreeSet<String> neighbors = new TreeSet();

        //不断从队首取出可能的ladder，在队尾加入更长的ladder
        //直到队列为空或得到最终结果
        while(!ladders.isEmpty()){
            //取出队首元素
            part_ladder = ((LinkedList<Stack<String>>) ladders).poll();
            //取出栈顶元素
            last = part_ladder.peek();
            //得到last的所有neighbor
            getNeighbors(last,neighbors);

            //检查每一个neighbor
            for(String neighbor : neighbors){
                //如果和结尾单词相同，得到结果，返回
                if(neighbor == end){
                    part_ladder.push(neighbor);
                    return  part_ladder;
                }
                //如果和结尾单词不同，且和当前ladder中单词不重复，加入到ladder尾(栈顶)
                else if(neighbor!=end && !part_ladder.contains(neighbor)){
                    Stack<String> new_ladder = part_ladder;
                    new_ladder.push(neighbor);
                    ((LinkedList<Stack<String>>) ladders).addLast(new_ladder);
                }
            }
        }
        //没有结果，返回null
        return null;
    }

    //得到某单词的所有neighbor，并存在neighbors中
    void getNeighbors(String word,TreeSet<String> neighbors){
        int size = word.length();
        //修改该单词，增、删、改
        StringBuffer origin = new StringBuffer(word),ngb_replace, ngb_insert, ngb_delete;
        String n_replace, n_insert,n_delete;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 26; j++){
                String letter = String.valueOf(97+j);
                ngb_insert = origin.insert(i,(char)97+j);
                ngb_replace = origin.replace(i,i+2,letter);    //origin插入了一个字母，所以修改两个字母(i+2)
                n_insert = ngb_insert.toString();
                n_replace = ngb_replace.toString();
                //检查是否是字典中的单词
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

    //输出结果
    void print(){
        if(result!=null){
            System.out.println("WordLadder: ");
            int size = result.size();
            for(int i =0; i<size-1;i++){
                System.out.println(result.elementAt(i) + " --> ");
            }
            System.out.println(result.elementAt(size-1));
        }
        else{
            System.out.println("No Ladder from "+ begin + " to " + end);
        }
    }
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String path,begin,end;
            System.out.println("-------Word Ladder-------");
            System.out.println("Dictionary file path: ");
            //根据输入路径创建字典对象
            path = br.readLine();
            Dict dict = new Dict(path);
            //throw ?
            while(true) {
                System.out.println("Word #1 (or Enter to quit): ");
                begin = br.readLine();
                System.out.println("Word #2 (or Enter to quit): ");
                end = br.readLine();
                //ignore case
                // check word
                Ladder result = new Ladder(begin,end,dict);
                result.getLadder();
                //输出结果
                result.print();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
