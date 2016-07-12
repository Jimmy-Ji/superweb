package com.jimmy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jim on 15-12-31.
 */
@Controller
public class HelloSpringController {

    @RequestMapping(value = "/hello.htm",method = RequestMethod.POST)
    public String hello(HttpServletRequest request, Model model){
        System.out.print("进啊来了");
        String hello = request.getParameter("hello");
        Map t = request.getParameterMap();
        model.addAttribute("hello","hello");
        return "hello";

    }

    @RequestMapping(value="/json.htm",method = RequestMethod.GET)
    @ResponseBody
    public Map getJson(){
        Map map = new HashMap();
        map.put("key1","hello");
        map.put("key2","world");
        return map;
    }

}
