package com.atendestartup.fileuploaddownloadapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atendestartup.fileuploaddownloadapirest.entities.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
	
}
