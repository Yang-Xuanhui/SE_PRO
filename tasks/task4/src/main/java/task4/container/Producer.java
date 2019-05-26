package task4.container;

public class Producer extends Thread{
    private String id;
    private Thread t;

    public Producer(String id1){
        setId(id1);
        System.out.println("Creating producer" + id1 );
    }

    public String getP_id(){
        return id;
    }
    public void setId(String id1){
        id = id1;
    }
    public synchronized void put(Object obj){
        Container ctnr = Container.getInstance();
        ctnr.putRequest(obj);
        Long time = System.currentTimeMillis();
        System.out.println(time + ": producer "+ id + " put request " + obj);
    }

    public void run() {
        System.out.println("Running producer" + id );
        try {
            for(int i = 6; i > 0; i--) {
                /* random milliseconds the thread will sleep */
                int sleeptime = (int)(1+Math.random()*(10000-100+1)); //sleeptime>=100 && sleeptime<=10000
                System.out.println("producer " + id + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(sleeptime);
                put(id+"+"+i);
            }
        }catch (InterruptedException e) {
            System.out.println("producer " + id + " interrupted.");
        }
        System.out.println("producer " + id + " exiting.");
    }

    public void start () {
        System.out.println("Starting producer" + id );
        if (t == null) {
            t = new Thread (this, id);
            t.start ();
        }
    }
}
