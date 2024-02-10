import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DISABLE_GLOBAL_EXCEPTION_HANDLING } from 'src/app/core/interceptors/token.interceptor';
import { AppConstants } from 'src/app/env/app-constants';
import { Perfil } from '../model/perfil';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})

export class AuthorizationService {
  baseUrl: String;


  constructor(private http: HttpClient) {
    this.baseUrl = AppConstants.baseUrlAuth;
  }

  public login(user: User) {
    return this.http.post(this.baseUrl + '/login', user, { context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) });

  }
  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl + '/users');
  }
  public getByLogin(login: any): Observable<Perfil> {
    return this.http.get<Perfil>(this.baseUrl + `/user/${login}`, { context: new HttpContext().set(DISABLE_GLOBAL_EXCEPTION_HANDLING, true) });
  }
}
