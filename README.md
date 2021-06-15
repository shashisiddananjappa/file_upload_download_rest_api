## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Read-Only Files:
- src/test/*

## Requirements:
The REST service needs to expose 2 API endpoints for file uploads and downloads.
All the uploaded files needs to be stored in the local file system which needs to be at `UPLOAD_DIR=PROJECT_ROOT/uploads`.

Validations to be performed:
* If a file size exceeds 100KB, return the status code INTERNAL_SERVER_ERROR and don't store file.
* You are expected to use a file size limit constraint using configuration instead of doing it programmatically.


Required API endpoints to be exposed:

`POST` request to `/uploader` :
* receives two parameters, `fileName` and `file`
* stores the file in UPLOAD_DIR and returns status code 201 as a response
* if the user uploads same `fileName` file again, the previous file should be replaced with the latest one and return status code 201

`GET` request to `/downloader`:
* accepts `fileName` as a request parameter
* if file exists, it should return the file with status code 200
* if file doesn't exist, it should return status code 404

Your task is to complete the given project so that it passes all the test cases when running the provided unit tests.

## Commands
- run: 
```bash
mvn clean package; java -jar target/FileUploadDownloadApi-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```