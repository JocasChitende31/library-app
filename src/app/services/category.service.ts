import { HttpClient } from '@angular/common/http';
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

  public findAll(): Observable<Category[]>{
    return this.http.get<Category[]>(`${this.categoryUrl}/categories`)}
}
