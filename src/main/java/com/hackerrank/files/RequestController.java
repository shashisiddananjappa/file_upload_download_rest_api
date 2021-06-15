package com.hackerrank.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RequestController {
    public static final String UPLOAD_DIR = "uploads/";
    
    @Autowired
    private FileHandleService fileHandleService;

    @PostMapping("/uploader")
    public ResponseEntity<Object> uploader(@RequestParam("fileName") String fileName, @RequestParam("file") MultipartFile file) throws IOException {
    	fileHandleService.handleUpload(file, fileName, UPLOAD_DIR);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
    	
    }

    @GetMapping("/downloader")
    public ResponseEntity<Resource> downloader(@RequestParam String fileName) throws MalformedURLException, FileNotFoundException {
    	Resource resource = fileHandleService.handleDownload(fileName, UPLOAD_DIR);
    	return ResponseEntity.ok().body(resource);
    }
}
