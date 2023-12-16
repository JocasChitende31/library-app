import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Author } from '../models/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  authorUrl: string;

  constructor(private http: HttpClient) {
    this.authorUrl = 'http://localhost:8080/api';
  }

  public findAll(): Observable<Author[]> {
    return this.http.get<Author[]>(`${this.authorUrl}/authors`);
  }
  public save(author: Author) {
    return this.http.post<Author>(`${this.authorUrl}/create/author`, author);
  }
  public delete(autId: any): Observable<Author> {
    let params = new HttpParams().set('id', autId)
    return this.http.delete<Author>(`${this.authorUrl}/delete/${autId}/author`, { params: params });
  }
}
