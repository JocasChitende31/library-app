package com.atendestartup.fileuploaddownloadapirest.controller;

import com.atendestartup.fileuploaddownloadapirest.dto.UploadFileResponse;
import com.atendestartup.fileuploaddownloadapirest.entities.DBFile;
import com.atendestartup.fileuploaddownloadapirest.service.DBFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController()
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @PostMapping(value = "/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
        DBFile dbFile = this.dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();
        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping(value ="/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFile(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> this.uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
        //load file from a database
        DBFile  dbFile = this.dbFileStorageService.getFile(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @GetMapping(value = "/files")
    public ResponseEntity files(){
        List<DBFile> dbFiles = this.dbFileStorageService.getFiles();
        return ResponseEntity.ok(dbFiles);
    }
}
