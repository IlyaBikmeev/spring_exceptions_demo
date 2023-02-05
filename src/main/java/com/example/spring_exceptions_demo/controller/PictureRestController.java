package com.example.spring_exceptions_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/picture")
@Slf4j
public class PictureRestController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        try(FileOutputStream stream = new FileOutputStream("data/" + fileName + ".png")) {
            stream.write(file.getBytes());
            log.info("File has been successfully written!");
        }

        log.info(file.getContentType() + ", " + file.getOriginalFilename());
        return "success";
    }

    @GetMapping(value = "/download", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getFile() throws IOException{
        byte[] bytes = null;
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("data/file.png"))) {
            bytes = input.readAllBytes();
        }
        return ResponseEntity.ok(bytes);
    }
}
