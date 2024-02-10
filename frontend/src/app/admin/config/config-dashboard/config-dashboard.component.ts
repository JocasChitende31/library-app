import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-config-dashboard',
  templateUrl: './config-dashboard.component.html',
  styleUrls: ['./config-dashboard.component.css'],
})
export class ConfigDashboardComponent implements OnInit {
  
  constructor() { 
    this.getLoggedName();
  }

  ngOnInit(): void {
    
  }
  getLoggedName(){
    return localStorage.getItem('userLogged');
  }
}
