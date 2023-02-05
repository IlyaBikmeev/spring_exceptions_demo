package com.example.spring_exceptions_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/picture")
public class PictureMvcController {

    @GetMapping("/form")
    public String uploadForm() {
        log.info("Upload form method");
        return "upload_form";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        try(FileOutputStream stream = new FileOutputStream("data/" + fileName + ".png")) {
            stream.write(file.getBytes());
            log.info("File has been successfully written!");
        }
        return "redirect:/picture/form";
    }
}
