package cn.itcast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: demo
 * @author: lisong
 * @since: 2023-02-04 15:26
 **/
@RestController
@RequestMapping
public class DemoController {
    @GetMapping("/demo")
    public String getDemo(){
        return "success";
    }
}
