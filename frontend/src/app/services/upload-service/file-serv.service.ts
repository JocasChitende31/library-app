import { HttpClient, HttpContext, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DISABLE_GLOBAL_EXCEPTION_HANDLING } from 'src/app/core/interceptors/token.interceptor';
import { AppConstants } from 'src/app/env/app-constants';
import { Files } from 'src/app/models/upload-model/files';

@Injectable({
  providedIn: 'root'
})
export class FileServService {

  baseUrl: String;

  constructor(private http: HttpClient) {
    this.baseUrl = AppConstants.apiUploadUrl;
  }

  public uploadFile(anyFile: any) {
    return this.http.post<File>(this.baseUrl + 'uploadFile', anyFile, {
      reportProgress: true, observe: 'events',
      context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true)
    });
  }
  public getFiles(): Observable<Files[]> {
    return this.http.get<Files[]>(this.baseUrl + 'files', {
      context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true)
    });
  }
  public downloadFile(fielId: string) {
    return this.http.get(this.baseUrl + `downloadFile/${fielId}`, {
      responseType: 'blob',
      reportProgress: true,
      observe: 'events',
      context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true)
    });
  }
}
