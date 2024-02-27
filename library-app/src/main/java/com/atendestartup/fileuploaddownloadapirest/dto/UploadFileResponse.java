package com.atendestartup.fileuploaddownloadapirest.dto;

public record UploadFileResponse(String fileName, String downloadUri, String contentType, long size) {
}
