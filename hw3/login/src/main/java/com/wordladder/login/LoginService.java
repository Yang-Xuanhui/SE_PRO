package com.wordladder.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin
public class LoginService {

    @RequestMapping("search")
    public String searchLadder(@RequestParam(value = "begin", defaultValue = "code") String begin, @RequestParam(value = "end", defaultValue = "data") String end) {
        RestTemplate restTemplate = new RestTemplate();
        //向另一个服务(word-ladder)发送http请求
        String result = restTemplate.getForObject("http://ladder:8081/get_wordladder?begin={1}&end={2}"
                , String.class, begin, end);
        return result;
    }
}