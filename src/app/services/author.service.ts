import { HttpClient } from '@angular/common/http';
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
}
