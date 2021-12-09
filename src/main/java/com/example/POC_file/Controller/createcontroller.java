package com.example.POC_file.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

    @GetMapping("/copyfile")
    public String copyfiles(){
        try {
            File new123 = new File("E:\\fresh files\\king.txt");
            byte[] array = new byte[(int) new123.length()];
            FileInputStream sourcefile = new FileInputStream("E:\\fresh files\\king.txt");
            sourcefile.read(array);
            System.out.println("Byte Length is " +new123.length());
            File file1 = new File("E:\\fresh files\\queen.txt");
            if(file1.createNewFile())
            {
                System.out.println("File is Created");
            }
            else {
                return "File cannot be able to create";
            }
            if(file1.exists()){
                if(file1.canWrite()){
                    FileOutputStream destinationfile = new FileOutputStream("E:\\fresh files\\queen.txt");
                    destinationfile.write(array);
                    destinationfile.close();
                }else {
                    return "File exist but cannot able write";
                }
            }
            else {
                return "File is Not Exist";
            }
            sourcefile.close();
            return "Success";
        }
        catch (Exception e){
            throw new RuntimeException("noooooooooooooooooooo");
        }
    }

}
