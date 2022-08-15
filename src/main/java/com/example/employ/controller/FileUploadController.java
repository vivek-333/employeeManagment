package com.example.employ.controller;

import com.example.employ.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;


    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam ("file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if (!file.getContentType().equals("image/jpeg") &&  !file.getContentType().equals("image/png")){

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File must be in jpeg");
            }
             fileUploadHelper.uploadFile(file);


        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("uploded");

    }
}
