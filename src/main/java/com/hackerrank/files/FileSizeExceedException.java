package com.hackerrank.files;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileSizeExceedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public FileSizeExceedException(String message) {
        super(message);
    }


}
