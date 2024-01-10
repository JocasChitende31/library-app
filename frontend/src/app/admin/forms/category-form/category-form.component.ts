import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  // category: Category;
  categoryForm = new FormGroup({
    id: new FormControl(''),
    genre: new FormControl('', Validators.required)
  });

  catId: any;
  titleCreateCategory = "Adicionar Categoria";
  titleUpdateCategory = "Actualizar Registo da Categoria"

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) {
    // this.category = new Category();
  }
  ngOnInit(): void {
    this.catId = this.route.snapshot.paramMap.get('id');
    if (this.catId) {
      this.categoryService.findById(this.catId).subscribe(res => {
        this.categoryForm.patchValue({
          id: res.id,
          genre: res.genre
        })
      })
    }
  }

  categorySubmit() {
    if (this.categoryForm.valid) {
      this.categoryService.save(this.categoryForm.value).subscribe(result => {
        this.goToList();
        this.categoryForm.reset();
      });
    }
  }

  updateCategory() {
    if (this.categoryForm.valid) {
      this.categoryService.update(this.catId, this.categoryForm.value).subscribe(res => {
        this.goToList();
      })
    }
  }

  goToList() {
    this.router.navigate(['/admin/categories']);
  }
}
