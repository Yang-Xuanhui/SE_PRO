package task4.container;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/easytest")
    public void easytest() throws InterruptedException{
        Consumer consumer = new Consumer("1");
        Producer producer = new Producer("2");

        /* nothing to get */
        consumer.get();

        producer.put("A");
        /* get A */
        consumer.get();
        /*  get nothing */
        consumer.get();

        producer.put("B");
        Thread.sleep(31000);
        /* get nothing because of timeout */
        consumer.get();
    }

    @RequestMapping("test")
    public void test(){
        /* multiple consumers and producers */
        for(Integer i = 0; i<5; i++){
            Consumer consumer = new Consumer("c"+i);
            Producer producer = new Producer("p"+i);
            producer.start();
            consumer.start();
        }
    }
}
