package com.example.POC_file.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general")
public class createcontroller {

    Logger logger= LoggerFactory.getLogger(createcontroller.class);

    /*@RequestMapping("/summa1")
    public String summa1()
    {
        logger.info("info  info levelll");
        return "Sabarish1";
    }

    @RequestMapping("/summa2")
    public String summa2()
    {
        logger.debug("info  debug levelll");
        return "Sabarish2";
    }*/

    /*@RequestMapping("/summa3")
    public String summa3()
    {
        logger.error("info  error levelll");
        return "Sabarish3";
    }*/

    @RequestMapping("/summa4")
    public String summa4()
    {
        logger.trace("info  trace levelll");
        return "Sabarish4";
    }

    /*@RequestMapping("/summa5")
    public String summa5()
    {
        logger.warn("info  warn levelll");
        return "Sabarish5";
    }*/


}
