package com.jimmy.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

/**
 * Created by jim on 15-12-27.
 */
public class HelloController extends ActionSupport{
    Logger log = Logger.getLogger(HelloController.class);
    public String hello(){
        log.info("hello this is log test!");
        return SUCCESS;
    }

}
