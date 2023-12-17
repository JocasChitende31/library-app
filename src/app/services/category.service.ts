import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categoryUrl: String;

  constructor(private http: HttpClient) {
    this.categoryUrl = "http://localhost:8080/api";
  }

  public findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoryUrl}/categories`)
  }
  public findById(catId: any): Observable<Category> {
    let params = new HttpParams().set('id', catId);
    return this.http.get<Category>(`${this.categoryUrl}/${catId}/category`, { params: params })
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
