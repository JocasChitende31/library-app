import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  admin = 'ADMIN';

  constructor(

  ) {
    this.getLoggedName();
  }

  ngOnInit(): void {

  }

  getLoggedName(){
    return localStorage.getItem('userLogged');
  }
}
