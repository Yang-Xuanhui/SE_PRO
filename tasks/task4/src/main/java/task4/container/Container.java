package task4.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container{
    private static Container container= new Container(20,7,30L);
    private List<Request> list;
    private Integer size;
    private Integer capacity;
    private Integer threshold;
    private Long timeout;

    private Container(Integer cap, Integer thr, Long tout){
        list = new ArrayList<>();
        size = 0;
        capacity = cap;
        threshold = thr;
        timeout = tout;
    }

    public static Container getInstance(){
        return container;
    }

    public Object getRequest(){
        /* Queue */
        if(size>0 && size<=threshold){
            Request req = list.get(0);
            /* check timeout */
            if(isTimeout(req)){
                removeReq();
            }
            if(size==0){
                return null;
            }
            req = list.get(0);
            Object obj = req.request;
            list.remove(0);
            size--;
            Long response = System.currentTimeMillis() - req.time;
            System.out.println("response time: "+ response);
            return obj;
        }
        /* Stack */
        else if(size >= threshold){
            Request req = list.get(size-1);
            /* check timeout
               if the last one is timeout, clear the container
              */
            if(isTimeout(req)){
                list.clear();
                size = 0;
                return null;
            }
            req = list.get(size-1);
            Object obj = req.request;
            list.remove(size-1);
            size--;
            Long response = System.currentTimeMillis() - req.time;
            System.out.println("response time: "+ response);
            return obj;
        }
        else{
            return null;
        }
    }

    public void putRequest(Object req){
        /* new request */
        Long time = System.currentTimeMillis();
        Request request = new Request(req,time);

        list.add(request);
        size++;

        if(size>capacity){
            removeReq();
        }
    }

    private Boolean isTimeout(Request req){
        Long time = System.currentTimeMillis();
        return (time-req.time)/1000 > timeout;
    }

    private void removeReq(){
        Iterator<Request> iter = list.iterator();
        while(iter.hasNext()){
            Request req = iter.next();
            if(isTimeout(req)){
                iter.remove();
                size--;
                System.out.println("Timeout: "+req.request);
            }
            else{
                break;
            }
        }
    }

    public Integer getSize(){
        return size;
    }
    public void setCapacity(Integer cap){
        capacity = cap;
    }
    public void setThreshold(Integer thr){
        threshold = thr;
    }
    public void setTimeout(Long t){
        timeout = t;
    }
}