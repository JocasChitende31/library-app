import { Component, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthorizationService } from '../../service/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() isAuthenticate: Boolean = false;

  loginForm = new FormGroup({
    login: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })
  constructor(private router: Router, private authorizationService: AuthorizationService) {

  }

  ngOnInit(): void {

  }

  login() {
    if (this.loginForm.valid) {
      this.authorizationService.login(this.loginForm.value).subscribe(data => {
          if(data){
            var username = this.loginForm.get('login')?.value;
            this.authorizationService.getByLogin(username).subscribe(logged => {
              var obj = JSON.stringify(data);
              var token = JSON.parse(obj);
              const role = JSON.stringify(logged.role);
              const userRole = JSON.parse(role);
              localStorage.setItem('token', token.token);
              localStorage.setItem('userLogged', username);
              localStorage.setItem("role", userRole);
              this.router.navigate(['/books']);
              /* console.info(localStorage.getItem('token')); */
            })
          }
      })
    }
    /* return this.isAuthenticate = true; */
  }

  logout() {
    this.redirectTo();
    localStorage.clear();
    /*   return this.isAuthenticate = false;  */

  }

  redirectTo() {
    this.router.navigate(['/login']);
  }

}
