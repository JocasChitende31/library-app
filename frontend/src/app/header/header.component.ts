import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input() isAuthenticated: any
 
  constructor(private route: ActivatedRoute, private router: Router) {
    this.getLoggedName();
    this.getLoggedUserRole();
  }

  ngOnInit(): void {
  
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
