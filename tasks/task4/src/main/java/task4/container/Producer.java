package task4.container;

public class Producer {
    private Integer id;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id1){
        id = id1;
    }
    public void put(Object obj){
        Container ctnr = Container.getInstance();
        ctnr.putRequest(obj);
        Long time = System.currentTimeMillis();
        System.out.println(time + ": producer "+ id + "put request");
    }
}
