package task4.container;

import java.util.ArrayList;
import java.util.List;

public class Container{
    private static Container container= new Container(20,10,30L);
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
            if(isTimeout(req)){
                removeReq();
            }
            if(size==0){
                return null;
            }
            Object obj = list.get(0).request;
            list.remove(0);
            size--;
            return obj;
        }
        /* Stack */
        else if(size > threshold){
            Request req = list.get(size-1);
            if(isTimeout(req)){
                list.clear();
                size = 0;
                return null;
            }
            Object obj = list.get(size-1).request;
            list.remove(size-1);
            size--;
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
        for(Request req : list){
            if(isTimeout(req)){
                list.remove(req);
                size--;
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