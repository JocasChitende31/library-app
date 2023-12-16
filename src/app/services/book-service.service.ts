import { HttpClient, HttpParams } from '@angular/common/http';
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
  public findById(bookId: any): Observable<Book> {
    return this.http.get<Book>(`${this.bookUrl}/${bookId}/book`);
  }

  public save(book: Book) {
    return this.http.post<Book>(`${this.bookUrl}/create/book`, book);
  }
  public findBookByCategoryId(catId: any): Observable<Book[]> {
    let params = new HttpParams().set('id', catId)
    return this.http.get<Book[]>(`${this.bookUrl}/${catId}/books`, { params: params });
  }
  public deleteBook(bookId: any): Observable<Book> {
    let params = new HttpParams().set('id', bookId);
    return this.http.delete<Book>(`${this.bookUrl}/delete/${bookId}/book`);
  }
}
