import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Perfil } from '../../model/perfil';
import { AuthorizationService } from '../../service/authorization.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  userLogged?: Perfil;

  constructor(private route: ActivatedRoute, private authorizationService: AuthorizationService) {
    this.getPrifileInfo();
    this.getLoggedRoleUser();
  }

  ngOnInit(): void {
  }

  getPrifileInfo() {
    const login = localStorage.getItem('userLogged');
    this.authorizationService.getByLogin(login).subscribe(data => {
      this.userLogged = data;
     /*  const role = JSON.stringify(data.role);
      const userRole = JSON.parse(role);
      localStorage.setItem("role", userRole); */
      /* console.info(data); */
    })
  }
  getLoggedRoleUser(){
    return localStorage.getItem("role");
  }
}
