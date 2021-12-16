package com.example.POC_file.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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


    @GetMapping("/copyfileusingmultipart")
    public String copyfileusingmultipart(@RequestParam MultipartFile file){
        try {
            byte[] array = new byte[file.getBytes().length];
            String name = file.getOriginalFilename();
          //  File new123 = new File("E:\\fresh files\\king.txt");
          //  byte[] array = new byte[(int) new123.length()];
         //   FileInputStream sourcefile = new FileInputStream("E:\\fresh files\\king.txt");
          //  sourcefile.read(array);
         //   System.out.println("Byte Length is " +new123.length());
            File file1 = new File("E:\\fresh files\\"+name);
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
         //   sourcefile.close();
            return "Success";
        }
        catch (Exception e){
            throw new RuntimeException("noooooooooooooooooooo");
        }
    }


    @GetMapping("/createdirectory")
    public  Object createdirectory(){

        try {
              File file = new File("E:\\fresh files\\new\\sabari");
              if(!file.exists()){
                   if(file.mkdirs()){
                        return "Successfully directory created";
                   }
                   else {
                          return "cannot be able to create directory";
                   }
              }
              return "Directory Already exist";

        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception thrown using try and catch method");
        }

    }

    private final String baseFolderStr = "Files/upload";
    private final Path rootLocation = Paths.get(baseFolderStr);

    @GetMapping("/getpath")
    public  Object getpath(@RequestParam MultipartFile file123){

        try {
            byte[] array = file123.getBytes();
            File file1 = new File(String.valueOf(rootLocation));
            if(!file1.exists()){
                if(file1.mkdirs()){
                    System.out.println("Successfully directory created");
                }
                else {
                    System.out.println("cannot be able to create directory");
                }
            }
            else {
                System.out.println("Directory Already exist");
            }
            File file = new File(rootLocation+"//"+file123.getOriginalFilename());
            if(file.createNewFile()){
                System.out.println("File created");
                FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
                System.out.println("Destiny path is " + file.getPath());
                fileOutputStream.write(array);
                fileOutputStream.close();
            }else {
                System.out.println("File cannot be able to create");
            }

           String fileName = file123.getOriginalFilename();
           return fileName;

        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception thrown using try and catch method");
        }

    }

    @GetMapping("/pdftotextfile")
    public Object pdftotextfile(@RequestParam MultipartFile file){
       try {
           File file1 = new File(String.valueOf(rootLocation));
           if(!file1.exists()){
               if(file1.mkdirs()){
                   System.out.println("Successfully directory created");
               }
               else {
                   System.out.println("cannot be able to create directory");
               }
           }
           else {
               System.out.println("Directory Already exist");
           }
           String filename = file.getOriginalFilename();
           InputStream inputStream = file.getInputStream();
///*           private final String baseFolderStr = "Files/upload";
//           private final Path rootLocation = Paths.get(baseFolderStr);*/
           Path finalpath = Paths.get(baseFolderStr+"/"+filename);
           System.out.println(finalpath);
           System.out.println(rootLocation);
           Files.copy(inputStream,finalpath, StandardCopyOption.REPLACE_EXISTING);
           return finalpath;
       }
       catch (Exception e){
             throw new RuntimeException("its not my Fault");
       }
    }



}
