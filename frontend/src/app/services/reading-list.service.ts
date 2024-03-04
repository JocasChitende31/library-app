import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DISABLE_GLOBAL_EXCEPTION_HANDLING } from '../core/interceptors/token.interceptor';
import { AppConstants } from '../env/app-constants';
import { ReadingList } from '../models/reading-list';

@Injectable({
  providedIn: 'root'
})
export class ReadingListService {

  readingListUrl: String;

  constructor(private http: HttpClient) {
    this.readingListUrl = AppConstants.baseUrlApi;
   }

  public findMyReadingList(userId: String): Observable<ReadingList[]>{
    return this.http.get<ReadingList[]>(this.readingListUrl + `/my-reading-list/${userId}`,{ context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true)  });
  }
}
