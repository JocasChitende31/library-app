import {
  HttpContextToken,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';
export const DISABLE_GLOBAL_EXCEPTION_HANDLING = new HttpContextToken<boolean>(() => false);
@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private router: Router) {

  }
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.ignoreErrorHandling(request)) {
      return next.handle(request);
    }
    let token = localStorage.getItem('token');
    request = request.clone({ headers: request.headers.set('Authorization', 'Bearer ' + token) });
    return next.handle(request).pipe(catchError((error) => {
      return throwError(() => {
        if(error.status === 403){
          this.router.navigate(['/login']);
          localStorage.clear();
        }
      });
    }));
  }
  ignoreErrorHandling(request: HttpRequest<unknown>) {
    return request.context.get(DISABLE_GLOBAL_EXCEPTION_HANDLING);
  }
}
