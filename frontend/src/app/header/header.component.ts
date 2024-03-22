import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthorizationService } from '../auth/service/authorization.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

userOn?: String;
  @Input() isAuthenticated: any

  constructor(private route: ActivatedRoute, private router: Router, private userService: AuthorizationService) {
    this.getLoggedName();
    this.getLoggedUserRole();

    let userLogged = localStorage.getItem("userLogged");
    if(userLogged) this.findUserLogged(userLogged);
  }

  ngOnInit(): void {

  }

  findUserLogged(userLogged:any){
    this.userService.getByLogin(userLogged).subscribe(data=>{
      this.userOn = data.id;
  })
  }
  getLoggedName(){
    return localStorage.getItem('userLogged');
  }
  getLoggedUserRole(){
    return localStorage.getItem('role');
  }

  logout() {
    localStorage.clear();
    this.redirectTo();
  }

  redirectTo() {
    this.router.navigate(['/login']);
  }

}
