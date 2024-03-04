import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/auth/model/user';
import { AuthorizationService } from 'src/app/auth/service/authorization.service';

@Component({
  selector: 'app-users-registered',
  templateUrl: './users-registered.component.html',
  styleUrls: ['./users-registered.component.css']
})
export class UsersRegisteredComponent implements OnInit {
  users?: User[] = [];

  constructor(private authorizationService: AuthorizationService) {
    this.getAllUsers();
  }

  ngOnInit(): void {
  }
  
  getAllUsers() {
    this.authorizationService.findAll().subscribe(data => {
      this.users = data;
    });
  }
  onDelete() {

  }
 
}
