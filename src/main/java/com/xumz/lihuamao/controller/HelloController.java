package com.xumz.lihuamao.controller;

import com.xumz.lihuamao.common.AjaxResult;
import org.springframework.web.bind.annotation.*;


/**
 * @author xumingzhe
 * @date 2022/3/17 21:09
 * @description:
 */


//@Api(tags = "Hello")
@RestController
@RequestMapping("/welcome")
public class HelloController {

    @GetMapping("/hello")
    public AjaxResult<String> hello(){
        System.out.println("----------");
        return new AjaxResult("msg", "good");

    }


}
