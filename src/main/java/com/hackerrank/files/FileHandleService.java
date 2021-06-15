package com.hackerrank.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileHandleService {
	
	public void handleUpload(MultipartFile file, String filename, String location) throws IOException {
		Path target = Paths.get(location).toAbsolutePath().normalize();
		Files.createDirectories(target);
		if(file.getSize() > 100000) {
			throw new FileSizeExceedException("File size more than 100KB");
		}else {
			Files.copy(file.getInputStream(), target.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	public Resource handleDownload(String filename, String location) throws MalformedURLException, FileNotFoundException {
		Path target = Paths.get(location).toAbsolutePath().normalize();
		Resource resource = new UrlResource(target.resolve(filename).toUri());
		if(resource.exists()) {
            return resource;
        } else {
            throw new RequestFileNotExist("File Not Exists");
        }
	}

}
