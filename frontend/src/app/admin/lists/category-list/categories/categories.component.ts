import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';
@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories: Category[] = [];
  constructor(
    private categoryService: CategoryService,
    private router: Router,
    private routeActived: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    })
  }

  onDelete(catId: any) {
    this.categoryService.delete(catId).subscribe(data => {
      this.goToListCatategories();
    });
  }

  goToListCatategories() {
    this.router.navigate(['/list']);
    window.location.reload();
  }

}
