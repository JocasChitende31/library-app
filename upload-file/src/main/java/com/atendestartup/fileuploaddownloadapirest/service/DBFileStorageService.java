package com.atendestartup.fileuploaddownloadapirest.service;

import com.atendestartup.fileuploaddownloadapirest.dto.DBFileDTO;
import com.atendestartup.fileuploaddownloadapirest.entities.DBFile;
import com.atendestartup.fileuploaddownloadapirest.exceptions.FileStorageException;
import com.atendestartup.fileuploaddownloadapirest.exceptions.MyFileNotFoundException;
import com.atendestartup.fileuploaddownloadapirest.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dBFileRepository;

    public DBFile storeFile(MultipartFile file){
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            // checks if the file's name has a invalid characters
            if (fileName.contains("..")){
                throw new FileStorageException("Desculpe! O nome do arquivo contém sequência errada de caracteres" + fileName);
            }
            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            return dBFileRepository.save(dbFile);

        } catch (IOException ex){
            throw new FileStorageException("O arquivo não pode ser armazenado!" + fileName + ", por favor, tente novamente", ex);
        }
    }
    public DBFile getFile(String fieId){
        DBFile dbFile = dBFileRepository.findById(fieId).orElseThrow(()->new MyFileNotFoundException("Arquivo não econtrado" + fieId));

        return dbFile;

    }
    public List<DBFile> getFiles(){
        List<DBFile> dbFile = this.dBFileRepository.findAll();
        return dbFile;
    }
}
