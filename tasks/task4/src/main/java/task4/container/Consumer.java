package task4.container;

public class Consumer extends Thread{
    private String id;
    private Thread t;

    public Consumer(String id1){
        setId(id1);
        System.out.println("Creating consumer" + id1 );
    }

    public String getC_id(){
        return id;
    }
    public void setId(String id1){
        id = id1;
    }

    public synchronized Object get(){
        Container ctnr = Container.getInstance();
        Object obj = ctnr.getRequest();
        Long time = System.currentTimeMillis();
        if(obj==null){
            System.out.println(time + ": Consumer " + id + " get nothing");
            return null;
        }
        else{
            System.out.println(time + ": Consumer " + id + " get request "+obj);
            return obj;
        }
    }

    public void run() {
        System.out.println("Running consumer" + id );
        try {
            for(int i = 6; i > 0; i--) {
                /* let the speed of consumer getting request
                   slower than producer putting request */

                /* random milliseconds the thread will sleep */
                int sleeptime = (int)(1+Math.random()*(20000-1000+1)); //sleeptime>=1000 && sleeptime<=20000
                System.out.println("consumer " + id + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(sleeptime);
                get();
            }
        }catch (InterruptedException e) {
            System.out.println("consumer " + id + " interrupted.");
        }
        System.out.println("consumer " + id + " exiting.");
    }

    public void start () {
        System.out.println("Starting consumer" + id );
        if (t == null) {
            t = new Thread (this, id);
            t.start ();
        }
    }
}
