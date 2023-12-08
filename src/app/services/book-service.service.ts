import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private bookUrl: string;

  constructor(private http: HttpClient) {
    this.bookUrl = 'http://localhost:8080/api';
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.bookUrl}/books`);
  }
  public save(book: Book) {
    return this.http.post<Book>(`${this.bookUrl}/create/book`, book);
  }
}
