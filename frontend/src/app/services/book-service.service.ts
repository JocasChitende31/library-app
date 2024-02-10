import { HttpClient, HttpContext, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DISABLE_GLOBAL_EXCEPTION_HANDLING } from '../core/interceptors/token.interceptor';
import { AppConstants } from '../env/app-constants';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  
  private bookUrl: String;

  constructor(private http: HttpClient) {
    this.bookUrl = AppConstants.baseUrlApi;
    
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.bookUrl}/books`, { context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) });
  }
  public findById(bookId: any): Observable<Book> {
    return this.http.get<Book>(`${this.bookUrl}/${bookId}/book`, { context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) });
  }

  public save(book: Book) {
    return this.http.post<Book>(`${this.bookUrl}/create/book`, book);
  }
  public findBookByCategoryId(catId: any): Observable<Book[]> {
    let params = new HttpParams().set('id', catId)
    return this.http.get<Book[]>(`${this.bookUrl}/${catId}/books`, { params: params, context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) });
  }
  public deleteBook(bookId: any): Observable<Book> {
    let params = new HttpParams().set('id', bookId);
    return this.http.delete<Book>(`${this.bookUrl}/delete/${bookId}/book`);
  }
  public update(bookId: any, book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.bookUrl}/update/${bookId}/book`, book);
  }
}
