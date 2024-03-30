import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConstants } from '../env/app-constants';
import { ReadingList } from '../models/reading-list';
import { ReadingListPost } from '../models/reading-list-post';

@Injectable({
  providedIn: 'root'
})
export class ReadingListService {

  readingListUrl: String;

  constructor(private http: HttpClient) {
    this.readingListUrl = AppConstants.baseUrlApi;
   }
  public findMyReadingList(userId: any): Observable<ReadingList[]>{
    let params = new HttpParams().set('id', userId);
    return this.http.get<ReadingList[]>(this.readingListUrl + `/my-reading-list/${userId}`, {params: params });
  }
  public saveToMyReadingList(item: ReadingListPost){
   return this.http.post<ReadingListPost>(`${this.readingListUrl}/add-reading-list`, item);
  }
  public deleteItemFromMyReadingList(itemId:any){
    let params = new HttpParams().set('id', itemId);
    return this.http.delete<ReadingListPost>(`${this.readingListUrl}/delete/item/${itemId}`, {params:params})
  }
}
