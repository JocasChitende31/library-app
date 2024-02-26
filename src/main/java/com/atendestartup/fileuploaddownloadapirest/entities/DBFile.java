package com.atendestartup.fileuploaddownloadapirest.entities;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name="tb_files")
public class DBFile {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private String id= UUID.randomUUID().toString();
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_type")
	private String fileType;

	@Lob
	private byte[] data;

	public DBFile() {

	}

	public DBFile(String id, String fileName, String fileType, byte[] data) {

		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	public DBFile(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return this.fileName; 
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return this.fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getData() {
		return this.data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}
