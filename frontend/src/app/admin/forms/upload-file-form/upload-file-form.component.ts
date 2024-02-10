import { Component, Input, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Files } from 'src/app/models/upload-model/files';
import { FileServService } from 'src/app/services/upload-service/file-serv.service';

@Component({
  selector: 'app-upload-file-form',
  templateUrl: './upload-file-form.component.html',
  styleUrls: ['./upload-file-form.component.css']
})
export class UploadFileFormComponent implements OnInit {

  @Input() requiredFileTypes?: string;
  titleUploadFile: String;
  titleUpdateUploadFile: String;
  fileName = "";
  fielId?: String;
  uploadProgress?: number;
  uploadSub?: Subscription;
  files: Files[] = [];

  /*   fileForm = new FormGroup({
      file: new FormControl('', Validators.required)
    }); */
  constructor(private uploadFileService: FileServService) {
    this.titleUploadFile = 'Upload File';
    this.titleUpdateUploadFile = '';
    this.getFiles();

  }

  OnFileSelected(event: any) {
    let file: File = event.target.files[0]
    if (file) {
      this.fileName = file.name;
      const formData = new FormData();
      formData.append('file', file);

      this.uploadFileService.uploadFile(formData).subscribe(data => {
          
        console.log(data);
      })
    }
  }
  cancelUpload() { }
  ngOnInit(): void {
  }

  reset() {
    this.uploadProgress;
    this.uploadSub;
  }
  updateUploadFile() {

  }
  goToList() { }
  getFiles() {
    this.uploadFileService.getFiles().subscribe(data => {
        this.files = data;
    })
  }
}
