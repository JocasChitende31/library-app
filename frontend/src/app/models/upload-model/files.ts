import { Byte } from "@angular/compiler/src/util";

export class Files {
    id?: String
    fileName?: String;
    fileType?: String;
    data?:Byte[];


    constructor(id: String, fileName: String, fileType: String, data:Byte[]){
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}
