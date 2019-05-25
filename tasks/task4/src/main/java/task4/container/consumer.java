package task4.container;

public class consumer {
    private Integer id;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id1){
        id = id1;
    }

    public Object get(){
        Container ctnr = Container.getInstance();
        Object obj = ctnr.getRequest();
        Long time = System.currentTimeMillis();
        if(obj==null){
            System.out.println(time + ": consumer " + id + "get nothing");
            return null;
        }
        else{
            System.out.println(time + ": consumer " + id + "get request "+obj);
            return obj;
        }
    }

}
