package wordladder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LadderController {

    @RequestMapping("/ladder")
    public Ladder ladder(@RequestParam(value="begin", defaultValue="code") String begin,@RequestParam(value="end", defaultValue="data") String end) {
        Dict dict = new Dict();
        return new Ladder(begin,end,dict);
    }
}