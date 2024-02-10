import { HttpClient, HttpContext, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DISABLE_GLOBAL_EXCEPTION_HANDLING } from '../core/interceptors/token.interceptor';
import { AppConstants } from '../env/app-constants';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categoryUrl: String;

  constructor(private http: HttpClient) {
    this.categoryUrl = AppConstants.baseUrlApi;
  }

  public findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoryUrl}/categories`, { context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) })
  }
  public findById(catId: any): Observable<Category> {
    let params = new HttpParams().set('id', catId);
    return this.http.get<Category>(`${this.categoryUrl}/${catId}/category`, { params: params,  context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true)  })
  }
  public save(category: Category) {
    return this.http.post<Category>(`${this.categoryUrl}/create/category`, category);
  }
  public delete(catId: any): Observable<Category> {
    let params = new HttpParams().set('id', catId);
    return this.http.delete<Category>(`${this.categoryUrl}/delete/${catId}/category`, { params: params });
  }
  public update(catId: any, category: Category): Observable<Category> {
    // let params = new HttpParams().set('id', catId);
    return this.http.put<Category>(`${this.categoryUrl}/update/${catId}/category`, category)
  }

}
