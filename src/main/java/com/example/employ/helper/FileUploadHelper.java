package com.example.employ.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    @Value("${spring.UPLOAD_DIR}")
    private String UPLOAD_DIR;

    public boolean uploadFile(MultipartFile file){
        boolean image=false;
        try{
//            InputStream is=file.getInputStream();
//            byte data[]=new byte[is.available()];
//            is.read(data);
//
//            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
//            fos.write(data);
//            fos.close();

            Files.copy(file.getInputStream(),
                    Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            e.printStackTrace();
        }

        return image;

    }
}
