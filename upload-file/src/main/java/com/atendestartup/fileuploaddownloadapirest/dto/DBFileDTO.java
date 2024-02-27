package com.atendestartup.fileuploaddownloadapirest.dto;

public record DBFileDTO(String fileName, String fileType, byte[] data) {
}
